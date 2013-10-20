/*
 * Copyright © 2013 <code@io7m.com> http://io7m.com
 * 
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY
 * SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF OR
 * IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */

package com.io7m.jaux.tests;

import org.junit.Assert;
import org.junit.Test;

import com.io7m.jaux.UnreachableCodeException;

public class UnreachableCodeExceptionTest
{
  @SuppressWarnings("static-method") @Test public
    void
    testNoArgumentConstructor()
  {
    try {
      throw new UnreachableCodeException();
    } catch (final UnreachableCodeException e) {
      Assert.assertEquals(
        "Unexpectedly reached unreachable code: report this bug",
        e.getMessage());
    }
  }

  @SuppressWarnings("static-method") @Test public
    void
    testNoCauseConstructor()
  {
    final UnreachableCodeException x = new UnreachableCodeException();

    try {
      throw new UnreachableCodeException(x);
    } catch (final UnreachableCodeException e) {
      Assert.assertEquals(
        "Unexpectedly reached unreachable code: report this bug",
        e.getMessage());
      Assert.assertEquals(x, e.getCause());
    }
  }
}
