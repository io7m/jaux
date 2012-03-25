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

import javax.annotation.Nonnull;

/** 64-bit integer packing/unpacking functions. */

public final class Integer64
{
  public static @Nonnull byte[] packBigEndian(
    final long i)
  {
    final byte[] r = new byte[8];
    long x = i;

    r[7] = (byte) (x & 0xff);
    x >>= 8;
    r[6] = (byte) (x & 0xff);
    x >>= 8;
    r[5] = (byte) (x & 0xff);
    x >>= 8;
    r[4] = (byte) (x & 0xff);
    x >>= 8;
    r[3] = (byte) (x & 0xff);
    x >>= 8;
    r[2] = (byte) (x & 0xff);
    x >>= 8;
    r[1] = (byte) (x & 0xff);
    x >>= 8;
    r[0] = (byte) (x & 0xff);

    return r;
  }

  public static @Nonnull byte[] packLittleEndian(
    final long i)
  {
    final byte[] r = new byte[8];
    long x = i;

    r[0] = (byte) (x & 0xff);
    x >>= 8;
    r[1] = (byte) (x & 0xff);
    x >>= 8;
    r[2] = (byte) (x & 0xff);
    x >>= 8;
    r[3] = (byte) (x & 0xff);
    x >>= 8;
    r[4] = (byte) (x & 0xff);
    x >>= 8;
    r[5] = (byte) (x & 0xff);
    x >>= 8;
    r[6] = (byte) (x & 0xff);
    x >>= 8;
    r[7] = (byte) (x & 0xff);

    return r;
  }

  public static long unpackBigEndian(
    final @Nonnull byte[] buffer)
  {
    assert (buffer.length == 8);

    long r = 0;

    r |= buffer[0] & 0xFF;
    r <<= 8;
    r |= buffer[1] & 0xFF;
    r <<= 8;
    r |= buffer[2] & 0xFF;
    r <<= 8;
    r |= buffer[3] & 0xFF;
    r <<= 8;
    r |= buffer[4] & 0xFF;
    r <<= 8;
    r |= buffer[5] & 0xFF;
    r <<= 8;
    r |= buffer[6] & 0xFF;
    r <<= 8;
    r |= buffer[7] & 0xFF;

    return r;
  }

  public static long unpackLittleEndian(
    final @Nonnull byte[] buffer)
  {
    assert (buffer.length == 8);

    long r = 0;

    r |= buffer[7] & 0xFF;
    r <<= 8;
    r |= buffer[6] & 0xFF;
    r <<= 8;
    r |= buffer[5] & 0xFF;
    r <<= 8;
    r |= buffer[4] & 0xFF;
    r <<= 8;
    r |= buffer[3] & 0xFF;
    r <<= 8;
    r |= buffer[2] & 0xFF;
    r <<= 8;
    r |= buffer[1] & 0xFF;
    r <<= 8;
    r |= buffer[0] & 0xFF;

    return r;
  }

  private Integer64()
  {

  }

}
