/*
 * Copyright © 2012 http://io7m.com
 * 
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY
 * SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF OR
 * IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */

package com.io7m.jaux.tests;

import java.util.regex.Pattern;

import junit.framework.Assert;

import org.junit.Test;

import com.io7m.jaux.Constraints;
import com.io7m.jaux.Constraints.ConstraintError;

public class ConstraintsTest
{
  /*
   * Range (int).
   */

  @Test(expected = ConstraintError.class) public void testArbitraryFalse()
    throws ConstraintError
  {
    try {
      Constraints.constrainArbitrary(false, "true");
    } catch (final ConstraintError e) {
      Assert.assertTrue(e.getMessage().startsWith("expression 'true'"));
      throw e;
    }
  }

  @Test(expected = ConstraintError.class) public void testArbitraryNull()
    throws ConstraintError
  {
    try {
      Constraints.constrainArbitrary(false, null);
    } catch (final ConstraintError e) {
      Assert.assertTrue(e.getMessage().startsWith("expression 'null'"));
      throw e;
    }
  }

  @Test public void testArbitraryTrue()
    throws ConstraintError
  {
    Constraints.constrainArbitrary(true, "true");
  }

  @SuppressWarnings("boxing") @Test public void testLessThanDouble()
    throws ConstraintError
  {
    Assert.assertEquals(
      0.0,
      Constraints.constrainLessThan(0.0, 10.0, "something"));
    Assert.assertEquals(0.0, Constraints.constrainLessThan(0.0, 10.0));
  }

  @SuppressWarnings("boxing") @Test public void testLessThanFloat()
    throws ConstraintError
  {
    Assert.assertEquals(
      0.0f,
      Constraints.constrainLessThan(0.0f, 10.0f, "something"));
    Assert.assertEquals(0.0f, Constraints.constrainLessThan(0.0f, 10.0f));
  }

  /*
   * Range (long).
   */

  @Test public void testLessThanInt()
    throws ConstraintError
  {
    Assert.assertEquals(0, Constraints.constrainLessThan(0, 10, "something"));
    Assert.assertEquals(0, Constraints.constrainLessThan(0, 10));
  }

  @Test public void testLessThanLong()
    throws ConstraintError
  {
    Assert.assertEquals(
      0L,
      Constraints.constrainLessThan(0L, 10L, "something"));
    Assert.assertEquals(0L, Constraints.constrainLessThan(0L, 10L));
  }

  @Test(expected = ConstraintError.class) public void testLessThanOutDouble()
    throws ConstraintError
  {
    try {
      Constraints.constrainLessThan(10.0, 0.0, "something");
    } catch (final ConstraintError e) {
      Assert.assertTrue(e.getMessage().startsWith("something"));
      throw e;
    }
  }

  @Test(expected = ConstraintError.class) public void testLessThanOutFloat()
    throws ConstraintError
  {
    try {
      Constraints.constrainLessThan(10.0f, 0.0f, "something");
    } catch (final ConstraintError e) {
      Assert.assertTrue(e.getMessage().startsWith("something"));
      throw e;
    }
  }

  @Test(expected = ConstraintError.class) public void testLessThanOutInt()
    throws ConstraintError
  {
    try {
      Constraints.constrainLessThan(10, 0, "something");
    } catch (final ConstraintError e) {
      Assert.assertTrue(e.getMessage().startsWith("something"));
      throw e;
    }
  }

  /*
   * Range (double).
   */

  @Test(expected = ConstraintError.class) public void testLessThanOutLong()
    throws ConstraintError
  {
    try {
      Constraints.constrainLessThan(10L, 0L, "something");
    } catch (final ConstraintError e) {
      Assert.assertTrue(e.getMessage().startsWith("something"));
      throw e;
    }
  }

  @Test public void testMatch()
    throws ConstraintError
  {
    final String x =
      Constraints.constrainStringMatch(
        "abcd",
        Pattern.compile("abcd"),
        "test_match");
    Assert.assertTrue(x.equals("abcd"));
  }

  @Test(expected = ConstraintError.class) public void testMatchNull0()
    throws ConstraintError
  {
    Constraints.constrainStringMatch(
      null,
      Pattern.compile("abcd"),
      "test_match");
  }

  @Test(expected = ConstraintError.class) public void testMatchNull1()
    throws ConstraintError
  {
    Constraints.constrainStringMatch("abcd", null, "test_match");
  }

  @Test(expected = ConstraintError.class) public void testNoMatch()
    throws ConstraintError
  {
    Constraints.constrainStringMatch(
      "abcd",
      Pattern.compile("xyz"),
      "test_match");
  }

  /*
   * Range (float).
   */

  @Test public void testNotNull()
    throws ConstraintError
  {
    final String value = Constraints.constrainNotNull("hello", "statement");
    Assert.assertTrue(value.equals("hello"));
  }

  @Test(expected = ConstraintError.class) public void testNotNullFailure()
    throws ConstraintError
  {
    try {
      Constraints.constrainNotNull(null, "statement");
    } catch (final ConstraintError e) {
      Assert.assertTrue(e.getMessage().startsWith("value 'statement'"));
      throw e;
    }
  }

  @Test(expected = ConstraintError.class) public
    void
    testNotNullMessageNull()
      throws ConstraintError
  {
    try {
      Constraints.constrainNotNull(null, null);
    } catch (final ConstraintError e) {
      Assert.assertTrue(e.getMessage().startsWith("value 'null'"));
      throw e;
    }
  }

