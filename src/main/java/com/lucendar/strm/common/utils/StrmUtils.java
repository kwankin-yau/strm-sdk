package com.lucendar.strm.common.utils;

import java.nio.ByteBuffer;
import java.util.Base64;
import java.util.UUID;

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

    public static String timeCodedId(long time) {
        UUID uuid = UUID.randomUUID();
        byte[] bytes = new byte[16 + 8];
        ByteBuffer bb = ByteBuffer.wrap(bytes);

        bb.putLong(time);
        bb.putLong(uuid.getMostSignificantBits());
        bb.putLong(uuid.getLeastSignificantBits());

        return Base64.getUrlEncoder().encodeToString(bytes);
    }

    public static long extractTimeFromId(String id) {
        byte[] bytes = Base64.getUrlDecoder().decode(id);
        ByteBuffer bb = ByteBuffer.wrap(bytes);
        return bb.getLong();
    }



}
