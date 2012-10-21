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

package com.io7m.jaux;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import javax.annotation.concurrent.ThreadSafe;

/**
 * <p>
 * The Constraints class provides functions for constraining values to given
 * ranges and for asserting arbitrary propositions.
 * </p>
 * 
 * <p>
 * Mainly, it's intended as a way to add assertions to code that cannot be
 * accidentally turned off.
 * </p>
 * 
 * <p>
 * It is intended to be used in the constructors of immutable classes. When
 * used in this manner, it becomes possible to enforce invariants to some
 * degree: If a type <code>T</code> can only be constructed with a constructor
 * <code>C</code> protected by constraint <code>P</code> that does not depend
 * on any global mutable state, then <code>P</code> must be true anywhere that
 * a value of type <code>T</code> is present.
 * </p>
 */

@ThreadSafe public final class Constraints
{
  /**
   * Exception type raised on constraint violation.
   */

  public static class ConstraintError extends Throwable
  {
    private static final long serialVersionUID = 1L;

    public ConstraintError(
      final @Nonnull String message)
    {
      super(message);
    }
  }

  /**
   * Ensures an arbitrary expression is true. The function throws
   * {@link ConstraintError} iff the expression is false.
   * 
   * The function is analogous to an 'assert' expression that cannot be
   * removed at runtime.
   * 
   * @param expression
   *          The expression to be tested.
   * @param message
   *          A humanly readable string of the input expression.
   * @throws ConstraintError
   *           Iff <code>expression == false</code>.
   */

  public static void constrainArbitrary(
    final boolean expression,
    final @Nonnull String message)
    throws ConstraintError
  {
    if (expression == false) {
      throw new ConstraintError("expression '"
        + message
        + "' evaluated to false");
    }
  }

  /**
   * Ensures the value <code>n</code> is less than the value <code>m</code>.
   * The function throws {@link ConstraintError} iff this is not the case. The
   * function returns <code>n</code>.
   * 
   * @return <code>n</code>.
   * @throws ConstraintError
   *           Iff <code>m >= n</code>.
   */

  public static double constrainLessThan(
    final double n,
    final double m)
    throws ConstraintError
  {
    return Constraints.constrainLessThan(n, m, null);
  }

  /**
   * Ensures the value <code>n</code> is less than the value <code>m</code>.
   * The function throws {@link ConstraintError} iff this is not the case. The
   * function returns <code>n</code>.
   * 
   * @return <code>n</code>.
   * @throws ConstraintError
   *           Iff <code>m >= n</code>.
   */

  public static double constrainLessThan(
    final double n,
    final double m,
    final @Nonnull String name)
    throws ConstraintError
  {
    if ((n < m) == false) {
      final @Nonnull String s =
        Double.toString(m) + " >= " + Double.toString(n);
      throw new ConstraintError(name == null ? s : name + ": " + s);
    }
    return n;
  }

  /**
   * Ensures the value <code>n</code> is less than the value <code>m</code>.
   * The function throws {@link ConstraintError} iff this is not the case. The
   * function returns <code>n</code>.
   * 
   * @return <code>n</code>.
   * @throws ConstraintError
   *           Iff <code>m >= n</code>.
   */

  public static float constrainLessThan(
    final float n,
    final float m)
    throws ConstraintError
  {
    return Constraints.constrainLessThan(n, m, null);
  }

  /**
   * Ensures the value <code>n</code> is less than the value <code>m</code>.
   * The function throws {@link ConstraintError} iff this is not the case. The
   * function returns <code>n</code>.
   * 
   * @return <code>n</code>.
   * @throws ConstraintError
   *           Iff <code>m >= n</code>.
   */

  public static float constrainLessThan(
    final float n,
    final float m,
    final @Nonnull String name)
    throws ConstraintError
  {
    return (float) Constraints
      .constrainLessThan((double) n, (double) m, name);
  }

  /**
   * Ensures the value <code>n</code> is less than the value <code>m</code>.
   * The function throws {@link ConstraintError} iff this is not the case. The
   * function returns <code>n</code>.
   * 
   * @return <code>n</code>.
   * @throws ConstraintError
   *           Iff <code>m >= n</code>.
   */

  public static int constrainLessThan(
    final int n,
    final int m)
    throws ConstraintError
  {
    return Constraints.constrainLessThan(n, m, null);
  }

  /**
   * Ensures the value <code>n</code> is less than the value <code>m</code>.
   * The function throws {@link ConstraintError} iff this is not the case. The
   * function returns <code>n</code>.
   * 
   * @return <code>n</code>.
   * @throws ConstraintError
   *           Iff <code>m >= n</code>.
   */

