package com.io7m.jaux.tests.functional;

import junit.framework.Assert;

import org.junit.Test;

import com.io7m.jaux.functional.Function;

public class FunctionTest
{
  @SuppressWarnings("static-method") @Test public void testCorrect()
  {
    final Function<Integer, Integer> f = new Function<Integer, Integer>() {
      @Override public Integer call(
        final Integer x)
      {
        return Integer.valueOf(x.intValue() * 3);
      }
    };

    Assert.assertEquals(Integer.valueOf(96), f.call(Integer.valueOf(32)));
  }
}
