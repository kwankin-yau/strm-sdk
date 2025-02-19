/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jtcommon

/**
 * JT/T 内存数据库规范
 */
object JTMemDbSpec {

  /**
   * 会话令牌
   */
  object SessionToken {
    /**
     * 键前缀
     */
    val KeyPrefix = "s:"

    /**
     * 构造键
     * @param token 令牌
     * @return 键
     */
    def key(token: String): String = KeyPrefix + token
  }

  /**
   * 当前报警相关内存数据库定义
   */
  object CurrAlm {

    /**
     * 键前缀
     */
    val KeyPrefix = "calm:"

    /**
     * 构造键
     * @param simNo 手机号
     * @param typ 类型
     * @return 键
     */
    def key(simNo: String, typ: String): String = KeyPrefix + simNo + ":" + typ
  }

  /**
   * 车辆当前驾驶相关内存数据库定义
   */
  object VehCurrDrv {

    /**
     * 键前缀
     */
    val KeyPrefix = "vcd:"

    /**
     * 构造键
     * @param vehId 车辆ID
     * @return 键
     */
    def key(vehId: Long): String = KeyPrefix + vehId
  }

//  object AlmTm1Mapping {
//    val KeyPrefix = "almtm1:"
//    def key(almId: Long): String = KeyPrefix + almId
//  }

}
