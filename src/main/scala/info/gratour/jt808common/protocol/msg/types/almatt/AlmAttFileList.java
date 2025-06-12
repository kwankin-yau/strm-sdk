package info.gratour.jt808common.protocol.msg.types.almatt;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * 主动安全报警附件文件列表
 */
public class AlmAttFileList {

    private List<AlmAttFileItem> fileItems;
    private boolean reTransfer;

    /**
     * 取文件列表
     * @return 文件列表
     */
    public List<AlmAttFileItem> getFileItems() {
        return fileItems;
    }

    /**
     * 设置文件列表
     * @param fileItems 文件列表
     */
    public void setFileItems(List<AlmAttFileItem> fileItems) {
        this.fileItems = fileItems;
    }

    /**
     * 取是否补传
     *
     * @return 是否补传
     */
    public boolean isReTransfer() {
        return reTransfer;
    }

    /**
     * 设置是否补传
     * @param reTransfer 是否补传
     */
    public void setReTransfer(boolean reTransfer) {
        this.reTransfer = reTransfer;
    }

    /**
     * 添加文件
     * @param fileItem 文件
     */
    public void add(AlmAttFileItem fileItem) {
        if (fileItems == null)
            fileItems = new ArrayList<>();

        fileItems.add(fileItem);
    }

    /**
     * 根据文件名获取文件项对象
     * @param fileName 文件名
     * @return 文件项对象
     */
    public AlmAttFileItem itemOf(String fileName) {
        if (fileItems != null) {
            for (AlmAttFileItem item : fileItems) {
                if (item.getFileName().equals(fileName))
                    return item;
            }
        }

        return null;
    }

    /**
     * 清空文件列表
     */
    public void clear() {
        if (fileItems != null)
            fileItems.clear();
    }

    /**
     * 将文件列表转换为字符串
     * @return 文件列表字符串
     */
    private String fileListToString() {
        if (fileItems != null) {
            StringBuilder str = new StringBuilder("[");
            for (AlmAttFileItem item : fileItems) {
                str.append(item).append(",");
            }

            str.append(']');
            return str.toString();
        } else {
            return "[]";
        }
    }

    /**
     * 判断所有文件是否上传完成
     * @return 是否所有文件上传完成
     */
    public boolean allFileCompleted() {
        if (fileItems == null)
            return false;

        for (AlmAttFileItem item: fileItems) {
            if (!item.isUploadCompleted())
                return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AlmAttFileList.class.getSimpleName() + "[", "]")
                .add("fileItems=" + fileItems)
                .add("reTransfer=" + reTransfer)
                .toString();
    }
}
