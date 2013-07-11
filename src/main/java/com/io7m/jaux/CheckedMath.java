/*
 * Copyright © 2013 <code@io7m.com> http://io7m.com
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


package com.io7m.jaux;

import javax.annotation.concurrent.ThreadSafe;

/**
 * Checked arithmetic operations: All operations raise
 * {@link ArithmeticException} on underflow or overflow.
 */

@ThreadSafe public final class CheckedMath
{
  /**
   * Return the absolute value of an integer.
   * 
   * @param n
   *          The value.
   * @return <code>abs(n)</code>
   * @throws ArithmeticException
   *           Iff the absolute value would overflow.
   */

  public static int absolute(
    final int n)
    throws ArithmeticException
  {
    if (n == Integer.MIN_VALUE) {
      throw new ArithmeticException("Integer overflow: " + n);
    }
    return Math.abs(n);
  }

  /**
   * Return the absolute value of an integer.
   * 
   * @param n
   *          The value.
   * @return <code>abs(n)</code>
   * @throws ArithmeticException
   *           Iff the absolute value would overflow.
   */

  public static long absolute(
    final long n)
    throws ArithmeticException
  {
    if (n == Long.MIN_VALUE) {
      throw new ArithmeticException("Integer overflow: " + n);
    }
    return Math.abs(n);
  }

  /**
   * Add integers.
   * 
   * @param n
   *          The left value.
   * @param m
   *          The right value.
   * @return <code>n + m</code>
   * @throws ArithmeticException
   *           Iff the addition would overflow.
   */

  public static int add(
    final int n,
    final int m)
    throws ArithmeticException
  {
    if (m > 0) {
      if (n > (Integer.MAX_VALUE - m)) {
        throw new ArithmeticException("Integer overflow: " + n + " + " + m);
      }
    } else if (n < (Integer.MIN_VALUE - m)) {
      throw new ArithmeticException("Integer overflow: " + n + " + " + m);
    }

    return n + m;
  }

  /**
   * Add integers.
   * 
   * @param n
   *          The left value.
   * @param m
   *          The right value.
   * @return <code>n + m</code>
   * @throws ArithmeticException
   *           Iff the addition would overflow.
   */

  public static long add(
    final long n,
    final long m)
    throws ArithmeticException
  {
    if (m > 0) {
      if (n > (Long.MAX_VALUE - m)) {
        throw new ArithmeticException("Integer overflow: " + n + " + " + m);
      }
    } else if (n < (Long.MIN_VALUE - m)) {
      throw new ArithmeticException("Integer overflow: " + n + " + " + m);
    }

    return n + m;
  }

  /**
   * Divide integers.
   * 
   * @param n
   *          The left value.
   * @param m
   *          The right value.
   * @return <code>n / m</code>
   * @throws ArithmeticException
   *           Iff the division would overflow.
   */

  public static int divide(
    final int n,
    final int m)
    throws ArithmeticException
  {
    if ((n == Integer.MIN_VALUE) && (m == -1)) {
      throw new ArithmeticException("Integer overflow: " + n + " / " + m);
    }
    return n / m;
  }

  /**
   * Divide integers.
   * 
   * @param n
   *          The left value.
   * @param m
   *          The right value.
   * @return <code>n / m</code>
   * @throws ArithmeticException
   *           Iff the division would overflow.
   */

  public static long divide(
    final long n,
    final long m)
    throws ArithmeticException
  {
    if ((n == Long.MIN_VALUE) && (m == -1)) {
      throw new ArithmeticException("Integer overflow: " + n + " / " + m);
    }
    return n / m;
  }

  /**
   * Multiply integers.
   * 
   * @param n
   *          The left value.
   * @param m
   *          The right value.
   * @return <code>n * m</code>
   * @throws ArithmeticException
   *           Iff the multiplication would overflow.
   */

  public static int multiply(
    final int n,
    final double m)
    throws ArithmeticException
  {
    final double dn = n;
    final double dm = m;
    final double r = dn * dm;

    if (r > Integer.MAX_VALUE) {
      throw new ArithmeticException("Integer overflow: " + n + " * " + m);
    } else if (r < Integer.MIN_VALUE) {
      throw new ArithmeticException("Integer underflow: " + n + " * " + m);
    }

    return (int) r;
  }

