/*
 * Copyright (c) 2024  lucendar.com.
 * All rights reserved.
 */
package info.gratour.jt808common.driver

import com.lucendar.gnss.sdk.driver.{GnssDriverContext, GnssDriverFactory}
import com.typesafe.scalalogging.Logger
import info.gratour.jt808common.AdasDialect
import info.gratour.jt808common.driver.Jt808DriverFactory.DRIVER_ID
import io.netty.buffer.ByteBuf

/**
 * JT/T 808 驱动程序工厂
 */
class Jt808DriverFactory extends GnssDriverFactory {

  /**
   * 获取驱动程序 ID
   * @return 驱动程序 ID
   */
  override def id(): String = DRIVER_ID

  /**
   * 创建驱动程序
   * @param config 配置
   * @param adasDialect ADAS 方言
   * @param verifyCrc 是否验证 CRC
   * @param simplifiedDecoder 是否简化解码
   * @param ctx 上下文
   * @return 驱动程序
   */
  override def createDriver(
                             config           : java.util.Map[String, String],
                             adasDialect      : AdasDialect,
                             verifyCrc        : Boolean,
                             simplifiedDecoder: Boolean,
                             ctx              : GnssDriverContext
                           ): Jt808Driver =
    new Jt808Driver(config, adasDialect, verifyCrc, simplifiedDecoder, ctx)

  /**
   * 探测给定报文片段可否由当前驱动程序处理
   * @param byteBuf 字节缓冲区
   * @return 是否可处理
   */
  override def probe(byteBuf: ByteBuf): Boolean =
    byteBuf.getByte(0) == 0x7E

}

/**
 * JT/T 808 驱动程序工厂 Companion Object
 */
object Jt808DriverFactory {
  private final val LOGGER = Logger("jt808.driverFactory")
  final val DRIVER_ID = "jt808"

}
