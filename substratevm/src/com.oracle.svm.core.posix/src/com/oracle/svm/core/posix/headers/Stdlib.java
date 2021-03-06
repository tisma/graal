/*
 * Copyright (c) 2013, 2017, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */
package com.oracle.svm.core.posix.headers;

import org.graalvm.nativeimage.c.CContext;
import org.graalvm.nativeimage.c.function.CFunction;
import org.graalvm.nativeimage.c.type.CCharPointer;

//Checkstyle: stop

/**
 * Contains the definitions from stdlib.h that we actually needed.
 */
@CContext(PosixDirectives.class)
public class Stdlib {

    /**
     * Return the canonical absolute name of file NAME. If RESOLVED is null, the result is malloc'd;
     * otherwise, if the canonical name is PATH_MAX chars or more, returns null with `errno' set to
     * ENAMETOOLONG; if the name fits in fewer than PATH_MAX chars, returns the name in RESOLVED.
     */
    @CFunction
    public static native CCharPointer realpath(CCharPointer name, CCharPointer resolved);

    @CFunction
    public static native CCharPointer mkdtemp(CCharPointer template);

    @CFunction
    public static native CCharPointer getenv(CCharPointer name);

    @CFunction
    public static native int setenv(CCharPointer name, CCharPointer value, int overwrite);

    @CFunction
    public static native int unsetenv(CCharPointer name);
}
