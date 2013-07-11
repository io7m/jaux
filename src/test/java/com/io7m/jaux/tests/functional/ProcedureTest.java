package com.io7m.jaux.tests.functional;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Assert;
import org.junit.Test;

import com.io7m.jaux.functional.Procedure;

public class ProcedureTest
{
  @SuppressWarnings("static-method") @Test public void testCorrect()
  {
    final AtomicInteger value = new AtomicInteger(0);

    final Procedure<Integer> f = new Procedure<Integer>() {
      @Override public void call(
        final Integer x)
      {
        value.addAndGet(x.intValue());
      }
    };

    f.call(Integer.valueOf(32));

    Assert.assertEquals(32, value.intValue());
  }
}
