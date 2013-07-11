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

package com.io7m.jaux.tests.functional;

import org.junit.Assert;
import org.junit.Test;

import com.io7m.jaux.functional.Pair;

public class PairTest
{
  @SuppressWarnings("static-method") @Test public void testCorrect()
  {
    final Pair<Integer, String> p =
      new Pair<Integer, String>(Integer.valueOf(23), "hello");
    Assert.assertEquals(Integer.valueOf(23), p.first);
    Assert.assertEquals("hello", p.second);
  }

  @SuppressWarnings("static-method") @Test public void testEquals()
  {
    final Pair<Integer, Integer> p0 =
      new Pair<Integer, Integer>(Integer.valueOf(23), Integer.valueOf(23));
    final Pair<Integer, Integer> p1 =
      new Pair<Integer, Integer>(Integer.valueOf(23), Integer.valueOf(23));
    final Pair<Integer, Integer> p2 =
      new Pair<Integer, Integer>(null, Integer.valueOf(23));
    final Pair<Integer, Integer> p3 =
      new Pair<Integer, Integer>(Integer.valueOf(23), null);
    final Pair<Integer, Integer> p4 =
      new Pair<Integer, Integer>(Integer.valueOf(32), Integer.valueOf(23));
    final Pair<Integer, Integer> p5 =
      new Pair<Integer, Integer>(Integer.valueOf(23), Integer.valueOf(32));

    Assert.assertEquals(p0, p0);
    Assert.assertFalse(p0.equals(null));
    Assert.assertFalse(p0.equals("hello"));
    Assert.assertFalse(p2.equals(p3));
    Assert.assertFalse(p3.equals(p2));
    Assert.assertFalse(p4.equals(p5));
    Assert.assertFalse(p5.equals(p4));
    Assert.assertEquals(p1, p0);
    Assert.assertEquals(p0, p1);
  }

  @SuppressWarnings("static-method") @Test public void testHashCode()
  {
    final Pair<Integer, Integer> p0 =
      new Pair<Integer, Integer>(Integer.valueOf(23), Integer.valueOf(23));
    final Pair<Integer, Integer> p1 =
      new Pair<Integer, Integer>(Integer.valueOf(23), Integer.valueOf(23));

    Assert.assertEquals(p0.hashCode(), p1.hashCode());
  }

  @SuppressWarnings("static-method") @Test public void testStrings()
  {
    final Pair<Integer, Integer> p0 =
      new Pair<Integer, Integer>(Integer.valueOf(23), Integer.valueOf(23));
    final Pair<Integer, Integer> p1 =
      new Pair<Integer, Integer>(Integer.valueOf(24), Integer.valueOf(23));
    final Pair<Integer, Integer> p2 =
      new Pair<Integer, Integer>(Integer.valueOf(23), Integer.valueOf(24));
    final Pair<Integer, Integer> p3 =
      new Pair<Integer, Integer>(Integer.valueOf(23), Integer.valueOf(23));

    Assert.assertFalse(p0.toString().equals(p1.toString()));
    Assert.assertFalse(p0.toString().equals(p2.toString()));
    Assert.assertTrue(p0.toString().equals(p0.toString()));
    Assert.assertTrue(p0.toString().equals(p3.toString()));
  }
}
