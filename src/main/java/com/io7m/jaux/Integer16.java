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

import javax.annotation.Nonnull;
import javax.annotation.concurrent.ThreadSafe;

/**
 * 16-bit integer packing/unpacking functions.
 * 
 * @since 2.6.0
 */

@ThreadSafe public final class Integer16
{
  public static @Nonnull byte[] packBigEndian(
    final int i)
  {
    final byte[] r = new byte[2];
    int x = i;

    r[1] = (byte) (x & 0xff);
    x >>= 8;
    r[0] = (byte) (x & 0xff);

    return r;
  }

  public static @Nonnull byte[] packLittleEndian(
    final int i)
  {
    final byte[] r = new byte[2];
    int x = i;

    r[0] = (byte) (x & 0xff);
    x >>= 8;
    r[1] = (byte) (x & 0xff);
    x >>= 8;

    return r;
  }

  public static int unpackBigEndian(
    final @Nonnull byte[] buffer)
  {
    assert (buffer.length == 2);

    int r = (buffer[0] & 0xff);
    r <<= 8;
    r += (buffer[1] & 0xff);

    return r;
  }

  public static int unpackLittleEndian(
    final @Nonnull byte[] buffer)
  {
    assert (buffer.length == 2);

    int r = (buffer[1] & 0xff);
    r <<= 8;
    r += (buffer[0] & 0xff);

    return r;
  }

  private Integer16()
  {
    throw new UnreachableCodeException();
  }

}