  @Test(expected = ConstraintError.class) public void testRangeHighOut()
    throws ConstraintError
  {
    Constraints.constrainRange(11, 0, 10);
  }

  @Test(expected = ConstraintError.class) public
    void
    testRangeHighOutDouble()
      throws ConstraintError
  {
    Constraints.constrainRange(11.0, 0.0, 10.0);
  }

  /*
   * Less than.
   */

  @Test(expected = ConstraintError.class) public void testRangeHighOutFloat()
    throws ConstraintError
  {
    Constraints.constrainRange(11.0f, 0.0f, 10.0f);
  }

  @Test(expected = ConstraintError.class) public void testRangeHighOutLong()
    throws ConstraintError
  {
    Constraints.constrainRange(11L, 0L, 10L);
  }

  @Test(expected = ConstraintError.class) public
    void
    testRangeHighOutMessage()
      throws ConstraintError
  {
    try {
      Constraints.constrainRange(11, 0, 10, "hello");
    } catch (final ConstraintError e) {
      Assert.assertTrue(e.getMessage().startsWith("hello"));
      throw e;
    }
  }

  @Test(expected = ConstraintError.class) public
    void
    testRangeHighOutMessageDouble()
      throws ConstraintError
  {
    try {
      Constraints.constrainRange(11.0, 0.0, 10.0, "hello");
    } catch (final ConstraintError e) {
      Assert.assertTrue(e.getMessage().startsWith("hello"));
      throw e;
    }
  }

  @Test(expected = ConstraintError.class) public
    void
    testRangeHighOutMessageFloat()
      throws ConstraintError
  {
    try {
      Constraints.constrainRange(11.0f, 0.0f, 10.0f, "hello");
    } catch (final ConstraintError e) {
      Assert.assertTrue(e.getMessage().startsWith("hello"));
      throw e;
    }
  }

  @Test(expected = ConstraintError.class) public
    void
    testRangeHighOutMessageLong()
      throws ConstraintError
  {
    try {
      Constraints.constrainRange(11L, 0L, 10L, "hello");
    } catch (final ConstraintError e) {
      Assert.assertTrue(e.getMessage().startsWith("hello"));
      throw e;
    }
  }

  @Test public void testRangeIn()
    throws ConstraintError
  {
    for (int i = 0; i <= 10; ++i) {
      Assert.assertTrue(Constraints.constrainRange(i, 0, 10) == i);
    }
  }

  @Test public void testRangeInDouble()
    throws ConstraintError
  {
    for (double i = 0.0; i <= 10.0; ++i) {
      Assert.assertTrue(Constraints.constrainRange(i, 0.0, 10.0) == i);
    }
  }

  /*
   * Arbitrary.
   */

  @Test public void testRangeInFloat()
    throws ConstraintError
  {
    for (float i = 0.0f; i <= 10.0f; ++i) {
      Assert.assertTrue(Constraints.constrainRange(i, 0.0f, 10.0f) == i);
    }
  }

  @Test public void testRangeInLong()
    throws ConstraintError
  {
    for (long i = 0; i <= 10; ++i) {
      Assert.assertTrue(Constraints.constrainRange(i, 0L, 10L) == i);
    }
  }

  @Test(expected = ConstraintError.class) public void testRangeLowOut()
    throws ConstraintError
  {
    Constraints.constrainRange(-1, 0, 10);
  }

  /*
   * Not null.
   */

  @Test(expected = ConstraintError.class) public void testRangeLowOutDouble()
    throws ConstraintError
  {
    Constraints.constrainRange(-1.0, 0.0, 10.0);
  }

  @Test(expected = ConstraintError.class) public void testRangeLowOutFloat()
    throws ConstraintError
  {
    Constraints.constrainRange(-1.0f, 0.0f, 10.0f);
  }

  @Test(expected = ConstraintError.class) public void testRangeLowOutLong()
    throws ConstraintError
  {
    Constraints.constrainRange(-1L, 0L, 10L);
  }

  /*
   * Matching.
   */

  @Test(expected = ConstraintError.class) public
    void
    testRangeLowOutMessage()
      throws ConstraintError
  {
    try {
      Constraints.constrainRange(-1, 0, 10, "hello");
    } catch (final ConstraintError e) {
      Assert.assertTrue(e.getMessage().startsWith("hello"));
      throw e;
    }
  }

  @Test(expected = ConstraintError.class) public
    void
    testRangeLowOutMessageDouble()
      throws ConstraintError
  {
    try {
      Constraints.constrainRange(-1.0, 0.0, 10.0, "hello");
    } catch (final ConstraintError e) {
      Assert.assertTrue(e.getMessage().startsWith("hello"));
      throw e;
    }
  }

  @Test(expected = ConstraintError.class) public
    void
    testRangeLowOutMessageFloat()
      throws ConstraintError
  {
    try {
      Constraints.constrainRange(-1.0f, 0.0f, 10.0f, "hello");
    } catch (final ConstraintError e) {
      Assert.assertTrue(e.getMessage().startsWith("hello"));
      throw e;
    }
  }

  @Test(expected = ConstraintError.class) public
    void
    testRangeLowOutMessageLong()
      throws ConstraintError
  {
    try {
      Constraints.constrainRange(-1L, 0L, 10L, "hello");
    } catch (final ConstraintError e) {
      Assert.assertTrue(e.getMessage().startsWith("hello"));
      throw e;
    }
  }
}
