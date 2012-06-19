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

package com.io7m.jaux.tests;

import java.io.IOException;
import java.util.Properties;

import javax.annotation.Nonnull;

import org.junit.Assert;
import org.junit.Test;

import com.io7m.jaux.Constraints.ConstraintError;
import com.io7m.jaux.PropertyUtils;
import com.io7m.jaux.PropertyUtils.ValueIncorrectType;
import com.io7m.jaux.PropertyUtils.ValueNotFound;

/**
 * Tests to ensure the property interface is working correctly.
 */

public class PropertyUtilsTest
{
  /*
   * String
   */

  @SuppressWarnings("static-method") @Test public final void testGetBoolean()
    throws ValueNotFound,
      ValueIncorrectType,
      ConstraintError
  {
    final @Nonnull Properties properties = new Properties();
    properties.put("key", "true");
    Assert.assertTrue(true == (PropertyUtils.getBoolean(properties, "key")));
  }

  @SuppressWarnings("static-method") @Test(
    expected = ValueIncorrectType.class) public final
    void
    testGetBooleanBadType()
      throws ValueNotFound,
        ValueIncorrectType,
        ConstraintError
  {
    final @Nonnull Properties properties = new Properties();
    properties.put("key", "Z");
    Assert.assertTrue(false == (PropertyUtils.getBoolean(properties, "key")));
  }

  @SuppressWarnings("static-method") @Test public final
    void
    testGetBooleanFalse()
      throws ValueNotFound,
        ValueIncorrectType,
        ConstraintError
  {
    final @Nonnull Properties properties = new Properties();
    properties.put("key", "false");
    Assert.assertTrue(false == (PropertyUtils.getBoolean(properties, "key")));
  }

  @SuppressWarnings("static-method") @Test(expected = ValueNotFound.class) public final
    void
    testGetBooleanMissing()
      throws ValueNotFound,
        ValueIncorrectType,
        ConstraintError
  {
    PropertyUtils.getBoolean(new Properties(), "key");
  }

  /*
   * Integer
   */

  @SuppressWarnings("static-method") @Test public final void testGetInteger()
    throws ValueNotFound,
      ValueIncorrectType,
      ConstraintError
  {
    final @Nonnull Properties properties = new Properties();
    properties.put("key", "23");
    Assert.assertTrue(23 == (PropertyUtils.getInteger(properties, "key")));
  }

  @SuppressWarnings("static-method") @Test(
    expected = ValueIncorrectType.class) public final
    void
    testGetIntegerBadType()
      throws ValueNotFound,
        ValueIncorrectType,
        ConstraintError
  {
    final @Nonnull Properties properties = new Properties();
    properties.put("key", "Z");
    Assert.assertTrue(23 == (PropertyUtils.getInteger(properties, "key")));
  }

  @SuppressWarnings("static-method") @Test(expected = ValueNotFound.class) public final
    void
    testGetIntegerMissing()
      throws ValueNotFound,
        ValueIncorrectType,
        ConstraintError
  {
    PropertyUtils.getInteger(new Properties(), "key");
  }

  @SuppressWarnings("static-method") @Test public final
    void
    testGetOptionalBoolean()
      throws ValueIncorrectType,
        ConstraintError
  {
    final @Nonnull Properties properties = new Properties();
    properties.put("key", "true");
    Assert.assertTrue(true == (PropertyUtils.getOptionalBoolean(
      properties,
      "key",
      false)));
  }

  @SuppressWarnings("static-method") @Test(
    expected = ValueIncorrectType.class) public final
    void
    testGetOptionalBooleanBadType()
      throws ValueIncorrectType,
        ConstraintError
  {
    final @Nonnull Properties properties = new Properties();
    properties.put("key", "Z");
    PropertyUtils.getOptionalBoolean(properties, "key", false);
  }

  @SuppressWarnings("static-method") @Test public final
    void
    testGetOptionalBooleanFalse()
      throws ValueIncorrectType,
        ConstraintError
  {
    final @Nonnull Properties properties = new Properties();
    properties.put("key", "false");
    Assert.assertTrue(false == (PropertyUtils.getOptionalBoolean(
      properties,
      "key",
      true)));
  }

  /*
   * Real
   */

  @SuppressWarnings("static-method") @Test public final
    void
    testGetOptionalBooleanMissing()
      throws ValueIncorrectType,
        ConstraintError
  {
    Assert.assertTrue(true == (PropertyUtils.getOptionalBoolean(
      new Properties(),
      "key",
      true)));
  }

  @SuppressWarnings("static-method") @Test public final
    void
    testGetOptionalInteger()
      throws ValueIncorrectType,
        ConstraintError
  {
    final @Nonnull Properties properties = new Properties();
    properties.put("key", "23");
    Assert.assertTrue(23 == (PropertyUtils.getOptionalInteger(
      properties,
      "key",
      47)));
  }

