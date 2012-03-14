package com.io7m.jaux.functional;

/**
 * Immutable generic pair type.
 */

public final class Pair<A, B>
{
  public final A first;
  public final B second;

  public Pair(
    final A first,
    final B second)
  {
    this.first = first;
    this.second = second;
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
    final Pair<?, ?> other = (Pair<?, ?>) obj;
    if (this.first == null) {
      if (other.first != null) {
        return false;
      }
    } else if (!this.first.equals(other.first)) {
      return false;
    }
    if (this.second == null) {
      if (other.second != null) {
        return false;
      }
    } else if (!this.second.equals(other.second)) {
      return false;
    }
    return true;
  }

  @Override public int hashCode()
  {
    final int prime = 31;
    int result = 1;
    result =
      (prime * result) + ((this.first == null) ? 0 : this.first.hashCode());
    result =
      (prime * result) + ((this.second == null) ? 0 : this.second.hashCode());
    return result;
  }

  @Override public String toString()
  {
    final StringBuilder builder = new StringBuilder();
    builder.append("[Pair (");
    builder.append(this.first);
    builder.append(",");
    builder.append(this.second);
    builder.append(")]");
    return builder.toString();
  }
}
