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

import com.io7m.jaux.functional.Option;
import com.io7m.jaux.functional.Option.None;
import com.io7m.jaux.functional.Option.Some;
import com.io7m.jaux.functional.Option.Type;

public class OptionTest
{
  @SuppressWarnings("static-method") @Test public void testNone()
  {
    final Option<Integer> n = new Option.None<Integer>();
    Assert.assertEquals(Type.OPTION_NONE, n.type);
    Assert.assertTrue(n.isNone());
    Assert.assertFalse(n.isSome());
  }

  @SuppressWarnings("static-method") @Test public void testNoneEquals()
  {
    final None<Integer> n0 = new None<Integer>();
    final None<Integer> n1 = new None<Integer>();

    Assert.assertTrue(n0.equals(n0));
    Assert.assertTrue(n0.equals(n1));
    Assert.assertTrue(n1.equals(n0));
    Assert.assertFalse(n0.equals(Integer.valueOf(23)));
    Assert.assertFalse(n0.equals(null));
  }

  @SuppressWarnings("static-method") @Test public void testNoneHashCode()
  {
    final None<Integer> n0 = new None<Integer>();
    final None<Integer> n1 = new None<Integer>();

    Assert.assertTrue(n0.hashCode() == n0.hashCode());
    Assert.assertTrue(n0.hashCode() == n1.hashCode());
    Assert.assertTrue(n1.hashCode() == n0.hashCode());
    Assert.assertFalse(n0.hashCode() == (Integer.valueOf(23).hashCode()));
  }

  @SuppressWarnings("static-method") @Test public void testNoneStrings()
  {
    final None<Integer> n0 = new None<Integer>();
    final None<Integer> n1 = new None<Integer>();

    Assert.assertTrue(n0.toString().equals(n0.toString()));
    Assert.assertTrue(n0.toString().equals(n1.toString()));
    Assert.assertTrue(n1.toString().equals(n0.toString()));
    Assert.assertFalse(n0.toString().equals(Integer.valueOf(23).toString()));
    Assert.assertFalse(n0.toString().equals(null));
  }

  @SuppressWarnings("static-method") @Test public void testSome()
  {
    final Option<Integer> n = new Option.Some<Integer>(Integer.valueOf(32));
    Assert.assertEquals(Type.OPTION_SOME, n.type);
    Assert.assertTrue(n.isSome());
    Assert.assertFalse(n.isNone());

    final Option.Some<Integer> i = (Some<Integer>) n;
    Assert.assertEquals(32, i.value.intValue());
  }

  @SuppressWarnings("static-method") @Test public void testSomeEquals()
  {
    final Some<Integer> n0 = new Some<Integer>(Integer.valueOf(23));
    final Some<Integer> n1 = new Some<Integer>(Integer.valueOf(23));
    final Some<Integer> n2 = new Some<Integer>(null);
    final Some<Integer> n3 = new Some<Integer>(null);

    Assert.assertTrue(n0.equals(n0));
    Assert.assertTrue(n0.equals(n1));
    Assert.assertTrue(n1.equals(n0));
    Assert.assertFalse(n0.equals(Integer.valueOf(23)));
    Assert.assertFalse(n0.equals(null));
    Assert.assertFalse(n0.equals(n2));
    Assert.assertFalse(n2.equals(n0));
    Assert.assertTrue(n2.equals(n3));
  }

  @SuppressWarnings("static-method") @Test public void testSomeHashCode()
  {
    final Some<Integer> n0 = new Some<Integer>(Integer.valueOf(23));
    final Some<Integer> n1 = new Some<Integer>(Integer.valueOf(23));

    Assert.assertTrue(n0.hashCode() == n0.hashCode());
    Assert.assertTrue(n0.hashCode() == n1.hashCode());
    Assert.assertTrue(n1.hashCode() == n0.hashCode());
    Assert.assertFalse(n0.hashCode() == (Integer.valueOf(23).hashCode()));
  }

  @SuppressWarnings("static-method") @Test public void testSomeStrings()
  {
    final Some<Integer> n0 = new Some<Integer>(Integer.valueOf(23));
    final Some<Integer> n1 = new Some<Integer>(Integer.valueOf(23));

    Assert.assertTrue(n0.toString().equals(n0.toString()));
    Assert.assertTrue(n0.toString().equals(n1.toString()));
    Assert.assertTrue(n1.toString().equals(n0.toString()));
    Assert.assertFalse(n0.toString().equals(Integer.valueOf(23).toString()));
    Assert.assertFalse(n0.toString().equals(null));
  }
}
