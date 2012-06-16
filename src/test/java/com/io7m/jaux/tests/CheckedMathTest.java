package com.io7m.jaux.tests;

import junit.framework.Assert;

import org.junit.Test;

import com.io7m.jaux.CheckedMath;

public class CheckedMathTest
{
  private static int randomInt()
  {
    return (int) (Math.random() * (1 << 30));
  }

  private static int randomLong()
  {
    return (int) (Math.random() * (1 << 62));
  }

  private static double randomSmallDouble()
  {
    return Math.random() * 65536.0;
  }

  private static int randomSmallInt()
  {
    return (int) (Math.random() * (1 << 15));
  }

  private static int randomSmallLong()
  {
    return (int) (Math.random() * (1 << 31));
  }

  /*
   * Int.
   */

  @Test(expected = ArithmeticException.class) public void absoluteIntBad()
  {
    final int x = Integer.MIN_VALUE;
    CheckedMath.absolute(x);
  }

  @Test public void absoluteIntIdentity()
  {
    for (int index = 0; index < 100; ++index) {
      final int x = CheckedMathTest.randomInt();
      final int z = CheckedMath.absolute(x);
      Assert.assertEquals(x, z);
    }
  }

  @Test public void absoluteIntNegativeCorrect()
  {
    for (int index = 0; index < 100; ++index) {
      final int x = CheckedMathTest.randomInt();
      final int z = CheckedMath.absolute(0 - x);
      Assert.assertEquals(x, z);
    }
  }

  @Test(expected = ArithmeticException.class) public void absoluteLongBad()
  {
    final long x = Long.MIN_VALUE;
    CheckedMath.absolute(x);
  }

  @Test public void absoluteLongIdentity()
  {
    for (long index = 0; index < 100; ++index) {
      final long x = CheckedMathTest.randomLong();
      final long z = CheckedMath.absolute(x);
      Assert.assertEquals(x, z);
    }
  }

  @Test public void absoluteLongNegativeCorrect()
  {
    for (long index = 0; index < 100; ++index) {
      final long x = CheckedMathTest.randomLong();
      final long z = CheckedMath.absolute(0 - x);
      Assert.assertEquals(x, z);
    }
  }

  @Test public void addIntCorrect()
  {
    for (int index = 0; index < 100; ++index) {
      final int x = CheckedMathTest.randomInt();
      final int y = CheckedMathTest.randomInt();
      final int z = CheckedMath.add(x, y);
      Assert.assertEquals(x + y, z);
    }
  }

  @Test(expected = ArithmeticException.class) public void addIntOverflowMax()
  {
    final int x = Integer.MAX_VALUE;
    final int y = Integer.MAX_VALUE;
    CheckedMath.add(x, y);
  }

  @Test(expected = ArithmeticException.class) public void addIntOverflowMin()
  {
    final int x = Integer.MIN_VALUE;
    final int y = Integer.MIN_VALUE;
    CheckedMath.add(x, y);
  }

  @Test public void addLongCorrect()
  {
    for (long index = 0; index < 100; ++index) {
      final long x = CheckedMathTest.randomLong();
      final long y = CheckedMathTest.randomLong();
      final long z = CheckedMath.add(x, y);
      Assert.assertEquals(x + y, z);
    }
  }

  @Test(expected = ArithmeticException.class) public
    void
    addLongOverflowMax()
  {
    final long x = Long.MAX_VALUE;
    final long y = Long.MAX_VALUE;
    CheckedMath.add(x, y);
  }

  @Test(expected = ArithmeticException.class) public
    void
    addLongOverflowMin()
  {
    final long x = Long.MIN_VALUE;
    final long y = Long.MIN_VALUE;
    CheckedMath.add(x, y);
  }

  @Test(expected = ArithmeticException.class) public void divideIntBad()
  {
    final int x = Integer.MIN_VALUE;
    final int y = -1;
    CheckedMath.divide(x, y);
  }

  @Test public void divideIntCorrect()
  {
    for (int index = 0; index < 100; ++index) {
      final int x = CheckedMathTest.randomInt();
      final int y = CheckedMathTest.randomInt();
      final int z = CheckedMath.divide(x, y);
      Assert.assertEquals(x / y, z);
    }
  }

