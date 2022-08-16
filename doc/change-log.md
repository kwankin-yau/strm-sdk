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
- `com.lucendar.strm.common.strm.stored.AvStoreLog` rename to `com.lucendar.strm.common.strm.stored.StoredAv`, 
  and add `mediaTyp` property.
- `com.lucendar.strm.common.strm.closedlog.ClosedReqLogEntry` removed, use `StrmReqStatus` instead.
- `com.lucendar.strm.common.strm.closedlog.ClosedChannelLogEntry` removed, use `StrmStatus` instead.
- `com.lucendar.strm.common.strm.closedlog.QryClosedLogReq` rename to `com.lucendar.strm.common.strm.closedlog.QryRecentClosedStrmReq`,
  and add `__page`, `__limit` properties, move to `stat` package.
- `com.lucendar.strm.common.strm.log.StrmChannelLogEntry` rename to `com.lucendar.strm.common.strm.log.StrmLogEntry`
- `com.lucendar.strm.common.strm.KeepChannelReq` rename to `com.lucendar.strm.common.strm.KeepStrmReq`
- `com.lucendar.strm.common.strm.KeepChannelItemResult` rename to `com.lucendar.strm.common.strm.KeepStrmReqResult`
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
