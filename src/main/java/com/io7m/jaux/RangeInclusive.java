package com.io7m.jaux;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.Immutable;

import com.io7m.jaux.Constraints.ConstraintError;

/**
 * Immutable type representing an inclusive range.
 */

@Immutable public final class RangeInclusive
{
  private final long lower;
  private final long upper;

  /**
   * Construct an inclusive range. The constructor enforces the invariant
   * <code>lower <= upper</code>.
   * 
   * @param lower
   *          The lower bound
   * @param upper
   *          The upper bound
   * @throws ConstraintError
   *           Iff <code>lower > upper</code>.
   */

  public RangeInclusive(
    final long lower,
    final long upper)
    throws ConstraintError
  {
    Constraints.constrainArbitrary(lower <= upper, "First <= Last");
    this.lower = lower;
    this.upper = upper;
  }

  @Override public boolean equals(
    final Object obj)
  {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (this.getClass() != obj.getClass()) {
      return false;
    }
    final RangeInclusive other = (RangeInclusive) obj;
    if (this.lower != other.lower) {
      return false;
    }
    if (this.upper != other.upper) {
      return false;
    }
    return true;
  }

  /**
   * Retrieve the number of values in the range <code>[lower, upper]</code>.
   * 
   * That is, <code>(upper - lower) + 1</code>.
   */

  public long getInterval()
  {
    return (this.upper - this.lower) + 1;
  }

  /**
   * Retrieve the lower bound of the inclusive range.
   */

  public long getLower()
  {
    return this.lower;
  }

  /**
   * Retrieve the upper bound of the inclusive range.
   */

  public long getUpper()
  {
    return this.upper;
  }

  @Override public int hashCode()
  {
    final int prime = 31;
    int result = 1;
    result = (prime * result) + (int) (this.lower ^ (this.lower >>> 32));
    result = (prime * result) + (int) (this.upper ^ (this.upper >>> 32));
    return result;
  }

  /**
   * Return <code>true</code> iff
   * <code>this.getLower() >= other.getLower() && this.getUpper() <= other.getUpper()</code>
   * .
   * 
   * @throws ConstraintError
   *           Iff <code>other == null</code>.
   */

  public boolean isIncludedIn(
    final @Nonnull RangeInclusive other)
    throws ConstraintError
  {
    Constraints.constrainNotNull(other, "Other range");
    return (this.lower >= other.lower) && (this.upper <= other.upper);
  }

  @Override public String toString()
  {
    final StringBuilder builder = new StringBuilder();
    builder.append("[RangeInclusive ");
    builder.append(this.lower);
    builder.append(" ");
    builder.append(this.upper);
    builder.append("]");
    return builder.toString();
  }
}
