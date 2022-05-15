# 3.4.0 - [2022-05-12]
## Changed
- Move inner class from StreamingApi to upper level

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
