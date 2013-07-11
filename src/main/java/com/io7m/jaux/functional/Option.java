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
 * Type denoting a computation that may or may not return a value. A value
 * <code>o</code> of type <code>Option<A></code> contains a value of type
 * <code>A</code> iff the computation returned a value, or no value iff the
 * computation did not return a value.
 * </p>
 * <p>
 * The normal way to use <code>o</code> is to match (switch) on
 * <code>i.type</code> and then cast <code>o</code> to <code>Some<A></code> or
 * <code>None<A></code> based on whether <code>o.type == OPTION_SOME</code> or
 * <code>o.type == OPTION_NONE</code>.
 * </p>
 * <p>
 * The constructor of <code>Option<A></code> is private in order to statically
 * guarantee that the only two possible subtypes of <code>Option<A></code> are
 * <code>Some<A></code> and <code>None<A></code>.
 * </p>
 */

@Immutable public class Option<A>
{
  /**
   * Type enclosing no value.
   */

  public static class None<A> extends Option<A>
  {
    @SuppressWarnings("synthetic-access") public None()
    {
      super(Type.OPTION_NONE);
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
      return true;
    }

    @Override public int hashCode()
    {
      return 0;
    }

    @Override public String toString()
    {
      final StringBuilder builder = new StringBuilder();
      builder.append("[None]");
      return builder.toString();
    }
  }

  /**
   * Type enclosing a value.
   */

  public static class Some<A> extends Option<A>
  {
    public final A value;

    @SuppressWarnings("synthetic-access") public Some(
      final A value)
    {
      super(Type.OPTION_SOME);
      this.value = value;
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
      final Some<?> other = (Some<?>) obj;
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
      int result = 1;
      result =
        (prime * result) + ((this.value == null) ? 0 : this.value.hashCode());
      return result;
    }

    @Override public String toString()
    {
      final StringBuilder builder = new StringBuilder();
      builder.append("[Some ");
      builder.append(this.value);
      builder.append("]");
      return builder.toString();
    }
  }

  public static enum Type
  {
    OPTION_SOME,
    OPTION_NONE
  }

  public final @Nonnull Type type;

  private Option(
    final @Nonnull Type type)
  {
    this.type = type;
  }

  /**
   * Return <code>true</code> iff this value is a <code>None</code>.
   */

  public final boolean isNone()
  {
    return this.type == Type.OPTION_NONE;
  }

  /**
   * Return <code>true</code> iff this value is a <code>Some</code>.
   */

  public final boolean isSome()
  {
    return this.type == Type.OPTION_SOME;
  }
}
