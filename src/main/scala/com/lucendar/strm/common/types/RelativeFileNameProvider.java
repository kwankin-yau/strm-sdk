/*
 * Copyright (c) 2024 lucendar.com.
 * All rights reserved.
 */
package com.lucendar.strm.common.types;

/**
 * 文件相对路径提供者
 */
public interface RelativeFileNameProvider {

    /**
     * 取文件相对路径
     * @return 文件相对路径
     */
    String relativeFileName();

    /**
     * 文件相对路径提供者实现
     */
    class RelativeFileName implements RelativeFileNameProvider {

        private final String fileName;

        /**
         * 构造函数
         * @param relativeFileName 文件相对路径
         */
        public RelativeFileName(String relativeFileName) {
            this.fileName = relativeFileName;
        }

        @Override
        public String relativeFileName() {
            return fileName;
        }
    }

}
