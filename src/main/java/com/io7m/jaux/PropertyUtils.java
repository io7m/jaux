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

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.ThreadSafe;

import com.io7m.jaux.Constraints.ConstraintError;

/** Type-safe interface to Properties. */

@ThreadSafe public final class PropertyUtils
{
  /**
   * Exception raised a value of an incorrect type was found in the given
   * property set.
   */

  public static class ValueIncorrectType extends Throwable
  {
    private static final long serialVersionUID = 1L;

    public ValueIncorrectType(
      final @Nonnull String key,
      final @Nonnull String wanted)
    {
      super("could not parse key \"" + key + "\" as " + wanted);
    }
  }

  /**
   * Exception raised when a non-optional value was not found in the given
   * property set.
   */

  public static class ValueNotFound extends Throwable
  {
    private static final long serialVersionUID = 1L;

    public ValueNotFound(
      final @Nonnull String key)
    {
      super("key \"" + key + "\" is undefined");
    }
  }

  /**
   * Returns the boolean value associated with <code>key</code> in the
   * properties referenced by <code>properties</code>.
   * 
   * @exception ValueNotFound
   *              If the given key is not present in the given properties.
   * @exception ValueIncorrectType
   *              If the given key is present but the value cannot be parsed
   *              as a boolean value.
   * @throws ConstraintError
   *           Iff the given key or set of properties is null.
   */

  public static boolean getBoolean(
    final @Nonnull Properties properties,
    final @Nonnull String key)
    throws ValueNotFound,
      ValueIncorrectType,
      ConstraintError
  {
    Constraints.constrainNotNull(properties, "input properties");
    Constraints.constrainNotNull(key, "key");

    final @Nonnull String value = PropertyUtils.getString(properties, key);

    if (value.equalsIgnoreCase("true")) {
      return true;
    }
    if (value.equalsIgnoreCase("false")) {
      return false;
    }
    throw new ValueIncorrectType(key, "boolean");
  }

  /**
   * Returns the integer value associated with <code>key</code> in the
   * properties referenced by <code>properties</code>.
   * 
   * @param properties
   *          The loaded properties.
   * 
   * @param key
   *          The requested key.
   * 
   * @exception ValueNotFound
   *              If the given key is not present in the given properties.
   * 
   * @exception ValueIncorrectType
   *              If the given key is present but cannot be parsed as an
   *              integer.
   * @throws ConstraintError
   *           iff the given key or set of properties is null.
   */

  public static long getInteger(
    final @Nonnull Properties properties,
    final @Nonnull String key)
    throws ValueNotFound,
      ValueIncorrectType,
      ConstraintError
  {
    Constraints.constrainNotNull(properties, "input properties");
    Constraints.constrainNotNull(key, "key");

    final @Nonnull String text = PropertyUtils.getString(properties, key);
    try {
      final long value = Long.parseLong(text);
      return value;
    } catch (final NumberFormatException e) {
      throw new ValueIncorrectType(key, "integer");
    }
  }

  /**
   * Returns the boolean value associated with <code>key</code> in the
   * properties referenced by <code>properties</code>. If the given key is not
   * present in the given properties, <code>default_value</code> is returned.
   * 
   * @param properties
   *          The loaded properties.
   * 
   * @param key
   *          The requested key.
   * 
   * @exception ValueIncorrectType
   *              Iff the given key is present but the value cannot be parsed
   *              as a boolean value.
   * @throws ConstraintError
   *           Iff the given key or set of properties is null.
   */

  public static boolean getOptionalBoolean(
    final @Nonnull Properties properties,
    final @Nonnull String key,
    final boolean default_value)
    throws ValueIncorrectType,
      ConstraintError
  {
    Constraints.constrainNotNull(properties, "input properties");
    Constraints.constrainNotNull(key, "key");

    final @Nonnull String text = properties.getProperty(key);
    if (text == null) {
      return default_value;
    }
    if (text.equalsIgnoreCase("true")) {
      return true;
    }
    if (text.equalsIgnoreCase("false")) {
      return false;
    }
    throw new ValueIncorrectType(key, "boolean");
  }

  /**
   * Returns the integer value associated with <code>key</code> in the
   * properties referenced by <code>properties</code>. If the given key is not
   * present in the given properties, <code>default_value</code> is returned.
   * 
   * @param properties
   *          the loaded properties
   * 
   * @param key
   *          the requested key
   * 
   * @exception ValueIncorrectType
   *              if the given key is present but the value cannot be parsed
   *              as an integer
   * @throws ConstraintError
   *           Iff the given key or set of properties is null
   */