  @Test(expected = ArithmeticException.class) public void divideLongBad()
  {
    final long x = Long.MIN_VALUE;
    final long y = -1;
    CheckedMath.divide(x, y);
  }

  @Test public void divideLongCorrect()
  {
    for (long index = 0; index < 100; ++index) {
      final long x = CheckedMathTest.randomLong();
      final long y = CheckedMathTest.randomLong();
      final long z = CheckedMath.divide(x, y);
      Assert.assertEquals(x / y, z);
    }
  }

  @Test public void multiplyIntCorrect()
  {
    for (int index = 0; index < 100; ++index) {
      final int x = CheckedMathTest.randomSmallInt();
      final int y = CheckedMathTest.randomSmallInt();
      final int z = CheckedMath.multiply(x, y);
      Assert.assertEquals(x * y, z);
    }
  }

  @Test public void multiplyIntDoubleCorrect()
  {
    for (int index = 0; index < 100; ++index) {
      final int x = CheckedMathTest.randomSmallInt();
      final double y = CheckedMathTest.randomSmallDouble();
      final int z = CheckedMath.multiply(x, y);
      Assert.assertEquals((int) (x * y), z);
    }
  }

  @Test public void multiplyIntDoubleOK0()
  {
    final int x = Integer.MAX_VALUE;
    final double y = -1;
    final int z = CheckedMath.multiply(x, y);
    Assert.assertEquals(Integer.MIN_VALUE + 1, z);
  }

  @Test public void multiplyIntDoubleOK1()
  {
    final int x = Integer.MIN_VALUE + 1;
    final double y = -1;
    final int z = CheckedMath.multiply(x, y);
    Assert.assertEquals(Integer.MAX_VALUE, z);
  }

  @Test(expected = ArithmeticException.class) public
    void
    multiplyIntDoubleOverflow0()
  {
    final int x = Integer.MAX_VALUE;
    final double y = 2;
    CheckedMath.multiply(x, y);
  }

  @Test(expected = ArithmeticException.class) public
    void
    multiplyIntDoubleOverflow1()
  {
    final int x = Integer.MAX_VALUE;
    final double y = -2;
    CheckedMath.multiply(x, y);
  }

  @Test(expected = ArithmeticException.class) public
    void
    multiplyIntDoubleOverflow2()
  {
    final int x = Integer.MIN_VALUE;
    final double y = -1;
    CheckedMath.multiply(x, y);
  }

  @Test(expected = ArithmeticException.class) public
    void
    multiplyIntDoubleUnderflow0()
  {
    final int x = Integer.MIN_VALUE;
    final double y = 2;
    CheckedMath.multiply(x, y);
  }

  @Test(expected = ArithmeticException.class) public
    void
    multiplyIntDoubleUnderflow1()
  {
    final int x = Integer.MIN_VALUE;
    final double y = -2;
    CheckedMath.multiply(x, y);
  }

  @Test public void multiplyIntOK0()
  {
    final int x = Integer.MAX_VALUE;
    final int y = -1;
    final int z = CheckedMath.multiply(x, y);
    Assert.assertEquals(Integer.MIN_VALUE + 1, z);
  }

  @Test public void multiplyIntOK1()
  {
    final int x = Integer.MIN_VALUE + 1;
    final int y = -1;
    final int z = CheckedMath.multiply(x, y);
    Assert.assertEquals(Integer.MAX_VALUE, z);
  }

  @Test(expected = ArithmeticException.class) public
    void
    multiplyIntOverflow0()
  {
    final int x = Integer.MAX_VALUE;
    final int y = 2;
    CheckedMath.multiply(x, y);
  }

  @Test(expected = ArithmeticException.class) public
    void
    multiplyIntOverflow1()
  {
    final int x = Integer.MAX_VALUE;
    final int y = -2;
    CheckedMath.multiply(x, y);
  }

  /*
   * Long.
   */

  @Test(expected = ArithmeticException.class) public
    void
    multiplyIntOverflow2()
  {
    final int x = Integer.MIN_VALUE;
    final int y = -1;
    CheckedMath.multiply(x, y);
  }

  @Test(expected = ArithmeticException.class) public
    void
    multiplyIntUnderflow0()
  {
    final int x = Integer.MIN_VALUE;
    final int y = 2;
    CheckedMath.multiply(x, y);
  }

