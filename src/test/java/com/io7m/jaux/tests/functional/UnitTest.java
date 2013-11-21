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

import com.io7m.jaux.functional.Unit;

public class UnitTest
{
  @SuppressWarnings("static-method") @Test public void testEqualsCorrect0()
  {
    Assert.assertEquals(new Unit(), new Unit());
  }

  @SuppressWarnings("static-method") @Test public void testEqualsCorrect1()
  {
    Assert.assertNotSame(null, new Unit());
  }

  @SuppressWarnings("static-method") @Test public void testEqualsCorrect2()
  {
    Assert.assertFalse(new Unit().equals(null));
  }

  @SuppressWarnings("static-method") @Test public void testEqualsCorrect3()
  {
    final Unit u = new Unit();
    Assert.assertEquals(u, u);
  }

  @SuppressWarnings("static-method") @Test public void testEqualsCorrect4()
  {
    Assert.assertFalse(new Unit().equals(Integer.valueOf(23)));
  }

  @SuppressWarnings("static-method") @Test public
    void
    testEqualsCorrectValue0()
  {
    Assert.assertEquals(Unit.value, new Unit());
    Assert.assertEquals(Unit.unit(), new Unit());
  }

  @SuppressWarnings("static-method") @Test public
    void
    testEqualsCorrectValue1()
  {
    Assert.assertNotSame(Unit.value, null);
    Assert.assertNotSame(Unit.unit(), null);
  }

  @SuppressWarnings("static-method") @Test public
    void
    testEqualsCorrectValue2()
  {
    Assert.assertNotSame(null, Unit.value);
  }

  @SuppressWarnings("static-method") @Test public
    void
    testEqualsCorrectValue3()
  {
    final Unit u = new Unit();
    Assert.assertEquals(Unit.value, u);
  }

  @SuppressWarnings("static-method") @Test public void testHashCode()
  {
    Assert.assertEquals(new Unit().hashCode(), Unit.UNIT_HASH_CODE);
  }
}