  /**
   * Multiply integers.
   * 
   * @param n
   *          The left value.
   * @param m
   *          The right value.
   * @return <code>n * m</code>
   * @throws ArithmeticException
   *           Iff the multiplication would overflow.
   */

  public static int multiply(
    final int n,
    final int m)
    throws ArithmeticException
  {
    if (m > 0) {
      if (n > (Integer.MAX_VALUE / m)) {
        throw new ArithmeticException("Integer overflow: " + n + " * " + m);
      }
      if (n < (Integer.MIN_VALUE / m)) {
        throw new ArithmeticException("Integer underflow: " + n + " * " + m);
      }
    } else if (m < -1) {
      if (n > (Integer.MIN_VALUE / m)) {
        throw new ArithmeticException("Integer overflow: " + n + " * " + m);
      }
      if (n < (Integer.MAX_VALUE / m)) {
        throw new ArithmeticException("Integer underflow: " + n + " * " + m);
      }
    } else if ((m == -1) && (n == Integer.MIN_VALUE)) {
      throw new ArithmeticException("Integer overflow: " + n + " * " + m);
    }

    return n * m;
  }

  /**
   * Multiply integers.
   * 
   * @param n
   *          The left value.
   * @param m
   *          The right value.
   * @return <code>n * m</code>
   * @throws ArithmeticException
   *           Iff the multiplication would overflow.
   */

  public static long multiply(
    final long n,
    final long m)
    throws ArithmeticException
  {
    if (m > 0) {
      if (n > (Long.MAX_VALUE / m)) {
        throw new ArithmeticException("Integer overflow: " + n + " * " + m);
      }
      if (n < (Long.MIN_VALUE / m)) {
        throw new ArithmeticException("Long underflow: " + n + " * " + m);
      }
    } else if (m < -1) {
      if (n > (Long.MIN_VALUE / m)) {
        throw new ArithmeticException("Integer overflow: " + n + " * " + m);
      }
      if (n < (Long.MAX_VALUE / m)) {
        throw new ArithmeticException("Long underflow: " + n + " * " + m);
      }
    } else if ((m == -1) && (n == Long.MIN_VALUE)) {
      throw new ArithmeticException("Integer overflow: " + n + " * " + m);
    }

    return n * m;
  }

  /**
   * Negate an integer.
   * 
   * @param n
   *          The value.
   * @return <code>-n</code>
   * @throws ArithmeticException
   *           Iff the negation would overflow.
   */

  public static int negate(
    final int n)
    throws ArithmeticException
  {
    if (n == Integer.MIN_VALUE) {
      throw new ArithmeticException("Integer overflow: " + n);
    }
    return -n;
  }

  /**
   * Negate an integer.
   * 
   * @param n
   *          The value.
   * @return <code>-n</code>
   * @throws ArithmeticException
   *           Iff the negation would overflow.
   */

  public static long negate(
    final long n)
    throws ArithmeticException
  {
    if (n == Long.MIN_VALUE) {
      throw new ArithmeticException("Integer overflow: " + n);
    }
    return -n;
  }

  /**
   * Subtract integers.
   * 
   * @param n
   *          The left value.
   * @param m
   *          The right value.
   * @return <code>n - m</code>
   * @throws ArithmeticException
   *           Iff the subtraction would overflow.
   */

  public static int subtract(
    final int n,
    final int m)
    throws ArithmeticException
  {
    if (m > 0) {
      if (n < (Integer.MIN_VALUE + m)) {
        throw new ArithmeticException("Integer overflow: " + n + " - " + m);
      }
    } else if (n > (Integer.MAX_VALUE + m)) {
      throw new ArithmeticException("Integer overflow: " + n + " - " + m);
    }
    return n - m;
  }

  /**
   * Subtract integers.
   * 
   * @param n
   *          The left value.
   * @param m
   *          The right value.
   * @return <code>n - m</code>
   * @throws ArithmeticException
   *           Iff the subtraction would overflow.
   */

  public static long subtract(
    final long n,
    final long m)
    throws ArithmeticException
  {
    if (m > 0) {
      if (n < (Long.MIN_VALUE + m)) {
        throw new ArithmeticException("Integer overflow: " + n + " - " + m);
      }
    } else if (n > (Long.MAX_VALUE + m)) {
      throw new ArithmeticException("Integer overflow: " + n + " - " + m);
    }
    return n - m;
  }

  private CheckedMath()
  {
    // Unused.
  }
}
