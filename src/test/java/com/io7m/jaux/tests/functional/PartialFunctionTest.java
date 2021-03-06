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

package com.io7m.jaux.tests.functional;

import org.junit.Assert;
import org.junit.Test;

import com.io7m.jaux.Constraints.ConstraintError;
import com.io7m.jaux.functional.PartialFunction;

public class PartialFunctionTest
{
  @SuppressWarnings("static-method") @Test public void testCorrect()
    throws ConstraintError
  {
    final PartialFunction<Integer, Integer, ConstraintError> f =
      new PartialFunction<Integer, Integer, ConstraintError>() {
        @Override public Integer call(
          final Integer x)
        {
          return Integer.valueOf(x.intValue() * 3);
        }
      };

    Assert.assertEquals(Integer.valueOf(96), f.call(Integer.valueOf(32)));
  }

  @SuppressWarnings("static-method") @Test public void testRaise()
  {
    try {
      final PartialFunction<Integer, Integer, ConstraintError> f =
        new PartialFunction<Integer, Integer, ConstraintError>() {
          @Override public Integer call(
            final Integer x)
            throws ConstraintError
          {
            throw new ConstraintError("test");
          }
        };

      f.call(Integer.valueOf(64));
    } catch (final ConstraintError e) {
      Assert.assertEquals("test", e.getMessage());
    }
  }
}
