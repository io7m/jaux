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
