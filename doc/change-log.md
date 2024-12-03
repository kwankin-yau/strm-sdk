# 4.1.0 [2024-11-12]
## 完善
- 新增 `SetTokenReq` 类
## 变更
- `GnssOpenStrmReq.FORMAT__HTTP_FLV` 重命名为 `GnssOpenStrmReq.FORMAT__FLV`

# 4.0.0 [2024-01-16]
## 完善
- 引入 GNSS 驱动
- `JT808Msg` 增加 `headers` 属性
- `JT808Frame` 改为只读对象，并增加 `backOffReader` 属性
- `TermCmdStateChanged` 增加 `uuid`, `pub` 属性, `setRandomUuid`, `tmAsEpochMillis`, `applyTo` 方法
- 新增 `info.gratour.jt808common.adas.AdasAlmTypes` 平台ADAS报警类型定义类
- `MQEventAddt_0800_MultiMediaEvent` 新增 MEDIA_TYPE__xxxx, MEDIA_FMT__xxxx, EVT_TYPE__xxxx 等常量定义.
- 新增 `MBEncoder808_Track.encodeTrackBasicInfo` 方法
- 新增 `MBEncoder808_0800_MultiMediaEvent`, `MBEncoder808_0801_MultiMediaData` 两个消息体编码器
- 新增 `AppInfo` 接口
- 新增 `StrmServerInfo2`
- `ServerInfo` 增加 `api` 属性
- 使 `GnssLoginResult` 继承 `ServerInfo`
- 新增 `AdasAddt` 接口，令所有 `Adas...Addt` 继承此接口
- `Trk` 新增 `vehId` 属性
- `Trk` 的 `plateColor`, `ioSt`, `adasAlm` 属性改为 `Integer`
- `info.gratour.jt808common.spi.model.Event` 增加 `appId` 属性
- `TermConnState` 实现 `Clonable` 接口
- 补充 `TermCmdMaterializer` 和 `TermCmdStateChangedMaterializer` 中遗漏的属性编解码
- 新增 `com.lucendar.strm.common.strm.stored.TermStoredAvItem` 类
- 新增 `com.lucendar.strm.common.strm.stored.QryTermSideStoredAvReq` 类
- `AvUploadNotif` 增加 `simNo` 属性
- 新增 `QryAdasAlmAttReq`、`AlmAtt` 类
- `User` 和 `TokenValidateResult` 增加 `authorities` 属性。
- 新增 `Alm`, `AlmParam`, `CloseAlmReq` 类 
- `AlmTypes`, `AdasAlmTypes` 补充部分 ADAS 报警类型定义
- 新增DTO `QryStrmMediaNotifRecReq`, `QryStrmCommLogReq`, `QryGatewayCommLogReq` 类
- 新增 `SetTraceMsg` 类
- `TermCmd` 增加 `setParamsJson`, `setAckParamsJson` 方法
- 新增 `QryTermCmdReq` 类
- 新增 `info.gratour.jt808common.JT808Consts.ProtocolVersions.detectProtoVerBySimNoLen` 方法
- `OpenStrmReq` 和 `GnssOpenStrmReq` 去掉 `talkSendProtoVer` 属性 
- `StrmStatus` 增加 `sent` 属性
- 为了避免前端 js 解释时不丢失精度，`TermConnState` 的 `connAt`、`lastActive` 改为 String 类型
- `GnssOpenStrmResult`, `OpenStrmResult` 增加 `channel`, `proto` 属性。
- `StrmMediaNotif` 增加 `aBitrate`, `frameRate` 属性
- 新增 `PagedQuery`, `QryStrmLogReq` 类
- `JT1078MediaPacketPayloadType` 增加常用媒体类型判断方法
- 新增 `FetchAlmAttCompletedAlmAttReadyNotif`、`QryPlayedAvDumpReq` 类
- 新增 `AlmAttFileList`, `FetchAlmAttTask`, `FetchAlmAttLog`, `QryFetchAlmAttTaskReq`, `QryFetchAlmAttLogReq` 类
- 新增 `Expose` 标注，并标注 `TermCmd`, `JT808CmdParams`, `JT808AckParam`, `Trk`等相关的类
- 新增 `com.lucendar.strm.common.strm.log.StrmMqAdaptorLogEntry`, `StrmMqLogEntry`, `QryStrmMqLogEntryReq`, `QryStrmMqAdaptorLogEntryReq` 类

## 不兼容变更
- `AvUploadReq` 增加 `fileSz` 必填属性
- `AdasAlmTypes` 的报警类型编码改为 Micro-GNSS 1.x 的 ADAS 报警类型 编码
- `AdasDialect.GDRTA_2020` 改名为 `AdasDialect.GUANG_DONG`
- `QryAdasAlmAttReq` 增加 `taskId` 参数

