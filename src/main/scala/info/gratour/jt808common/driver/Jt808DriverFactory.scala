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

class Jt808DriverFactory extends GnssDriverFactory {

  override def id(): String = DRIVER_ID

  override def createDriver(
                             config           : java.util.Map[String, String],
                             adasDialect      : AdasDialect,
                             verifyCrc        : Boolean,
                             simplifiedDecoder: Boolean,
                             ctx              : GnssDriverContext
                           ): Jt808Driver =
    new Jt808Driver(config, adasDialect, verifyCrc, simplifiedDecoder, ctx)

  override def probe(byteBuf: ByteBuf): Boolean =
    byteBuf.getByte(0) == 0x7E

}

object Jt808DriverFactory {
  private final val LOGGER = Logger("jt808.driverFactory")
  final val DRIVER_ID = "jt808"

}