  @SuppressWarnings("static-method") @Test(
    expected = ValueIncorrectType.class) public final
    void
    testGetOptionalIntegerBadType()
      throws ValueIncorrectType,
        ConstraintError
  {
    final @Nonnull Properties properties = new Properties();
    properties.put("key", "Z");
    PropertyUtils.getOptionalInteger(properties, "key", 47);
  }

  @SuppressWarnings("static-method") @Test public final
    void
    testGetOptionalIntegerMissing()
      throws ValueIncorrectType,
        ConstraintError
  {
    Assert.assertTrue(47 == (PropertyUtils.getOptionalInteger(
      new Properties(),
      "key",
      47)));
  }

  @SuppressWarnings("static-method") @Test public final
    void
    testGetOptionalReal()
      throws ValueIncorrectType,
        ConstraintError
  {
    final @Nonnull Properties properties = new Properties();
    properties.put("key", "23.0");
    Assert.assertTrue(23.0 == (PropertyUtils.getOptionalReal(
      properties,
      "key",
      47.0)));
  }

  @SuppressWarnings("static-method") @Test(
    expected = ValueIncorrectType.class) public final
    void
    testGetOptionalRealBadType()
      throws ValueIncorrectType,
        ConstraintError
  {
    final @Nonnull Properties properties = new Properties();
    properties.put("key", "Z");
    PropertyUtils.getOptionalReal(properties, "key", 23.0);
  }

  /*
   * Boolean
   */

  @SuppressWarnings("static-method") @Test public final
    void
    testGetOptionalRealMissing()
      throws ValueIncorrectType,
        ConstraintError
  {
    Assert.assertTrue(23.0 == (PropertyUtils.getOptionalReal(
      new Properties(),
      "key",
      23.0)));
  }

  @SuppressWarnings("static-method") @Test public final
    void
    testGetOptionalString()
      throws ConstraintError
  {
    final @Nonnull Properties properties = new Properties();
    properties.put("key", "old_value");
    Assert.assertTrue("old_value".equals(PropertyUtils.getOptionalString(
      properties,
      "key",
      "value")));
  }

  @SuppressWarnings("static-method") @Test public final
    void
    testGetOptionalStringMissing()
      throws ConstraintError
  {
    Assert.assertTrue("value".equals(PropertyUtils.getOptionalString(
      new Properties(),
      "key",
      "value")));
  }

  @SuppressWarnings("static-method") @Test public final void testGetReal()
    throws ValueNotFound,
      ValueIncorrectType,
      ConstraintError
  {
    final @Nonnull Properties properties = new Properties();
    properties.put("key", "23.0");
    Assert.assertTrue(23.0 == (PropertyUtils.getReal(properties, "key")));
  }

  @SuppressWarnings("static-method") @Test(
    expected = ValueIncorrectType.class) public final
    void
    testGetRealBadType()
      throws ValueNotFound,
        ValueIncorrectType,
        ConstraintError
  {
    final @Nonnull Properties properties = new Properties();
    properties.put("key", "Z");
    Assert.assertTrue(23.0 == (PropertyUtils.getReal(properties, "key")));
  }

  @SuppressWarnings("static-method") @Test(expected = ValueNotFound.class) public final
    void
    testGetRealMissing()
      throws ValueNotFound,
        ValueIncorrectType,
        ConstraintError
  {
    PropertyUtils.getReal(new Properties(), "key");
  }

  @SuppressWarnings("static-method") @Test public final void testGetString()
    throws ValueNotFound,
      ConstraintError
  {
    final @Nonnull Properties properties = new Properties();
    properties.put("key", "value");
    Assert.assertTrue("value".equals(PropertyUtils.getString(
      properties,
      "key")));
  }

  @SuppressWarnings("static-method") @Test(expected = ValueNotFound.class) public final
    void
    testGetStringMissing()
      throws ValueNotFound,
        ConstraintError
  {
    PropertyUtils.getString(new Properties(), "key");
  }

  /*
   * Loading.
   */

  @SuppressWarnings("static-method") @Test public final void testLoad()
    throws IOException,
      ConstraintError,
      ValueNotFound,
      ValueIncorrectType
  {
    final @Nonnull Properties properties =
      PropertyUtils
        .loadFromFile("src/test/resources/PropertyUtilsTest.properties");
    Assert.assertTrue(PropertyUtils.getInteger(properties, "integer") == 23);
  }

  @SuppressWarnings("static-method") @Test(expected = IOException.class) public final
    void
    testLoadNonexistent()
      throws IOException,
        ConstraintError
  {
    PropertyUtils.loadFromFile("nonexistent");
  }
}
