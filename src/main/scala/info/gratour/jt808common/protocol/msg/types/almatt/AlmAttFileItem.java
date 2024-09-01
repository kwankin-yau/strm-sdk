/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.almatt;

import java.util.StringJoiner;

/**
 * 主动安全报警附件文件项
 */
public class AlmAttFileItem implements Cloneable {

    private String fileName;
    private int fileSize;
    private transient boolean uploadCompleted;

    /**
     * 取文件名
     * @return 文件名
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * 设置文件名
     * @param fileName 文件名
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * 取文件大小
     * @return 文件大小
     */
    public int getFileSize() {
        return fileSize;
    }

    /**
     * 设置文件大小
     * @param fileSize 文件大小
     */
    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    public boolean isUploadCompleted() {
        return uploadCompleted;
    }

    public void setUploadCompleted(boolean uploadCompleted) {
        this.uploadCompleted = uploadCompleted;
    }

    @Override
    public AlmAttFileItem clone() {
        try {
            return (AlmAttFileItem) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AlmAttFileItem.class.getSimpleName() + "[", "]")
                .add("fileName='" + fileName + "'")
                .add("fileSize=" + fileSize)
                .add("uploadCompleted=" + uploadCompleted)
                .toString();
    }
}
