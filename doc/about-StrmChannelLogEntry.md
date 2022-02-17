# StrmChannelLogEntry

## Event data type and data key

| Data key         | Data Type | Description              | `subscribe` | `identified`  | `strm_ready` | `request_closed` |
|------------------|-----------|--------------------------|:-----------:|:-------------:|:------------:|:----------------:|
| `firstReq`       | boolean   | 是否第一个客户端请求               |      Y      |               |              |                  |
| `liveDataTyp`    | int       | 实时播放的数据类型，仅当为实时播放时出现     |      Y      |               |              |                  |
| `codeStrm`       | int       | 码流代码                     |      Y      |               |              |                  |
| `proto`          | int       | 客户端协议代码                  |      Y      |               |              |                  |
| `connIdx`        | int       | 播放空格序号                   |      Y      |               |              |                  |
| `clientData`     | string    | 客户端数据                    |      Y      |               |              |                  |
| `callback`       | string    | 回调地址                     |      Y      |               |              |                  |
| `user`           | string    | 用户信息                     |      Y      |               |              |                  |
| `ctrl`           | boolean   | 是否有控制权                   |      Y      |               |              |                  |
| `playUrl`        | string    | 播放地址                     |             |               |      Y       |                  |
| `wsUrl`          | string    | 客户端音频回送websocket地址，文本格式  |             |               |      Y       |                  |
| `taUrl`          | string    | 客户端音频回送websocket地址，二进制格式 |             |               |      Y       |                  |
| `mediaTyp`       | string    | 媒体类型                     |             |               |      Y       |                  |
| `videoFormat`    | string    | 视频格式                     |             |               |      Y       |                  |
| `resolution`     | string    | 视频分辨率                    |             |               |      Y       |                  |
| `audioFormat`    | string    | 音频格式                     |             |               |      Y       |                  |
| `hisiHeader`     | boolean   | 音频数据是否带有海思头部             |             |               |      Y       |                  |
| `audioBitrate`   | int       | 音频位率                     |             |               |      Y       |                  |
| `defaultBitrate` | boolean   | 是否默认位率                   |             |               |      Y       |                  |
| `closeCause`     | int       | 关闭原因代码                   |             |               |             |        Y         |
| `closeReason`    | string    | 关闭原因文本                   |             |               |             |        Y         |
| `byteRate`        | long      | 平均字节率                    |             |               |             |        Y         |
