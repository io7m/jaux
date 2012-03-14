package com.io7m.jaux.tests.functional;

import junit.framework.Assert;

import org.junit.Test;

import com.io7m.jaux.functional.Unit;

public class UnitTest
{
  @Test public void testEqualsCorrect0()
  {
    Assert.assertEquals(new Unit(), new Unit());
  }

  @Test public void testEqualsCorrect1()
  {
    Assert.assertNotSame(null, new Unit());
  }

  @Test public void testEqualsCorrect2()
  {
    Assert.assertFalse(new Unit().equals(null));
  }

  @Test public void testEqualsCorrect3()
  {
    final Unit u = new Unit();
    Assert.assertEquals(u, u);
  }

  @Test public void testEqualsCorrect4()
  {
    Assert.assertFalse(new Unit().equals(Integer.valueOf(23)));
  }

  @Test public void testEqualsCorrectValue0()
  {
    Assert.assertEquals(Unit.value, new Unit());
  }

  @Test public void testEqualsCorrectValue1()
  {
    Assert.assertNotSame(Unit.value, null);
  }

  @Test public void testEqualsCorrectValue2()
  {
    Assert.assertNotSame(null, Unit.value);
  }

  @Test public void testEqualsCorrectValue3()
  {
    final Unit u = new Unit();
    Assert.assertEquals(Unit.value, u);
  }

  @Test public void testHashCode()
  {
    Assert.assertEquals(new Unit().hashCode(), Unit.UNIT_HASH_CODE);
  }
}
