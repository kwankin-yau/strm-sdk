/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.almatt;

import java.util.StringJoiner;

import com.lucendar.strm.common.types.Expose;

/**
 * 带类型的主动安全报警附件信息
 */
@Expose
public class AlmAttFileItemWithType extends AlmAttFileItem {

    private int fileType;

    /**
     * 获取文件类型
     * @return 文件类型
     */
    public int getFileType() {
        return fileType;
    }

    /**
     * 设置文件类型
     * @param fileType 文件类型
     */
    public void setFileType(int fileType) {
        this.fileType = fileType;
    }

    @Override
    public AlmAttFileItemWithType clone() {
        return (AlmAttFileItemWithType) super.clone();
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AlmAttFileItemWithType.class.getSimpleName() + "[", "]")
                .add("fileType=" + fileType)
                .toString();
    }
}
