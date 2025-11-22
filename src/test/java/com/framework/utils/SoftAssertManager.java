package com.framework.utils;

import org.testng.asserts.SoftAssert;

public class SoftAssertManager {

    private static ThreadLocal<SoftAssert> softAssert = new ThreadLocal<>();

    // Get a single SoftAssert instance for the test/thread
    public static SoftAssert getSoftAssert() {
        if (softAssert.get() == null) {
            softAssert.set(new SoftAssert());
        }
        return softAssert.get();
    }

    // Call assertAll once per test
    public static void assertAll() {
        if (softAssert.get() != null) {
            softAssert.get().assertAll();
            softAssert.remove();
        }
    }
}
