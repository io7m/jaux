package com.io7m.jaux.tests.functional;

import org.junit.Assert;
import org.junit.Test;

import com.io7m.jaux.functional.Option;
import com.io7m.jaux.functional.Option.None;
import com.io7m.jaux.functional.Option.Some;
import com.io7m.jaux.functional.Option.Type;

public class OptionTest
{
  @Test public void testNone()
  {
    final Option<Integer> n = new Option.None<Integer>();
    Assert.assertEquals(Type.OPTION_NONE, n.type);
    Assert.assertTrue(n.isNone());
    Assert.assertFalse(n.isSome());
  }

  @Test public void testNoneEquals()
  {
    final None<Integer> n0 = new None<Integer>();
    final None<Integer> n1 = new None<Integer>();

    Assert.assertTrue(n0.equals(n0));
    Assert.assertTrue(n0.equals(n1));
    Assert.assertTrue(n1.equals(n0));
    Assert.assertFalse(n0.equals(Integer.valueOf(23)));
    Assert.assertFalse(n0.equals(null));
  }

  @Test public void testNoneHashCode()
  {
    final None<Integer> n0 = new None<Integer>();
    final None<Integer> n1 = new None<Integer>();

    Assert.assertTrue(n0.hashCode() == n0.hashCode());
    Assert.assertTrue(n0.hashCode() == n1.hashCode());
    Assert.assertTrue(n1.hashCode() == n0.hashCode());
    Assert.assertFalse(n0.hashCode() == (Integer.valueOf(23).hashCode()));
  }

  @Test public void testNoneStrings()
  {
    final None<Integer> n0 = new None<Integer>();
    final None<Integer> n1 = new None<Integer>();

    Assert.assertTrue(n0.toString().equals(n0.toString()));
    Assert.assertTrue(n0.toString().equals(n1.toString()));
    Assert.assertTrue(n1.toString().equals(n0.toString()));
    Assert.assertFalse(n0.toString().equals(Integer.valueOf(23).toString()));
    Assert.assertFalse(n0.toString().equals(null));
  }

  @Test public void testSome()
  {
    final Option<Integer> n = new Option.Some<Integer>(new Integer(32));
    Assert.assertEquals(Type.OPTION_SOME, n.type);
    Assert.assertTrue(n.isSome());
    Assert.assertFalse(n.isNone());

    final Option.Some<Integer> i = (Some<Integer>) n;
    Assert.assertEquals(32, i.value.intValue());
  }

  @Test public void testSomeEquals()
  {
    final Some<Integer> n0 = new Some<Integer>(Integer.valueOf(23));
    final Some<Integer> n1 = new Some<Integer>(Integer.valueOf(23));
    final Some<Integer> n2 = new Some<Integer>(null);
    final Some<Integer> n3 = new Some<Integer>(null);

    Assert.assertTrue(n0.equals(n0));
    Assert.assertTrue(n0.equals(n1));
    Assert.assertTrue(n1.equals(n0));
    Assert.assertFalse(n0.equals(Integer.valueOf(23)));
    Assert.assertFalse(n0.equals(null));
    Assert.assertFalse(n0.equals(n2));
    Assert.assertFalse(n2.equals(n0));
    Assert.assertTrue(n2.equals(n3));
  }

  @Test public void testSomeHashCode()
  {
    final Some<Integer> n0 = new Some<Integer>(Integer.valueOf(23));
    final Some<Integer> n1 = new Some<Integer>(Integer.valueOf(23));

    Assert.assertTrue(n0.hashCode() == n0.hashCode());
    Assert.assertTrue(n0.hashCode() == n1.hashCode());
    Assert.assertTrue(n1.hashCode() == n0.hashCode());
    Assert.assertFalse(n0.hashCode() == (Integer.valueOf(23).hashCode()));
  }

  @Test public void testSomeStrings()
  {
    final Some<Integer> n0 = new Some<Integer>(Integer.valueOf(23));
    final Some<Integer> n1 = new Some<Integer>(Integer.valueOf(23));

    Assert.assertTrue(n0.toString().equals(n0.toString()));
    Assert.assertTrue(n0.toString().equals(n1.toString()));
    Assert.assertTrue(n1.toString().equals(n0.toString()));
    Assert.assertFalse(n0.toString().equals(Integer.valueOf(23).toString()));
    Assert.assertFalse(n0.toString().equals(null));
  }
}
