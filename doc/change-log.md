# 3.3.4 - [2022-01-01]
## Improvement
- `SubscribeChannelResult` add `taUrl` property

## Changed
- Internal update (forward honor the request uri security)
- Dependencies:
  - Bump `spring-boot` from `2.5.4` to `2.5.8`
  - Bump `spring` from `5.3.9` to `5.3.14`
  - Bump `gratour-common` from `3.2.2` to `3.2.4`

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
