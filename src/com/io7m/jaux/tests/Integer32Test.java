package com.io7m.jaux.tests;

import junit.framework.Assert;

import org.junit.Test;

import com.io7m.jaux.Integer32;

public class Integer32Test
{
  @SuppressWarnings("boxing") @Test public void testIdentityBE_0()
  {
    final int x = 0;
    final byte[] b = Integer32.packBigEndian(x);
    final int y = Integer32.unpackBigEndian(b);
    Assert.assertEquals(x, y);
    System.out.println(String.format("%x %x\n", x, y));
  }

  @SuppressWarnings("boxing") @Test public void testIdentityBE_0x7fffffff()
  {
    final int x = 0x7fffffff;
    final byte[] b = Integer32.packBigEndian(x);
    final int y = Integer32.unpackBigEndian(b);
    Assert.assertEquals(x, y);
    System.out.println(String.format("%x %x\n", x, y));
  }

  @SuppressWarnings("boxing") @Test public void testIdentityBE_0xffff()
  {
    final int x = 0xffff;
    final byte[] b = Integer32.packBigEndian(x);
    final int y = Integer32.unpackBigEndian(b);
    Assert.assertEquals(x, y);
    System.out.println(String.format("%x %x\n", x, y));
  }

  @SuppressWarnings("boxing") @Test public void testIdentityBE_0xffffffff()
  {
    final int x = 0xffffffff;
    final byte[] b = Integer32.packBigEndian(x);
    final int y = Integer32.unpackBigEndian(b);
    Assert.assertEquals(x, y);
    System.out.println(String.format("%x %x\n", x, y));
  }

  /*
   * LE
   */

  @SuppressWarnings("boxing") @Test public void testIdentityLE_0()
  {
    final int x = 0;
    final byte[] b = Integer32.packLittleEndian(x);
    final int y = Integer32.unpackLittleEndian(b);
    Assert.assertEquals(x, y);
    System.out.println(String.format("%x %x\n", x, y));
  }

  @SuppressWarnings("boxing") @Test public void testIdentityLE_0x7fffffff()
  {
    final int x = 0x7fffffff;
    final byte[] b = Integer32.packLittleEndian(x);
    final int y = Integer32.unpackLittleEndian(b);
    Assert.assertEquals(x, y);
    System.out.println(String.format("%x %x\n", x, y));
  }

  @SuppressWarnings("boxing") @Test public void testIdentityLE_0xffff()
  {
    final int x = 0xffff;
    final byte[] b = Integer32.packLittleEndian(x);
    final int y = Integer32.unpackLittleEndian(b);
    Assert.assertEquals(x, y);
    System.out.println(String.format("%x %x\n", x, y));
  }

  @SuppressWarnings("boxing") @Test public void testIdentityLE_0xffffffff()
  {
    final int x = 0xffffffff;
    final byte[] b = Integer32.packLittleEndian(x);
    final int y = Integer32.unpackLittleEndian(b);
    Assert.assertEquals(x, y);
    System.out.println(String.format("%x %x\n", x, y));
  }
}
