package info.gratour.jt808common

object JT1078MediaPacketPayloadTypes {

  case class JT1078MediaPacketPayloadType(typ: Int, typeName: String, enumName: String)

  final val G721_VALUE = 1
  final val G722_VALUE = 2
  final val G723_VALUE = 3
  final val G728_VALUE = 4
  final val G729_VALUE = 5
  final val G711A_VALUE = 6
  final val G711U_VALUE = 7
  final val G726_VALUE = 8
  final val G729A_VALUE = 9
  final val DVI4_3_VALUE = 10
  final val DVI4_4_VALUE = 11
  final val DVI4_8K_VALUE = 12
  final val DVI4_16K_VALUE = 13
  final val LPC_VALUE = 14
  final val S16BE_STEREO_VALUE = 15
  final val S16BE_MONO_VALUE = 16
  final val MPEGAUDIO_VALUE = 17
  final val LPCM_VALUE = 18
  final val AAC_VALUE = 19
  final val WMA9STD_VALUE = 20
  final val HEAAC_VALUE = 21
  final val PCM_VOICE_VALUE = 22
  final val PCM_AUDIO_VALUE = 23
  final val AACLC_VALUE = 24
  final val MP3_VALUE = 25
  final val ADPCMA_VALUE = 26
  final val MP4AUDIO_VALUE = 27
  final val AMR_VALUE = 28
  final val PASS_THROUGH_VALUE = 91
  final val H264_VALUE = 98
  final val H265_VALUE = 99
  final val AVS_VALUE = 100
  final val SVAC_VALUE = 101


  final val G721: JT1078MediaPacketPayloadType = JT1078MediaPacketPayloadType(G721_VALUE, "G.721 (1)", "G721")
  final val G722: JT1078MediaPacketPayloadType = JT1078MediaPacketPayloadType(G722_VALUE, "G.722 (2)", "G722")
  final val G723: JT1078MediaPacketPayloadType = JT1078MediaPacketPayloadType(G723_VALUE, "G.723 (3)", "G723")
  final val G728: JT1078MediaPacketPayloadType = JT1078MediaPacketPayloadType(G728_VALUE, "G.728 (4)", "G728")
  final val G729: JT1078MediaPacketPayloadType = JT1078MediaPacketPayloadType(G729_VALUE, "G.729 (5)", "G729")
  final val G711A: JT1078MediaPacketPayloadType = JT1078MediaPacketPayloadType(G711A_VALUE, "G.711A (6)", "G711A")
  final val G711U: JT1078MediaPacketPayloadType = JT1078MediaPacketPayloadType(G711U_VALUE, "G.711U (7)", "G711U")
  final val G726: JT1078MediaPacketPayloadType = JT1078MediaPacketPayloadType(G726_VALUE, "G.726 (8)", "G726")
  final val G729A: JT1078MediaPacketPayloadType = JT1078MediaPacketPayloadType(G729A_VALUE, "G.729A (9)", "G729A")
  final val DVI4_3: JT1078MediaPacketPayloadType = JT1078MediaPacketPayloadType(DVI4_3_VALUE, "DVI4_3 (10)", "DVI4_3")
  final val DVI4_4: JT1078MediaPacketPayloadType = JT1078MediaPacketPayloadType(DVI4_4_VALUE, "DVI4_4 (11)", "DVI4_4")
  final val DVI4_8K: JT1078MediaPacketPayloadType = JT1078MediaPacketPayloadType(DVI4_8K_VALUE, "DVI4_8K (12)", "DVI4_8K")
  final val DVI4_16K: JT1078MediaPacketPayloadType = JT1078MediaPacketPayloadType(DVI4_16K_VALUE, "DVI4_16K (13)", "DVI4_16K")
  final val LPC: JT1078MediaPacketPayloadType = JT1078MediaPacketPayloadType(LPC_VALUE, "LPC (14)", "LPC")
  final val S16BE_STEREO: JT1078MediaPacketPayloadType = JT1078MediaPacketPayloadType(S16BE_STEREO_VALUE, "S16BE_STEREO (15)", "S16BE_STEREO")
  final val S16BE_MONO: JT1078MediaPacketPayloadType = JT1078MediaPacketPayloadType(S16BE_MONO_VALUE, "S16BE_MONO (16)", "S16BE_MONO")
  final val MPEGAUDIO: JT1078MediaPacketPayloadType = JT1078MediaPacketPayloadType(MPEGAUDIO_VALUE, "MPEGAUDIO (17)", "MPEGAUDIO")
  final val LPCM: JT1078MediaPacketPayloadType = JT1078MediaPacketPayloadType(LPCM_VALUE, "LPCM (18)", "LPCM")
  final val AAC: JT1078MediaPacketPayloadType = JT1078MediaPacketPayloadType(AAC_VALUE, "AAC (19)", "AAC")
  final val WMA9STD: JT1078MediaPacketPayloadType = JT1078MediaPacketPayloadType(WMA9STD_VALUE, "WMA9STD (20)", "WMA9STD")
  final val HEAAC: JT1078MediaPacketPayloadType = JT1078MediaPacketPayloadType(HEAAC_VALUE, "HEAAC (21)", "HEAAC")
  final val PCM_VOICE: JT1078MediaPacketPayloadType = JT1078MediaPacketPayloadType(PCM_VOICE_VALUE, "PCM_VOICE (22)", "PCM_VOICE")
  final val PCM_AUDIO: JT1078MediaPacketPayloadType = JT1078MediaPacketPayloadType(PCM_AUDIO_VALUE, "PCM_AUDIO (23)", "PCM_AUDIO")
  final val AACLC: JT1078MediaPacketPayloadType = JT1078MediaPacketPayloadType(AACLC_VALUE, "AACLC (24)", "AACLC")
  final val MP3: JT1078MediaPacketPayloadType = JT1078MediaPacketPayloadType(MP3_VALUE, "MP3 (25)", "MP3")
  final val ADPCMA: JT1078MediaPacketPayloadType = JT1078MediaPacketPayloadType(ADPCMA_VALUE, "ADPCMA (26)", "ADPCMA")
  final val MP4AUDIO: JT1078MediaPacketPayloadType = JT1078MediaPacketPayloadType(MP4AUDIO_VALUE, "MP4AUDIO (27)", "MP4AUDIO")
  final val AMR: JT1078MediaPacketPayloadType = JT1078MediaPacketPayloadType(AMR_VALUE, "AMR (28)", "AMR")
  final val PASS_THROUGH: JT1078MediaPacketPayloadType = JT1078MediaPacketPayloadType(PASS_THROUGH_VALUE, "Pass Through (91)", "PASS_THROUGH")
  final val H264: JT1078MediaPacketPayloadType = JT1078MediaPacketPayloadType(H264_VALUE, "H264 (98)", "H264")
  final val H265: JT1078MediaPacketPayloadType = JT1078MediaPacketPayloadType(H265_VALUE, "H265 (99)", "H265")
  final val AVS: JT1078MediaPacketPayloadType = JT1078MediaPacketPayloadType(AVS_VALUE, "AVS (100)", "AVS")
  final val SVAC: JT1078MediaPacketPayloadType = JT1078MediaPacketPayloadType(SVAC_VALUE, "SVAC (101)", "SVAC")

