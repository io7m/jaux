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