## 变更
- `com.lucendar.gnss.sdk.gateway.OnlineOfflineNotif.protoVer` 数据类型由 Integer 改为 String
- `com.lucendar.gnss.sdk.gateway.TermConnState.protoVer` 数据类型由 Integer 改为 String
- 删去 `SseEventSource`
- `StoredAv` 重命名为 `PlayedAvDump`
- 依赖
  - 合并 `micro-gnss-sdk` 3.4.4
  - 合并 `jt808-common` 3.0.1
  - `lucendar-common` 升级到 2.2.0
 
# 3.4.4 - [2023-11-28]
## Improvement
- AvUpload2:
  - add `avResPath` static method
  - add `strmInst` property
  - add `fileNameWithPathUrl` method
- StreamingApi add `BEIJING_ZONE_OFFSET` constant
- Introduce `ScopedSimNo`
- Introduce `com.lucendar.strm.common.strm.stored.RegisterAvUploadReq.assign`

## Changed
- Maven group changed `com.lucendar`
- `timeCodedId`, `extractTimeFromId` method moved to `StrmUtils`

# 3.4.3 - [2023-10-25]
## Improvement
- `OpenStrmReq` add `trace` property.
- `StrmMediaNotif` add the following constants which are used in `micro-gnss`:
  - `CLOSE_CAUSE__openStrmFailed`
  - `CLOSE_CAUSE__requestTimeout`
- `StrmStatus` add `initReqId`, `trace` property.
- `AvUpload` add `appId` properties.
- `AvUpload2` add `appId` properties.
- `StoredAv` add `appId` property.
- `QryStrmActivityReq` add `appId`, `__limit`, `__page` properties.
- `StrmActivity` add `appId` property.
- `StrmLogEntry` add `appId` property.


# 3.4.2 - [2023-07-10]
## Improvement
- `UriScheme` add RTSP and RTMP enum, `defaultSchemeOf()` method
- `OpenStrmReq` add `subFmt`, `inAudioCfg` property
- `StrmMediaNotif` add `ac`, `vc` properties.
- Introduce `MemUsage` to replace the `java.lang.management.MemoryUsage` which cause the InaccessibleObjectException 
  when do GSON conversion.

## Fixed
- `com.lucendar.strm.common.StreamingApi.normalizeSimNo` should only add 0 when all character is digit

# 3.4.1 - [2022-08-18]
## Improvement
- `com.lucendar.strm.common.StreamingApi.STRM_FORMAT__RTSP` added
- `com.lucendar.strm.common.StrmMediaNotif.CLOSE_CAUSE__termCmdFailed` added
- `com.lucendar.strm.common.strm.stored.AVUpload` rename to `AvUpload`

# 3.4.0 - [2022-05-12]
## Changed
- Move inner class from StreamingApi to upper level.
- `SubscribeChannelReq` rename to `OpenChannelReq`.
- Introduce new `AudioConfig` class.
- `OpenChannelReq` add `audioCfg`, `rtspSrc` properties.
- `ChannelStat` add `audioFmtSupported`, `videoFmtSupported`, `frameRate`.
- `ClosedChannelLogEntry` add `audioFmtSupported`, `videoFmtSupported`, `frameRate`.
- Shorten `StrmChannelLogEntry.EVT__XXXX` constants value length, added `EVT__SRC_CLOSED`.
- `com.lucendar.strm.common.strm.OpenChannelReq` rename to `com.lucendar.strm.common.strm.OpenStrmReq`, 
  - add `timedToken`, `detectMediaTyp` properties, 
  - property `channelId` rename to `chanId`,
  - property `uriSchema` rename to `scheme`,
  - property `callback` rename to `cb`
  - property `proto` rename to `fmt`.
- `com.lucendar.strm.common.strm.OpenChannelResult` rename to `com.lucendar.strm.common.strm.OpenStrmResult`
- Introduce new `com.lucendar.strm.common.strm.stat.StrmPerfStat`.
- Shorten `StrmServerStat` property names, remove `recvFromTerm1Minute`, `XXXProcessDelay` properties,
  add `perfStat` property, rename `channelCount` property to `strmCnt`, rename `channels` property to `strms`.
- remove `com.lucendar.strm.common.strm.stat.StrmReportReq`.
- `com.lucendar.strm.common.strm.stat.QryServerStatusReq` add `sysResStat` properties.
- remove `com.lucendar.strm.common.strm.stat.QryServerStatResult`.
- `com.lucendar.strm.common.strm.stat.ChannelReportResult` rename to `QryServerStatusResult`.
- `com.lucendar.strm.common.strm.stat.ChannelStat` rename to `com.lucendar.strm.common.strm.stat.StrmStatus`.
  - property `strmReady` rename to `ready`
  - property `strmReadyTm` rename to `readyTm`
  - property `audioFmt` rename to `aFmt`
  - property `aSupported` rename to `aSupport`
  - property `videoFmt` rename to `vFmt`
  - property `vSupported` rename to `vSupport`
  - property `videoRes` rename to `vRez`.
