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

package com.io7m.jaux.tests;

import org.junit.Assert;
import org.junit.Test;

import com.io7m.jaux.Integer64;

public class Integer64Test
{
  @SuppressWarnings("static-method") @Test public void testIdentityBE_0()
  {
    final long x = 0;
    final byte[] b = Integer64.packBigEndian(x);
    final long y = Integer64.unpackBigEndian(b);
    Assert.assertEquals(x, y);
  }

  @SuppressWarnings("static-method") @Test public
    void
    testIdentityBE_0x7fffffff()
  {
    final long x = 0x7fffffff;
    final byte[] b = Integer64.packBigEndian(x);
    final long y = Integer64.unpackBigEndian(b);
    Assert.assertEquals(x, y);
  }

  @SuppressWarnings("static-method") @Test public
    void
    testIdentityBE_0x7fffffff_ffffffff()
  {
    final long x = 0x7fffffffffffffffL;
    final byte[] b = Integer64.packBigEndian(x);
    final long y = Integer64.unpackBigEndian(b);
    Assert.assertEquals(x, y);
  }

  @SuppressWarnings("static-method") @Test public
    void
    testIdentityBE_0xffff()
  {
    final long x = 0xffff;
    final byte[] b = Integer64.packBigEndian(x);
    final long y = Integer64.unpackBigEndian(b);
    Assert.assertEquals(x, y);
  }

  @SuppressWarnings("static-method") @Test public
    void
    testIdentityBE_0xffffffff()
  {
    final long x = 0xffffffff;
    final byte[] b = Integer64.packBigEndian(x);
    final long y = Integer64.unpackBigEndian(b);
    Assert.assertEquals(x, y);

  }

  @SuppressWarnings("static-method") @Test public
    void
    testIdentityBE_0xffffffff_ffffffff()
  {
    final long x = 0xffffffffffffffffL;
    final byte[] b = Integer64.packBigEndian(x);
    final long y = Integer64.unpackBigEndian(b);
    Assert.assertEquals(x, y);
  }

  /*
   * LE
   */

  @SuppressWarnings("static-method") @Test public void testIdentityLE_0()
  {
    final long x = 0;
    final byte[] b = Integer64.packLittleEndian(x);
    final long y = Integer64.unpackLittleEndian(b);
    Assert.assertEquals(x, y);
  }

  @SuppressWarnings("static-method") @Test public
    void
    testIdentityLE_0x7fffffff()
  {
    final long x = 0x7fffffff;
    final byte[] b = Integer64.packLittleEndian(x);
    final long y = Integer64.unpackLittleEndian(b);
    Assert.assertEquals(x, y);
  }

  @SuppressWarnings("static-method") @Test public
    void
    testIdentityLE_0x7fffffff_ffffffff()
  {
    final long x = 0x7fffffffffffffffL;
    final byte[] b = Integer64.packLittleEndian(x);
    final long y = Integer64.unpackLittleEndian(b);
    Assert.assertEquals(x, y);
  }

  @SuppressWarnings("static-method") @Test public
    void
    testIdentityLE_0xffff()
  {
    final long x = 0xffff;
    final byte[] b = Integer64.packLittleEndian(x);
    final long y = Integer64.unpackLittleEndian(b);
    Assert.assertEquals(x, y);
  }

  @SuppressWarnings("static-method") @Test public
    void
    testIdentityLE_0xffffffff()
  {
    final long x = 0xffffffff;
    final byte[] b = Integer64.packLittleEndian(x);
    final long y = Integer64.unpackLittleEndian(b);
    Assert.assertEquals(x, y);
  }

  @SuppressWarnings("static-method") @Test public
    void
    testIdentityLE_0xffffffff_ffffffff()
  {
    final long x = 0xffffffffffffffffL;
    final byte[] b = Integer64.packLittleEndian(x);
    final long y = Integer64.unpackLittleEndian(b);
    Assert.assertEquals(x, y);
  }
}
