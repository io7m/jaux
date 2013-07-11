package com.io7m.jaux.tests;

import org.junit.Assert;
import org.junit.Test;

import com.io7m.jaux.UnreachableCodeException;

public class UnreachableCodeExceptionTest
{
  @SuppressWarnings("static-method") @Test public
    void
    testNoArgumentConstructor()
  {
    try {
      throw new UnreachableCodeException();
    } catch (final UnreachableCodeException e) {
      Assert.assertEquals(
        "Unexpectedly reached unreachable code: report this bug",
        e.getMessage());
    }
  }
}
