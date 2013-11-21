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

package com.io7m.jaux.functional;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.Immutable;

/**
 * <p>
 * Type denoting the result of a computation that might fail. A value
 * <code>i</code> of type <code>Indeterminate<S, F></code> contains a value of
 * type <code>S</code> iff the computation succeeded, or a value of type
 * <code>F</code> iff the computation failed.
 * </p>
 * <p>
 * The normal way to use <code>i</code> is to match (switch) on
 * <code>i.type</code> and then cast <code>i</code> to
 * <code>Success<S, F></code> or <code>Failure<S, F></code> based on whether
 * <code>i.type == SUCCESS</code> or <code>i.type == FAILURE</code>.
 * </p>
 * <p>
 * The constructor of <code>Indeterminate<S, F></code> is private in order to
 * statically guarantee that the only two possible subtypes of
 * <code>Indeterminate<S, F></code> are <code>Success<S, F></code> and
 * <code>Failure<S, F></code>.
 * </p>
 */

@Immutable public class Indeterminate<S, F>
{
  /**
   * Type enclosing failure.
   */

  public static class Failure<S, F> extends Indeterminate<S, F>
  {
    public final F value;

    @SuppressWarnings("synthetic-access") public Failure(
      final F value)
    {
      super(Type.FAILURE);
      this.value = value;
    }

    @Override public boolean equals(
      final Object obj)
    {
      if (this == obj) {
        return true;
      }
      if (!super.equals(obj)) {
        return false;
      }
      if (this.getClass() != obj.getClass()) {
        return false;
      }
      final Failure<?, ?> other = (Failure<?, ?>) obj;
      if (this.value == null) {
        if (other.value != null) {
          return false;
        }
      } else if (!this.value.equals(other.value)) {
        return false;
      }
      return true;
    }

    @Override public int hashCode()
    {
      final int prime = 31;
      int result = super.hashCode();
      result =
        (prime * result) + ((this.value == null) ? 0 : this.value.hashCode());
      return result;
    }

    @Override public String toString()
    {
      final StringBuilder builder = new StringBuilder();
      builder.append("Failure [");
      builder.append(this.value);
      builder.append("]");
      return builder.toString();
    }
  }

  /**
   * Type enclosing success.
   */

  public static class Success<S, F> extends Indeterminate<S, F>
  {
    public final S value;

    @SuppressWarnings("synthetic-access") public Success(
      final S value)
    {
      super(Type.SUCCESS);
      this.value = value;
    }

    @Override public boolean equals(
      final Object obj)
    {
      if (this == obj) {
        return true;
      }
      if (!super.equals(obj)) {
        return false;
      }
      if (this.getClass() != obj.getClass()) {
        return false;
      }
      final Success<?, ?> other = (Success<?, ?>) obj;
      if (this.value == null) {
        if (other.value != null) {
          return false;
        }
      } else if (!this.value.equals(other.value)) {
        return false;
      }
      return true;
    }

    @Override public int hashCode()
    {
      final int prime = 31;
      int result = super.hashCode();
      result =
        (prime * result) + ((this.value == null) ? 0 : this.value.hashCode());
      return result;
    }

    @Override public String toString()
    {
      final StringBuilder builder = new StringBuilder();
      builder.append("Success [");
      builder.append(this.value);
      builder.append("]");
      return builder.toString();
    }
  }

  public static enum Type
  {
    FAILURE,
    SUCCESS
  }

  /**
   * A convenience function for producing <code>Failure</code> values.
   * 
   * @since 2.8.0
   */

  public static @Nonnull <S, F> Failure<S, F> failure(
    final F value)
  {
    return new Failure<S, F>(value);
  }

  /**
   * A convenience function for producing <code>Failure</code> values.
   * 
   * @since 2.8.0
   */

  public static @Nonnull <S, F> Success<S, F> success(
    final S value)
  {
    return new Success<S, F>(value);
  }

  public final @Nonnull Type type;

  private Indeterminate(
    final @Nonnull Type type)
  {
    this.type = type;
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
    final Indeterminate<?, ?> other = (Indeterminate<?, ?>) obj;
    if (this.type != other.type) {
      return false;
    }
    return true;
  }

  @Override public int hashCode()
  {
    final int prime = 31;
    int result = 1;
    result =
      (prime * result) + ((this.type == null) ? 0 : this.type.hashCode());
    return result;
  }

  /**
   * Return true iff the value is a <code>Failure</code> value.
   */

  public final boolean isFailure()
  {
    return this.type == Type.FAILURE;
  }

  /**
   * Return true iff the value is a <code>Success</code> value.
   */

  public final boolean isSuccess()
  {
    return this.type == Type.SUCCESS;
  }
}
