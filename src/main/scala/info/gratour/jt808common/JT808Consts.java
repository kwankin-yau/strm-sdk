package info.gratour.jt808common;

import info.gratour.common.error.ErrorWithCode;

public class JT808Consts {

    public static class ProtocolVersions {
        public static final byte PROTO_VER__REV2013 = 0;
        public static final byte PROTO_VER__REV2019 = 1;

        public static boolean isValidProtoVer(int ver) {
            return ver == PROTO_VER__REV2013 || ver == PROTO_VER__REV2019;
        }

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
