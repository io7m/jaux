package com.io7m.jaux.tests.functional;

import org.junit.Assert;
import org.junit.Test;

import com.io7m.jaux.functional.Pair;

public class PairTest
{
  @SuppressWarnings("static-method") @Test public void testCorrect()
  {
    final Pair<Integer, String> p =
      new Pair<Integer, String>(Integer.valueOf(23), "hello");
    Assert.assertEquals(Integer.valueOf(23), p.first);
    Assert.assertEquals("hello", p.second);
  }

  @SuppressWarnings("static-method") @Test public void testEquals()
  {
    final Pair<Integer, Integer> p0 =
      new Pair<Integer, Integer>(Integer.valueOf(23), Integer.valueOf(23));
    final Pair<Integer, Integer> p1 =
      new Pair<Integer, Integer>(Integer.valueOf(23), Integer.valueOf(23));
    final Pair<Integer, Integer> p2 =
      new Pair<Integer, Integer>(null, Integer.valueOf(23));
    final Pair<Integer, Integer> p3 =
      new Pair<Integer, Integer>(Integer.valueOf(23), null);
    final Pair<Integer, Integer> p4 =
      new Pair<Integer, Integer>(Integer.valueOf(32), Integer.valueOf(23));
    final Pair<Integer, Integer> p5 =
      new Pair<Integer, Integer>(Integer.valueOf(23), Integer.valueOf(32));

    Assert.assertEquals(p0, p0);
    Assert.assertFalse(p0.equals(null));
    Assert.assertFalse(p0.equals("hello"));
    Assert.assertFalse(p2.equals(p3));
    Assert.assertFalse(p3.equals(p2));
    Assert.assertFalse(p4.equals(p5));
    Assert.assertFalse(p5.equals(p4));
    Assert.assertEquals(p1, p0);
    Assert.assertEquals(p0, p1);
  }

  @SuppressWarnings("static-method") @Test public void testHashCode()
  {
    final Pair<Integer, Integer> p0 =
      new Pair<Integer, Integer>(Integer.valueOf(23), Integer.valueOf(23));
    final Pair<Integer, Integer> p1 =
      new Pair<Integer, Integer>(Integer.valueOf(23), Integer.valueOf(23));

    Assert.assertEquals(p0.hashCode(), p1.hashCode());
  }

  @SuppressWarnings("static-method") @Test public void testStrings()
  {
    final Pair<Integer, Integer> p0 =
      new Pair<Integer, Integer>(Integer.valueOf(23), Integer.valueOf(23));
    final Pair<Integer, Integer> p1 =
      new Pair<Integer, Integer>(Integer.valueOf(24), Integer.valueOf(23));
    final Pair<Integer, Integer> p2 =
      new Pair<Integer, Integer>(Integer.valueOf(23), Integer.valueOf(24));
    final Pair<Integer, Integer> p3 =
      new Pair<Integer, Integer>(Integer.valueOf(23), Integer.valueOf(23));

    Assert.assertFalse(p0.toString().equals(p1.toString()));
    Assert.assertFalse(p0.toString().equals(p2.toString()));
    Assert.assertTrue(p0.toString().equals(p0.toString()));
    Assert.assertTrue(p0.toString().equals(p3.toString()));
  }
}
