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

    /**
     * 将文件名和文件路径拼接成一个带路径的文件名（并不是可直接访问的全文件名）
     * @param path 文件路径
     * @param fileName 文件名
     * @param withLeadingForwardSlash 返回的带路径文件名是否包含前面的 `/` 符号
     * @return 带路径的文件名
     */
    public static String calcFileNameWithPath(String path, String fileName, boolean withLeadingForwardSlash) {
        String s = path;
        if (s == null || s.isEmpty()) {
            if (withLeadingForwardSlash)
                s = "/";
            else
                s = "";
        } else if (withLeadingForwardSlash) {
            if (!s.startsWith("/"))
                s = "/" + s;
        } else {
            if (s.startsWith("/"))
                s = s.substring(1); // remove the forward slash
        }


        if (!s.endsWith("/"))
            s = s + "/";

        return s + fileName;
    }


}