  public static int constrainLessThan(
    final int n,
    final int m,
    final @Nonnull String name)
    throws ConstraintError
  {
    return (int) Constraints.constrainLessThan((long) n, (long) m, name);
  }

  /**
   * Ensures the value <code>n</code> is less than the value <code>m</code>.
   * The function throws {@link ConstraintError} iff this is not the case. The
   * function returns <code>n</code>.
   * 
   * @return <code>n</code>.
   * @throws ConstraintError
   *           Iff <code>m >= n</code>.
   */

  public static long constrainLessThan(
    final long n,
    final long m)
    throws ConstraintError
  {
    return Constraints.constrainLessThan(n, m, null);
  }

  /**
   * Ensures the value <code>n</code> is less than the value <code>m</code>.
   * The function throws {@link ConstraintError} iff this is not the case. The
   * function returns <code>n</code>.
   * 
   * @return <code>n</code>.
   * @throws ConstraintError
   *           Iff <code>m >= n</code>.
   */

  public static long constrainLessThan(
    final long n,
    final long m,
    final @Nonnull String name)
    throws ConstraintError
  {
    if ((n < m) == false) {
      final @Nonnull String s = Long.toString(m) + " >= " + Long.toString(n);
      throw new ConstraintError(name == null ? s : name + ": " + s);
    }
    return n;
  }

  /**
   * Ensures an arbitrary value is not null. The function throws
   * {@link ConstraintError} iff the given value is null.
   * 
   * @param value
   *          The value to be checked.
   * @param message
   *          A humanly readable string description of the input value.
   * 
   * @throws ConstraintError
   *           Iff <code>value == null</code>.
   */

  public static <T> T constrainNotNull(
    final T value,
    final @Nonnull String message)
    throws ConstraintError
  {
    if (value == null) {
      throw new ConstraintError("value '" + message + "' is null");
    }
    return value;
  }

  /**
   * Constrains a value <code>n</code> to the inclusive range
   * <code>first</code> ..<code>last</code>. The function throws
   * {@link ConstraintError} iff the value lies outside of this range.
   * 
   * The function returns the input value.
   * 
   * @param n
   *          The input value.
   * @param first
   *          The lower bound.
   * @param last
   *          The upper bound.
   * @return The input value.
   * @throws ConstraintError
   */

  public static double constrainRange(
    final double n,
    final double first,
    final double last)
    throws ConstraintError
  {
    return Constraints.constrainRange(n, first, last, null);
  }

  /**
   * Constrains a value <code>n</code> to the inclusive range
   * <code>first</code> ..<code>last</code>. The function throws
   * {@link ConstraintError} iff the value lies outside of this range.
   * 
   * The function returns the input value.
   * 
   * @param n
   *          The input value.
   * @param first
   *          The lower bound.
   * @param last
   *          The upper bound.
   * @return The input value.
   * @throws ConstraintError
   */

  public static double constrainRange(
    final double n,
    final double first,
    final double last,
    final @CheckForNull String name)
    throws ConstraintError
  {
    if (n < first) {
      final @Nonnull String m =
        Double.toString(n) + " < " + Double.toString(first);
      throw new ConstraintError(name == null ? m : name + ": " + m);
    }
    if (n > last) {
      final @Nonnull String m =
        Double.toString(n) + " > " + Double.toString(last);
      throw new ConstraintError(name == null ? m : name + ": " + m);
    }
    return n;
  }

  /**
   * Constrains a value <code>n</code> to the inclusive range
   * <code>first</code> ..<code>last</code>. The function throws
   * {@link ConstraintError} iff the value lies outside of this range.
   * 
   * The function returns the input value.
   * 
   * @param n
   *          The input value.
   * @param first
   *          The lower bound.
   * @param last
   *          The upper bound.
   * @return The input value.
   * @throws ConstraintError
   */

  public static float constrainRange(
    final float n,
    final float first,
    final float last)
    throws ConstraintError
  {
    return Constraints.constrainRange(n, first, last, null);
  }

  /**
   * Constrains a value <code>n</code> to the inclusive range
   * <code>first</code> ..<code>last</code>. The function throws
   * {@link ConstraintError} iff the value lies outside of this range.
   * 
   * The function returns the input value.
   * 
   * @param n
   *          The input value.
   * @param first
   *          The lower bound.
   * @param last
   *          The upper bound.
   * @return The input value.
   * @throws ConstraintError
   */

