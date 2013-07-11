package com.io7m.jaux.tests;

import org.junit.Assert;
import org.junit.Test;

import com.io7m.jaux.UnimplementedCodeException;

public class UnimplementedCodeExceptionTest
{
  @SuppressWarnings("static-method") @Test public
    void
    testNoArgumentConstructor()
  {
    try {
      throw new UnimplementedCodeException();
    } catch (final UnimplementedCodeException e) {
      Assert.assertEquals(
        "Reached unimplemented code: report this bug",
        e.getMessage());
    }
  }
}
