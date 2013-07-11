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

import com.io7m.jaux.Constraints.ConstraintError;
import com.io7m.jaux.RangeInclusive;

public class RangeInclusiveTest
{
  @SuppressWarnings("static-method") @Test public void testEquals()
    throws ConstraintError
  {
    final RangeInclusive ri0 = new RangeInclusive(0, 99);
    final RangeInclusive ri1 = new RangeInclusive(0, 99);
    final RangeInclusive ri2 = new RangeInclusive(1, 99);
    final RangeInclusive ri3 = new RangeInclusive(0, 98);

    Assert.assertEquals(ri0, ri0);
    Assert.assertEquals(ri0, ri1);

    Assert.assertFalse(ri0.equals(ri2));
    Assert.assertFalse(ri0.equals(ri3));
    Assert.assertFalse(ri2.equals(ri3));
    Assert.assertFalse(ri0.equals(null));
    Assert.assertFalse(ri0.equals(Integer.valueOf(23)));
  }

  @SuppressWarnings({ "unused", "static-method" }) @Test(
    expected = ConstraintError.class) public void testFailedInvariant()
    throws ConstraintError
  {
    new RangeInclusive(1, 0);
  }

  @SuppressWarnings("static-method") @Test public void testHashcode()
    throws ConstraintError
  {
    final RangeInclusive ri0 = new RangeInclusive(0, 99);
    final RangeInclusive ri1 = new RangeInclusive(0, 99);
    final RangeInclusive ri2 = new RangeInclusive(1, 99);
    final RangeInclusive ri3 = new RangeInclusive(0, 98);

    Assert.assertEquals(ri0.hashCode(), ri0.hashCode());
    Assert.assertEquals(ri0.hashCode(), ri1.hashCode());

    Assert.assertFalse(ri0.hashCode() == ri2.hashCode());
    Assert.assertFalse(ri0.hashCode() == ri3.hashCode());
    Assert.assertFalse(ri2.hashCode() == ri3.hashCode());
  }

  @SuppressWarnings("static-method") @Test public void testIdentities()
    throws ConstraintError
  {
    final RangeInclusive ri = new RangeInclusive(0, 99);
    Assert.assertEquals(0, ri.getLower());
    Assert.assertEquals(99, ri.getUpper());
  }

  @SuppressWarnings("static-method") @Test public void testInterval()
    throws ConstraintError
  {
    final RangeInclusive ri0 = new RangeInclusive(0, 99);
    final RangeInclusive ri1 = new RangeInclusive(-99, 0);

    Assert.assertEquals(100, ri0.getInterval());
    Assert.assertEquals(100, ri1.getInterval());
  }

  @SuppressWarnings("static-method") @Test public void testRangeIncluded()
    throws ConstraintError
  {
    final RangeInclusive ri0 = new RangeInclusive(0, 9);
    final RangeInclusive ri1 = new RangeInclusive(0, 7);
    final RangeInclusive ri2 = new RangeInclusive(2, 9);

    Assert.assertTrue(ri1.isIncludedIn(ri0));
    Assert.assertTrue(ri2.isIncludedIn(ri0));
    Assert.assertTrue(ri0.isIncludedIn(ri0));

    Assert.assertFalse(ri0.isIncludedIn(ri1));
    Assert.assertFalse(ri0.isIncludedIn(ri2));
  }

  @SuppressWarnings("static-method") @Test public void testToString()
    throws ConstraintError
  {
    final RangeInclusive ri0 = new RangeInclusive(0, 99);
    final RangeInclusive ri1 = new RangeInclusive(0, 99);
    final RangeInclusive ri2 = new RangeInclusive(1, 99);
    final RangeInclusive ri3 = new RangeInclusive(0, 98);

    Assert.assertEquals(ri0.toString(), ri0.toString());
    Assert.assertEquals(ri0.toString(), ri1.toString());

    Assert.assertFalse(ri0.toString().equals(ri2.toString()));
    Assert.assertFalse(ri0.toString().equals(ri3.toString()));
    Assert.assertFalse(ri2.toString().equals(ri3.toString()));
  }
}