  public static long getOptionalInteger(
    final @Nonnull Properties properties,
    final @Nonnull String key,
    final long default_value)
    throws ValueIncorrectType,
      ConstraintError
  {
    Constraints.constrainNotNull(properties, "input properties");
    Constraints.constrainNotNull(key, "key");

    final @Nonnull String text = properties.getProperty(key);
    if (text == null) {
      return default_value;
    }

    try {
      final long value = Long.parseLong(text);
      return value;
    } catch (final NumberFormatException e) {
      throw new ValueIncorrectType(key, "integer");
    }
  }

  /**
   * Returns the real (floating point) value associated with <code>key</code>
   * in the properties referenced by <code>properties</code>. If the given key
   * is not present in the given properties, <code>default_value</code> is
   * returned.
   * 
   * @param properties
   *          The loaded properties.
   * 
   * @param key
   *          The requested key.
   * 
   * @exception ValueIncorrectType
   *              If the given key is present but the value cannot be parsed
   *              as a floating point value.
   * @throws ConstraintError
   *           Iff the given key or set of properties is null.
   */

  public static double getOptionalReal(
    final @Nonnull Properties properties,
    final @Nonnull String key,
    final double default_value)
    throws ValueIncorrectType,
      ConstraintError
  {
    Constraints.constrainNotNull(properties, "input properties");
    Constraints.constrainNotNull(key, "key");

    final @Nonnull String text = properties.getProperty(key);
    if (text == null) {
      return default_value;
    }

    try {
      final double value = Double.parseDouble(text);
      return value;
    } catch (final NumberFormatException e) {
      throw new ValueIncorrectType(key, "real");
    }
  }

  /**
   * Returns the string value associated with <code>key</code> in the
   * properties referenced by <code>properties</code>. If the given key is not
   * present in the given properties, <code>default_value</code> is returned.
   * 
   * @param properties
   *          The loaded properties.
   * 
   * @param key
   *          The requested key.
   * @throws ConstraintError
   *           Iff the given key, properties, or default value is null.
   */

  public static @Nonnull String getOptionalString(
    final @Nonnull Properties properties,
    final @Nonnull String key,
    final @Nonnull String default_value)
    throws ConstraintError
  {
    Constraints.constrainNotNull(properties, "input properties");
    Constraints.constrainNotNull(key, "key");
    Constraints.constrainNotNull(default_value, "default value");

    final String value = properties.getProperty(key);
    if (value == null) {
      return default_value;
    }
    return value;
  }

  /**
   * Returns the real (floating point) value associated with <code>key</code>
   * in the properties referenced by <code>properties</code>.
   * 
   * @param properties
   *          The loaded properties.
   * 
   * @param key
   *          The requested key.
   * 
   * @exception ValueNotFound
   *              If the given key is not present in the given properties.
   * 
   * @exception ValueIncorrectType
   *              If the given key is present but the value cannot be parsed
   *              as a floating point value.
   * @throws ConstraintError
   *           Iff the given key or set of properties is null.
   */

  public static double getReal(
    final @Nonnull Properties properties,
    final @Nonnull String key)
    throws ValueNotFound,
      ValueIncorrectType,
      ConstraintError
  {
    Constraints.constrainNotNull(properties, "input properties");
    Constraints.constrainNotNull(key, "key");

    final @Nonnull String text = PropertyUtils.getString(properties, key);
    try {
      final double value = Double.parseDouble(text);
      return value;
    } catch (final NumberFormatException e) {
      throw new ValueIncorrectType(key, "real");
    }
  }

  /**
   * Returns the string value associated with <code>key</code> in the
   * properties referenced by <code>props</code>
   * 
   * @param properties
   *          The loaded properties.
   * 
   * @param key
   *          The requested key.
   * 
   * @exception ValueNotFound
   *              Iff the given key is not present in the given properties.
   * @throws ConstraintError
   *           Iff the given key or set of properties is null.
   */

  public static @Nonnull String getString(
    final @Nonnull Properties properties,
    final @Nonnull String key)
    throws ValueNotFound,
      ConstraintError
  {
    Constraints.constrainNotNull(properties, "input properties");
    Constraints.constrainNotNull(key, "key");

    final String value = properties.getProperty(key);
    if (value == null) {
      throw new ValueNotFound(key);
    }
    return value;
  }

  /**
   * Load properties from the given file.
   * 
   * @throws IOException
   *           A system I/O error occurs.
   * @throws ConstraintError
   *           Iff the given file name is null.
   */

  public static @Nonnull Properties loadFromFile(
    final @Nonnull String file)
    throws IOException,
      ConstraintError
  {
    Constraints.constrainNotNull(file, "file name");

    final @Nonnull FileInputStream stream = new FileInputStream(file);
    final @Nonnull Properties properties = new Properties();

    try {
      properties.load(stream);
      return properties;
    } finally {
      stream.close();
    }
  }

  private PropertyUtils()
  {
    // Unused.
  }
}
