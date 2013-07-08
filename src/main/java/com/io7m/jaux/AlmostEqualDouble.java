package com.io7m.jaux;

import javax.annotation.Nonnull;

/**
 * <p>
 * Better floating point comparisons.
 * <p>
 * <p>
 * 
 * See <a href=
 * "http://randomascii.wordpress.com/2012/02/25/comparing-floating-point-numbers-2012-edition"
 * >Comparing floating point numbers 2012</a>.
 * </p>
 * 
 * @since 2.4.0
 */

public final class AlmostEqualDouble
{
  /**
   * The necessary context for floating point comparisons.
   */

  public static final class ContextRelative
  {
    private double max_absolute_diff;
    private double max_relative_diff;

    public ContextRelative()
    {
      this.max_absolute_diff = 0.0;
      this.max_relative_diff = 0.0;
    }

    public double getMaxAbsoluteDifference()
    {
      return this.max_absolute_diff;
    }

    public double getMaxRelativeDifference()
    {
      return this.max_relative_diff;
    }

    public void setMaxAbsoluteDifference(
      final double max)
    {
      this.max_absolute_diff = max;
    }

    public void setMaxRelativeDifference(
      final double max)
    {
      this.max_relative_diff = max;
    }

    @Override public String toString()
    {
      final StringBuilder builder = new StringBuilder();
      builder.append("[ContextRelative [Absolute ");
      builder.append(this.max_absolute_diff);
      builder.append("] [Relative ");
      builder.append(this.max_relative_diff);
      builder.append("]]");
      return builder.toString();
    }
  }

  /**
   * <p>
   * Compare the floating point numbers <code>x</code> and <code>y</code>
   * using the context <code>context</code>.
   * </p>
   * 
   * <p>
   * Essentially, given <code>diff = abs(x - y)</code>, if
   * <code>diff &lt;= context.getMaxRelativeDifference() * max(abs(x), abs(y))</code>
   * , then <code>x</code> and <code>y</code> can be considered to be close
   * together.
   * </p>
   * 
   * <p>
   * See the article mentioned at the top of this article for suggested
   * absolute and relative epsilon values: There are no values that work well
   * for all possible inputs.
   * </p>
   */

  public static boolean almostEqual(
    final @Nonnull ContextRelative context,
    final double x,
    final double y)
  {
    if (x == Double.POSITIVE_INFINITY) {
      if (y == Double.POSITIVE_INFINITY) {
        return true;
      }
    }
    if (x == Double.NEGATIVE_INFINITY) {
      if (y == Double.NEGATIVE_INFINITY) {
        return true;
      }
    }

    final double diff = Math.abs(x - y);
    if (diff <= context.getMaxAbsoluteDifference()) {
      return true;
    }

    final double ax = Math.abs(x);
    final double ay = Math.abs(y);
    final double m = Math.max(ax, ay);
    final double k = m * context.getMaxRelativeDifference();

    if (diff <= k) {
      return true;
    }

    return false;
  }

  private AlmostEqualDouble()
  {
    throw new UnreachableCodeException();
  }
}