  val PayloadTypes: Seq[JT1078MediaPacketPayloadType] = Seq(
    G721,
    G722,
    G723,
    G728,
    G729,
    G711A,
    G711U,
    G726,
    G729A,
    DVI4_3,
    DVI4_4,
    DVI4_8K,
    DVI4_16K,
    LPC,
    S16BE_STEREO,
    S16BE_MONO,
    MP4AUDIO,
    LPCM,
    AAC,
    WMA9STD,
    HEAAC,
    PCM_VOICE,
    PCM_AUDIO,
    AACLC,
    MP3,
    ADPCMA,
    MP4AUDIO,
    AMR,
    PASS_THROUGH,
    H264,
    H265,
    AVS,
    SVAC
  )

  final val Types: Map[Int, JT1078MediaPacketPayloadType] = PayloadTypes.map(t => t.typ -> t).toMap

  final val EnumNameMap: Map[String, Int] = PayloadTypes.map(t => t.enumName -> t.typ).toMap

  def typeOf(typ: Int): JT1078MediaPacketPayloadType =
    Types.get(typ).orNull

  /**
   * Get type name of given type ID.
   *
   * @param typ type ID
   * @return type name of given type, or `typ` to string if the type not found.
   */
  def typeNameOf(typ: Int): String = {
    val t = Types.get(typ).orNull
    if (t == null)
      typ.toString
    else
      t.typeName
  }


  /**
   * Get type ID of given enum name.
   *
   * @param enumName the enum name
   * @return corresponding type ID, 0 for unknown
   */
  def typeOfEnumName(enumName: String): Int =
    EnumNameMap.getOrElse(enumName, 0)
}
