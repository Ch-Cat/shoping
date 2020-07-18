package com.yx.common.utils;

import java.util.ResourceBundle;

/**
 * Symphony utilities.
 */
public final class Symphonys {

    /**
     * Configurations.
     */
    private static final ResourceBundle CFG = ResourceBundle.getBundle("symphony");

   

    /**
     * Gets a configuration string property with the specified key.
     *
     * @param key the specified key
     * @return string property value corresponding to the specified key, returns {@code null} if not found
     */
    public static String get(final String key) {
        return CFG.getString(key);
    }

    /**
     * Gets a configuration boolean property with the specified key.
     *
     * @param key the specified key
     * @return boolean property value corresponding to the specified key, returns {@code null} if not found
     */
    public static Boolean getBoolean(final String key) {
        final String stringValue = get(key);

        if (null == stringValue) {
            return null;
        }

        return Boolean.valueOf(stringValue);
    }

    /**
     * Gets a configuration integer property with the specified key.
     *
     * @param key the specified key
     * @return integer property value corresponding to the specified key, returns {@code null} if not found
     */
    public static Integer getInt(final String key) {
        final String stringValue = get(key);
        if (null == stringValue) {
            return null;
        }

        return Integer.valueOf(stringValue);
    }

    /**
     * Gets a configuration long property with the specified key.
     *
     * @param key the specified key
     * @return long property value corresponding to the specified key, returns {@code null} if not found
     */
    public static Long getLong(final String key) {
        final String stringValue = get(key);
        if (null == stringValue) {
            return null;
        }

        return Long.valueOf(stringValue);
    }

    /**
     * Private default constructor.
     */
    private Symphonys() {
    }
}
