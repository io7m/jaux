package com.io7m.jaux.tests.functional;

import org.junit.Assert;
import org.junit.Test;

import com.io7m.jaux.functional.Indeterminate;
import com.io7m.jaux.functional.Indeterminate.Failure;
import com.io7m.jaux.functional.Indeterminate.Success;
import com.io7m.jaux.functional.Indeterminate.Type;

public class IndeterminateTest
{
  @Test public void testEquals()
  {
    final Indeterminate.Success<Integer, String> s0 =
      new Indeterminate.Success<Integer, String>(Integer.valueOf(23));
    final Indeterminate.Success<Integer, String> s1 =
      new Indeterminate.Success<Integer, String>(Integer.valueOf(23));
    final Indeterminate.Success<Integer, String> s2 =
      new Indeterminate.Success<Integer, String>(Integer.valueOf(32));
    final Indeterminate.Success<Integer, String> s3 =
      new Indeterminate.Success<Integer, String>(null);

    final Indeterminate.Failure<Integer, String> f0 =
      new Indeterminate.Failure<Integer, String>("failure");
    final Indeterminate.Failure<Integer, String> f1 =
      new Indeterminate.Failure<Integer, String>("failure");
    final Indeterminate.Failure<Integer, String> f2 =
      new Indeterminate.Failure<Integer, String>("failure again");
    final Indeterminate.Failure<Integer, String> f3 =
      new Indeterminate.Failure<Integer, String>(null);

    Assert.assertEquals(s0, s1);
    Assert.assertFalse(s0.equals(s2));
    Assert.assertEquals(s0, s0);
    Assert.assertFalse(s0.equals(Integer.valueOf(23)));
    Assert.assertFalse(s0.equals(null));
    Assert.assertFalse(s0.equals(s3));
    Assert.assertFalse(s3.equals(s0));

    Assert.assertEquals(f0, f1);
    Assert.assertFalse(f0.equals(f2));
    Assert.assertEquals(f0, f0);
    Assert.assertFalse(f0.equals(Integer.valueOf(23)));
    Assert.assertFalse(f0.equals(null));
    Assert.assertFalse(f0.equals(f3));
    Assert.assertFalse(f3.equals(f0));

    Assert.assertFalse(s0.equals(f0));
    Assert.assertFalse(f0.equals(s0));
  }

  @Test public void testFailure()
  {
    final Indeterminate<Integer, String> i =
      new Indeterminate.Failure<Integer, String>("failure");
    Assert.assertEquals(Type.FAILURE, i.type);
    Assert.assertTrue(i.isFailure());
    Assert.assertFalse(i.isSuccess());

    final Indeterminate.Failure<Integer, String> f =
      (Failure<Integer, String>) i;
    Assert.assertEquals("failure", f.value);
  }

  @Test public void testFailureString()
  {
    final Indeterminate.Failure<Integer, String> f0 =
      new Indeterminate.Failure<Integer, String>("failure");
    final Indeterminate.Failure<Integer, String> f1 =
      new Indeterminate.Failure<Integer, String>("failure");
    final Indeterminate.Failure<Integer, String> f2 =
      new Indeterminate.Failure<Integer, String>("failure again");
    final Indeterminate.Failure<Integer, String> f3 =
      new Indeterminate.Failure<Integer, String>(null);

    Assert.assertEquals(f0.toString(), f1.toString());
    Assert.assertFalse(f0.toString().equals(f2.toString()));
    Assert.assertEquals(f0.toString(), f0.toString());
    Assert.assertFalse(f0.toString().equals(null));
    Assert.assertFalse(f0.toString().equals(f3.toString()));
    Assert.assertFalse(f3.toString().equals(f0.toString()));
  }

