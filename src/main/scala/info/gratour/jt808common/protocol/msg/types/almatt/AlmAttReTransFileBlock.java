/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.almatt;

/**
 * 主动安全报警附件信息重传文件块
 */
public class AlmAttReTransFileBlock implements Cloneable {

    private int offset;
    private int size;

    /**
     * 获取偏移量
     * @return 偏移量
     */
    public int getOffset() {
        return offset;
    }

    /**
     * 设置偏移量
     * @param offset 偏移量
     */
    public void setOffset(int offset) {
        this.offset = offset;
    }

    /**
     * 获取大小
     * @return 大小
     */
    public int getSize() {
        return size;
    }

    /**
     * 设置大小
     * @param size 大小
     */
    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public AlmAttReTransFileBlock clone() {
        try {
            return (AlmAttReTransFileBlock) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "AlmAttReTransFileBlock{" +
                "offset=" + offset +
                ", size=" + size +
                '}';
    }
}