- `com.lucendar.strm.common.strm.stat.ReqStat` rename to `com.lucendar.strm.common.strm.stat.StrmReqStatus`
  - property `proto` rename to `fmt`
  - proeprty `strmReadyTm` rename to `readyTm`.
- `com.lucendar.strm.common.strm.stored.AvStoreLog` rename to `com.lucendar.strm.common.strm.dump.PlayedAvDump`, 
  and add `mediaTyp` property.
- `com.lucendar.strm.common.strm.closedlog.ClosedReqLogEntry` removed, use `StrmReqStatus` instead.
- `com.lucendar.strm.common.strm.closedlog.ClosedChannelLogEntry` removed, use `StrmStatus` instead.
- `com.lucendar.strm.common.strm.closedlog.QryClosedLogReq` rename to `com.lucendar.strm.common.strm.closedlog.QryRecentClosedStrmReq`,
  and add `__page`, `__limit` properties, move to `stat` package.
- `com.lucendar.strm.common.strm.log.StrmChannelLogEntry` rename to `com.lucendar.strm.common.strm.log.StrmLogEntry`
- `com.lucendar.strm.common.strm.KeepChannelReq` rename to `com.lucendar.strm.common.strm.KeepStrmReq`
- `com.lucendar.strm.common.strm.KeepChannelItemResult` rename to `com.lucendar.strm.common.strm.KeepStrmResult`
- `com.lucendar.strm.common.strm.CheckChannelReq` rename to `com.lucendar.strm.common.strm.CheckStrmReq`
- `com.lucendar.strm.common.strm.ReleaseChannelReqItem` rename to `com.lucendar.strm.common.strm.ReleaseStrmReqItem`
- `com.lucendar.strm.common.strm.ReleaseChannelsReq` rename to `com.lucendar.strm.common.strm.ReleaseStrmsReq`
- `com.lucendar.strm.common.strm.ReleaseChannelsReq2` rename to `com.lucendar.strm.common.strm.ReleaseStrmsReq2`
- remove `com.lucendar.strm.common.StrmMediaNotif.ACT__ctrlGot, ACT__strmPause, ACT__strmResume, ACT__strmSeeking`.
- `com.lucendar.strm.common.strm.OpenStrmResult.keepIntervalSeconds` rename to `com.lucendar.strm.common.strm.OpenStrmResult.keepIntv`.
- `com.lucendar.strm.common.StreamingApi.PROTO__HTTP_FLV` rename to `com.lucendar.strm.common.StreamingApi.PROTO__FLV`.
- `com.lucendar.strm.common.strm.stored.AvUploadProgressRpt` properties rename:
  - `uploadedSize` rename to `uploaded`
- `com.lucendar.strm.common.strm.stored.UpdateAvUploadStateReq` properties rename:
  - `startTime` rename to `startTm`
  - `fileName` rename to `fn`
  - `fileSz` rename to `sz`
- introduce `com.lucendar.strm.common.strm.stored.AvUpload2`

# 3.3.5 - [2022-05-05]
Nothing changed, just change version.

# 3.3.4 - [2022-01-01]
## Improvement
- `SubscribeChannelResult` add `taUrl` property
- Introduce `ReleaseChannelsReq2`
- `StrmMediaNotif` implemented `Cloneable`

## Changed
- Internal update (forward honor the request uri security)
- `StrmMediaNotif`: `codeStream` property rename to `codeStrm`
- `StrmMediaNotif.act` value domain changed:
  - `cmdSent` => `sent`
  - `cmdFailed` => `failed`
  - `strmReady` => `ready`
  - `strmClosed` => `closed`
  - `strmPaused` => `paused`
  - `strmResumed` => `resumed`

# 3.3.3 - [2021-11-15]
## Added
* `AvUploadNotif`
* `AvUploadProgressRpt`

## Changed
- value of `StreamingApi.PROTO__HLS` changed to 1
- value of `StreamingApi.PROTO__RTMP` changed to 2
- `QueryInfoResult` implement `Cloneable` interface
- `SubscribeChannelReq.user` property now is mandatory
- `StrmUserInfo` add `token` property(mandatory)

# 3.3.2 - [2021-11-07]
## Added
* `UriScheme` enum

# 3.3.1 - [2021-10-17]
## Added
* Added new type: `QryInfoResult`.

## Changed
* com.lucendar.strm.common.StreamingApi.StreamingConfig: removed `govLiveStrmPort`, `govReplayStrmPort`
* `com.lucendar.strm.common.StreamingApi.ReqStat` add `lastKeep` property.