  public static float constrainRange(
    final float n,
    final float first,
    final float last,
    final @CheckForNull String name)
    throws ConstraintError
  {
    if (n < first) {
      final @Nonnull String m =
        Float.toString(n) + " < " + Float.toString(first);
      throw new ConstraintError(name == null ? m : name + ": " + m);
    }
    if (n > last) {
      final @Nonnull String m =
        Float.toString(n) + " > " + Float.toString(last);
      throw new ConstraintError(name == null ? m : name + ": " + m);
    }
    return n;
  }

  /**
   * Constrains a value <code>n</code> to the inclusive range
   * <code>first</code> ..<code>last</code>. The function throws
   * {@link ConstraintError} iff the value lies outside of this range.
   * 
   * The function returns the input value.
   * 
   * @param n
   *          The input value.
   * @param first
   *          The lower bound.
   * @param last
   *          The upper bound.
   * @return The input value.
   * @throws ConstraintError
   */

  public static long constrainRange(
    final int n,
    final int first,
    final int last)
    throws ConstraintError
  {
    return Constraints.constrainRange(n, first, last, null);
  }

  /**
   * Constrains a value <code>n</code> to the inclusive range
   * <code>first</code> ..<code>last</code>. The function throws
   * {@link ConstraintError} iff the value lies outside of this range.
   * 
   * The function returns the input value.
   * 
   * @param n
   *          The input value.
   * @param first
   *          The lower bound.
   * @param last
   *          The upper bound.
   * @return The input value.
   * @throws ConstraintError
   */

  public static int constrainRange(
    final int n,
    final int first,
    final int last,
    final @CheckForNull String name)
    throws ConstraintError
  {
    if (n < first) {
      final @Nonnull String m =
        Integer.toString(n) + " < " + Integer.toString(first);
      throw new ConstraintError(name == null ? m : name + ": " + m);
    }
    if (n > last) {
      final @Nonnull String m =
        Integer.toString(n) + " > " + Integer.toString(last);
      throw new ConstraintError(name == null ? m : name + ": " + m);
    }
    return n;
  }

  /**
   * Constrains a value <code>n</code> to the inclusive range
   * <code>first</code> ..<code>last</code>. The function throws
   * {@link ConstraintError} iff the value lies outside of this range.
   * 
   * The function returns the input value.
   * 
   * @param n
   *          The input value.
   * @param first
   *          The lower bound.
   * @param last
   *          The upper bound.
   * @return The input value.
   * @throws ConstraintError
   */

  public static long constrainRange(
    final long n,
    final long first,
    final long last)
    throws ConstraintError
  {
    return Constraints.constrainRange(n, first, last, null);
  }

  /**
   * Constrains a value <code>n</code> to the inclusive range
   * <code>first</code> ..<code>last</code>. The function throws
   * {@link ConstraintError} iff the value lies outside of this range, with
   * <code>name</code>, if present, prefixing the failure message.
   * 
   * The function returns the input value.
   * 
   * @param n
   *          The input value.
   * @param first
   *          The lower bound.
   * @param last
   *          The upper bound.
   * @param name
   *          A prefix for the message passed to {@link ConstraintError}.
   * @return The input value.
   * @throws ConstraintError
   */

  public static long constrainRange(
    final long n,
    final long first,
    final long last,
    final @CheckForNull String name)
    throws ConstraintError
  {
    if (n < first) {
      final @Nonnull String m =
        Long.toString(n) + " < " + Long.toString(first);
      throw new ConstraintError(name == null ? m : name + ": " + m);
    }
    if (n > last) {
      final @Nonnull String m =
        Long.toString(n) + " > " + Long.toString(last);
      throw new ConstraintError(name == null ? m : name + ": " + m);
    }
    return n;
  }

  /**
   * Ensures a string matches a regular expression. The function throws
   * {@link ConstraintError} iff the given string does not match or is null.
   * 
   * @param value
   *          The input string.
   * @param regex
   *          The regex to match against.
   * @param message
   *          The name of the value used in error messages.
   * @throws ConstraintError
   *           Iff <code>value</code> does not match <code>regex</code>.
   */

  public static String constrainStringMatch(
    final @Nonnull String value,
    final @Nonnull Pattern regex,
    final @Nonnull String message)
    throws ConstraintError
  {
    if (value == null) {
      throw new ConstraintError("value '" + message + "' is null");
    }
    if (regex == null) {
      throw new ConstraintError("regex for matching value '"
        + message
        + "' is null");
    }

    final @Nonnull Matcher matcher = regex.matcher(value);
    if (matcher.find() == false) {
      throw new ConstraintError("value '" + message + "' fails pattern match");
    }
    return value;
  }

  private Constraints()
  {
    // Unused.
  }
}
