package info.gratour.jt808common;

import info.gratour.common.error.ErrorWithCode;

/**
 * JT/T 808 常量
 */
public class JT808Consts {

    /**
     * 协议版本
     */
    public static class ProtocolVersions {
        /**
         * 2013 版本
         */
        public static final byte PROTO_VER__REV2013 = 0;

        /**
         * 2019 版本
         */
        public static final byte PROTO_VER__REV2019 = 1;

        /**
         * 判断是否有效的协议版本号
         * @param ver 协议版本号
         * @return 是否有效的协议版本号
         */
        public static boolean isValidProtoVer(int ver) {
            return ver == PROTO_VER__REV2013 || ver == PROTO_VER__REV2019;
        }

        /**
         * 根据 终端识别号长度检测协议版本
         * @param simNoLenInBytes 终端识别号长度
         * @return 协议版本
         */
        public static byte detectProtoVerBySimNoLen(int simNoLenInBytes) {
            switch (simNoLenInBytes) {
                case 6:
                    return PROTO_VER__REV2013;
                case 10:
                    return PROTO_VER__REV2019;
                default:
                    throw ErrorWithCode.internalError("Unrecognized simNoLenInBytes: " + simNoLenInBytes);
            }
        }
    }
}