  @Test public void testHashcode()
  {
    final Indeterminate.Success<Integer, String> s0 =
      new Indeterminate.Success<Integer, String>(Integer.valueOf(23));
    final Indeterminate.Success<Integer, String> s1 =
      new Indeterminate.Success<Integer, String>(Integer.valueOf(23));
    final Indeterminate.Success<Integer, String> s2 =
      new Indeterminate.Success<Integer, String>(Integer.valueOf(32));
    final Indeterminate.Success<Integer, String> s3 =
      new Indeterminate.Success<Integer, String>(null);

    final Indeterminate.Failure<Integer, String> f0 =
      new Indeterminate.Failure<Integer, String>("failure");
    final Indeterminate.Failure<Integer, String> f1 =
      new Indeterminate.Failure<Integer, String>("failure");
    final Indeterminate.Failure<Integer, String> f2 =
      new Indeterminate.Failure<Integer, String>("failure again");
    final Indeterminate.Failure<Integer, String> f3 =
      new Indeterminate.Failure<Integer, String>(null);

    Assert.assertEquals(s0.hashCode(), s1.hashCode());
    Assert.assertFalse(s0.hashCode() == s2.hashCode());
    Assert.assertEquals(s0.hashCode(), s0.hashCode());
    Assert.assertFalse(s0.hashCode() == Integer.valueOf(23).hashCode());
    Assert.assertFalse(s0.hashCode() == s3.hashCode());
    Assert.assertFalse(s3.hashCode() == s0.hashCode());

    Assert.assertEquals(f0.hashCode(), f1.hashCode());
    Assert.assertFalse(f0.hashCode() == f2.hashCode());
    Assert.assertEquals(f0.hashCode(), f0.hashCode());
    Assert.assertFalse(f0.hashCode() == Integer.valueOf(23).hashCode());
    Assert.assertFalse(f0.hashCode() == f3.hashCode());
    Assert.assertFalse(f3.hashCode() == f0.hashCode());

    Assert.assertFalse(s0.hashCode() == f0.hashCode());
    Assert.assertFalse(f0.hashCode() == s0.hashCode());
  }

  @Test public void testIndeterminateString()
  {
    final Indeterminate.Failure<Integer, String> i0 =
      new Indeterminate.Failure<Integer, String>("failure");
    final Indeterminate.Failure<Integer, String> i1 =
      new Indeterminate.Failure<Integer, String>("failure");
    final Indeterminate.Failure<Integer, String> i2 =
      new Indeterminate.Failure<Integer, String>("failure again");
    final Indeterminate.Failure<Integer, String> i3 =
      new Indeterminate.Failure<Integer, String>(null);

    Assert.assertEquals(i0.toString(), i1.toString());
    Assert.assertFalse(i0.toString().equals(i2.toString()));
    Assert.assertEquals(i0.toString(), i0.toString());
    Assert.assertFalse(i0.toString().equals(null));
    Assert.assertFalse(i0.toString().equals(i3.toString()));
    Assert.assertFalse(i3.toString().equals(i0.toString()));
  }

  @Test public void testSuccess()
  {
    final Indeterminate<Integer, String> i =
      new Indeterminate.Success<Integer, String>(Integer.valueOf(100));
    Assert.assertEquals(Type.SUCCESS, i.type);
    Assert.assertTrue(i.isSuccess());
    Assert.assertFalse(i.isFailure());

    final Indeterminate.Success<Integer, String> s =
      (Success<Integer, String>) i;
    Assert.assertEquals(Integer.valueOf(100), s.value);
  }

  @Test public void testSuccessString()
  {
    final Indeterminate.Success<Integer, String> s0 =
      new Indeterminate.Success<Integer, String>(Integer.valueOf(23));
    final Indeterminate.Success<Integer, String> s1 =
      new Indeterminate.Success<Integer, String>(Integer.valueOf(23));
    final Indeterminate.Success<Integer, String> s2 =
      new Indeterminate.Success<Integer, String>(Integer.valueOf(32));
    final Indeterminate.Success<Integer, String> s3 =
      new Indeterminate.Success<Integer, String>(null);

    Assert.assertEquals(s0.toString(), s1.toString());
    Assert.assertFalse(s0.toString().equals(s2.toString()));
    Assert.assertEquals(s0.toString(), s0.toString());
    Assert.assertFalse(s0.toString().equals(null));
    Assert.assertFalse(s0.toString().equals(s3.toString()));
    Assert.assertFalse(s3.toString().equals(s0.toString()));
  }
}
