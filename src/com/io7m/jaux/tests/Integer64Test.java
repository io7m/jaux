package com.io7m.jaux.tests;

import junit.framework.Assert;

import org.junit.Test;

import com.io7m.jaux.Integer64;

public class Integer64Test
{
  @SuppressWarnings("boxing") @Test public void testIdentityBE_0()
  {
    final long x = 0;
    final byte[] b = Integer64.packBigEndian(x);
    final long y = Integer64.unpackBigEndian(b);
    Assert.assertEquals(x, y);
    System.out.println(String.format("%x %x\n", x, y));
  }

  @SuppressWarnings("boxing") @Test public void testIdentityBE_0x7fffffff()
  {
    final long x = 0x7fffffff;
    final byte[] b = Integer64.packBigEndian(x);
    final long y = Integer64.unpackBigEndian(b);
    Assert.assertEquals(x, y);
    System.out.println(String.format("%x %x\n", x, y));
  }

  @SuppressWarnings("boxing") @Test public
    void
    testIdentityBE_0x7fffffff_ffffffff()
  {
    final long x = 0x7fffffffffffffffL;
    final byte[] b = Integer64.packBigEndian(x);
    final long y = Integer64.unpackBigEndian(b);
    Assert.assertEquals(x, y);
    System.out.println(String.format("%x %x\n", x, y));
  }

  @SuppressWarnings("boxing") @Test public void testIdentityBE_0xffff()
  {
    final long x = 0xffff;
    final byte[] b = Integer64.packBigEndian(x);
    final long y = Integer64.unpackBigEndian(b);
    Assert.assertEquals(x, y);
    System.out.println(String.format("%x %x\n", x, y));
  }

  @SuppressWarnings("boxing") @Test public void testIdentityBE_0xffffffff()
  {
    final long x = 0xffffffff;
    final byte[] b = Integer64.packBigEndian(x);
    final long y = Integer64.unpackBigEndian(b);
    Assert.assertEquals(x, y);
    System.out.println(String.format("%x %x\n", x, y));
  }

  @SuppressWarnings("boxing") @Test public
    void
    testIdentityBE_0xffffffff_ffffffff()
  {
    final long x = 0xffffffffffffffffL;
    final byte[] b = Integer64.packBigEndian(x);
    final long y = Integer64.unpackBigEndian(b);
    Assert.assertEquals(x, y);
    System.out.println(String.format("%x %x\n", x, y));
  }

  /*
   * LE
   */

  @SuppressWarnings("boxing") @Test public void testIdentityLE_0()
  {
    final long x = 0;
    final byte[] b = Integer64.packLittleEndian(x);
    final long y = Integer64.unpackLittleEndian(b);
    Assert.assertEquals(x, y);
    System.out.println(String.format("%x %x\n", x, y));
  }

  @SuppressWarnings("boxing") @Test public void testIdentityLE_0x7fffffff()
  {
    final long x = 0x7fffffff;
    final byte[] b = Integer64.packLittleEndian(x);
    final long y = Integer64.unpackLittleEndian(b);
    Assert.assertEquals(x, y);
    System.out.println(String.format("%x %x\n", x, y));
  }

  @SuppressWarnings("boxing") @Test public
    void
    testIdentityLE_0x7fffffff_ffffffff()
  {
    final long x = 0x7fffffffffffffffL;
    final byte[] b = Integer64.packLittleEndian(x);
    final long y = Integer64.unpackLittleEndian(b);
    Assert.assertEquals(x, y);
    System.out.println(String.format("%x %x\n", x, y));
  }

  @SuppressWarnings("boxing") @Test public void testIdentityLE_0xffff()
  {
    final long x = 0xffff;
    final byte[] b = Integer64.packLittleEndian(x);
    final long y = Integer64.unpackLittleEndian(b);
    Assert.assertEquals(x, y);
    System.out.println(String.format("%x %x\n", x, y));
  }

  @SuppressWarnings("boxing") @Test public void testIdentityLE_0xffffffff()
  {
    final long x = 0xffffffff;
    final byte[] b = Integer64.packLittleEndian(x);
    final long y = Integer64.unpackLittleEndian(b);
    Assert.assertEquals(x, y);
    System.out.println(String.format("%x %x\n", x, y));
  }

  @SuppressWarnings("boxing") @Test public
    void
    testIdentityLE_0xffffffff_ffffffff()
  {
    final long x = 0xffffffffffffffffL;
    final byte[] b = Integer64.packLittleEndian(x);
    final long y = Integer64.unpackLittleEndian(b);
    Assert.assertEquals(x, y);
    System.out.println(String.format("%x %x\n", x, y));
  }
}
