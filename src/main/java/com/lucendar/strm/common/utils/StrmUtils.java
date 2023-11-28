package com.lucendar.strm.common.utils;

public class StrmUtils {

    private static final char[] HEX_CHARS = "0123456789abcdef".toCharArray();
    public static String bytesToHex(byte[] bytes) {
        if (bytes == null)
            throw new NullPointerException("bytes");

        char[] r = new char[bytes.length * 2];

        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            r[j * 2] = HEX_CHARS[v >>> 4];
            r[j * 2 + 1] = HEX_CHARS[v & 0x0F];
        }

        return new String(r);
    }
}