  @Test(expected = ArithmeticException.class) public
    void
    multiplyIntUnderflow1()
  {
    final int x = Integer.MIN_VALUE;
    final int y = -2;
    CheckedMath.multiply(x, y);
  }

  @Test public void multiplyLongCorrect()
  {
    for (long index = 0; index < 100; ++index) {
      final long x = CheckedMathTest.randomSmallLong();
      final long y = CheckedMathTest.randomSmallLong();
      final long z = CheckedMath.multiply(x, y);
      Assert.assertEquals(x * y, z);
    }
  }

  @Test public void multiplyOK0()
  {
    final long x = Long.MAX_VALUE;
    final long y = -1;
    final long z = CheckedMath.multiply(x, y);
    Assert.assertEquals(Long.MIN_VALUE + 1, z);
  }

  @Test public void multiplyOK1()
  {
    final long x = Long.MIN_VALUE + 1;
    final long y = -1;
    final long z = CheckedMath.multiply(x, y);
    Assert.assertEquals(Long.MAX_VALUE, z);
  }

  @Test(expected = ArithmeticException.class) public void multiplyOverflow0()
  {
    final long x = Long.MAX_VALUE;
    final long y = 2;
    CheckedMath.multiply(x, y);
  }

  @Test(expected = ArithmeticException.class) public void multiplyOverflow1()
  {
    final long x = Long.MAX_VALUE;
    final long y = -2;
    CheckedMath.multiply(x, y);
  }

  @Test(expected = ArithmeticException.class) public void multiplyOverflow2()
  {
    final long x = Long.MIN_VALUE;
    final long y = -1;
    CheckedMath.multiply(x, y);
  }

  @Test(expected = ArithmeticException.class) public
    void
    multiplyUnderflow0()
  {
    final long x = Long.MIN_VALUE;
    final long y = 2;
    CheckedMath.multiply(x, y);
  }

  @Test(expected = ArithmeticException.class) public
    void
    multiplyUnderflow1()
  {
    final long x = Long.MIN_VALUE;
    final long y = -2;
    CheckedMath.multiply(x, y);
  }

  @Test(expected = ArithmeticException.class) public void negateIntBad()
  {
    final int x = Integer.MIN_VALUE;
    CheckedMath.negate(x);
  }

  @Test public void negateIntCorrect()
  {
    for (int index = 0; index < 100; ++index) {
      final int x = CheckedMathTest.randomInt();
      final int z = CheckedMath.negate(0 - x);
      Assert.assertEquals(x, z);
    }
  }

  @Test(expected = ArithmeticException.class) public void negateLongBad()
  {
    final long x = Long.MIN_VALUE;
    CheckedMath.negate(x);
  }

  @Test public void negateLongCorrect()
  {
    for (long index = 0; index < 100; ++index) {
      final long x = CheckedMathTest.randomLong();
      final long z = CheckedMath.negate(0 - x);
      Assert.assertEquals(x, z);
    }
  }

  @Test public void subtractIntCorrect()
  {
    for (int index = 0; index < 100; ++index) {
      final int x = CheckedMathTest.randomInt();
      final int y = 10;
      final int z = CheckedMath.subtract(x, y);
      Assert.assertEquals(x - y, z);
    }
  }

  @Test(expected = ArithmeticException.class) public
    void
    subtractIntOverflowAlt()
  {
    final int x = Integer.MAX_VALUE;
    final int y = -1;
    CheckedMath.subtract(x, y);
  }

  @Test(expected = ArithmeticException.class) public
    void
    subtractIntOverflowMin()
  {
    final int x = Integer.MIN_VALUE;
    final int y = 1;
    CheckedMath.subtract(x, y);
  }

  @Test public void subtractLongCorrect()
  {
    for (long index = 0; index < 100; ++index) {
      final long x = CheckedMathTest.randomLong();
      final long y = 10;
      final long z = CheckedMath.subtract(x, y);
      Assert.assertEquals(x - y, z);
    }
  }

  @Test(expected = ArithmeticException.class) public
    void
    subtractLongOverflowAlt()
  {
    final long x = Long.MAX_VALUE;
    final long y = -1;
    CheckedMath.subtract(x, y);
  }

  @Test(expected = ArithmeticException.class) public
    void
    subtractLongOverflowMin()
  {
    final long x = Long.MIN_VALUE;
    final long y = 1;
    CheckedMath.subtract(x, y);
  }
}
