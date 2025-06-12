/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jtcommon

import java.io.{Closeable, InputStream, OutputStream}


/**
 * 文件仓库接口
 */
trait FileRepository {

  /**
   * 获取Bucket
   * @param name Bucket名
   * @return Bucket
   */
  def bucket(name: String): FileBucket
}

/**
 * Bucket名称
 */
object FileBucketNames {

  /**
   * ADAS报警附件
   */
  val AlmAtt = "almatt"

  /**
   * 多媒体
   */
  val MultiMedia = "mm"

  /**
   * 视频上传
   */
  val AvUpload = "av-upload"

  /**
   * 实时播放转储
   */
  val Strm = "strm"
}

/**
 * 文件Bucket接口
 */
trait FileBucket {
  /**
   * 获取Bucket名称
   * @return Bucket名称
   */
  def bucketName: String

  /**
   * 检查文件是否存在
   * @param fileName 文件名
   * @return 是否存在
   */
  def exist(fileName: String): Boolean

  /**
   * 创建文件
   * @param fileName 文件名
   * @return 文件资源
   */
  def create(fileName: String): WritableFileResource

  /**
   * 打开文件
   * @param fileName 文件名
   * @return 文件资源
   */
  def openRead(fileName: String): ReadableFileResource

  /**
   * 删除文件
   * @param fileName 文件名
   * @return 是否删除成功
   */
  def delete(fileName: String): Boolean
}

/**
 * 文件资源接口
 */
trait FileResource extends Closeable{
  /**
   * 获取Bucket
   * @return Bucket
   */
  def getBucket: FileBucket

  /**
   * 获取文件名
   * @return 文件名
   */
  def getFileName: String
}

/**
 * 可写文件资源接口
 */
trait WritableFileResource extends FileResource {

  /**
   * Get OutputStream object of this resource. Note that the output stream will be created in this resource object creation,
   * and return the reference each time this method called. This output stream will be closed when the close() method
   * of resource called.
   *
   * @return OutputStream object of this resource
   */
  def outputStream(): OutputStream
}

/**
 * 可读文件资源接口
 */
trait ReadableFileResource extends FileResource {

  /**
   * Get InputStream object of this resource. Note that the input stream will created in this resource object creation,
   * and return the reference each time this method called. This input stream will be closed when the close() method
   * of resource called.
   *
   * @return InputStream object of this resource
   */
  def inputStream(): InputStream
}

/**
 * 文件资源解析器接口
 */
trait FileResourceResolver {

  /**
   * 获取文件URL
   * @param bucketName Bucket名称
   * @param fileWithPath 文件路径
   * @return 文件URL
   */
  def url(bucketName: String, fileWithPath: String): String

  /**
   * 获取文件URL
   * @param resource 文件资源
   * @return 文件URL
   */
  def url(resource: FileResource): String = url(resource.getBucket.bucketName, resource.getFileName)
}
