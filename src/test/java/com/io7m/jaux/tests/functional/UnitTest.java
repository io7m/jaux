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
  }

  @SuppressWarnings("static-method") @Test public
    void
    testEqualsCorrectValue1()
  {
    Assert.assertNotSame(Unit.value, null);
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
