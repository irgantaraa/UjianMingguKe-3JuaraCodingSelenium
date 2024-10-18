package com.juaracoding;

public class Utils {

    public static void delay(long detik) {
        try {
            Thread.sleep(1000 * detik);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
