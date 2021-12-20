# parking-upload-sdk
### Quick start

停宜慧开放平台数据对接开发包（JAVA版）是由合肥城市泊车技术团队维护的项目，引入该包后开发者可迅速实现停车数据上传、支付对接等功能。

#### 引入Maven

```
<dependency>
  <groupId>com.hfcsbc.sdk</groupId>
  <artifactId>upload-client</artifactId>
  <version>2.0.17</version>
</dependency>
```

#### 接口列表

1. **停车数据上传**

- 停车场余位上传（uploadSurplus）

- 停车场入场信息上报（uploadDriveIn）

- 停车场出场信息上报（uploadDriveOut）

- 车辆图片上传（uploadImage）

- 停车场心跳上传（uploadHeartbeat）

  （详细方法参数请点击前往[开放平台接口文档](https://ossweb.hfcsbc.com/openOS/doc/index.html#/develop_guide.html)）

2. **支付接口**

- 支付下单
- ...

#### 开发实例

我们提供的开发样例在src/test/java/com/hfcsbc/example目录。调用接口前，首先需要登陆停宜慧开放平台获取您的停车场编号（PARKING_CODE）和公司认证（ACCESS_ID、SECRET_KEY）。
```
public static final String PARKING_CODE = "OS2_10003_1632463801214";
public static final String ACCESS_ID  = "16327134271655855";
public static final String SECRET_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCkF3fmmuHSl5v...";
```

#### Client
Client是访问停宜慧开放平台 API的类。下表列出了所有Client。Client负责操作相关数据，您可以根据您的业务选择一个或多个Client。

| Client          | API用途            | API类型 |
| --------------- | ------------------ | ------- |
| TyhUploadClient | 停车场上传停车数据 | Restful |
| TyhPayClient    | 支付相关           | Restful |

**调用实例** 

```
// 创建上传数据client
TyhUploadClient uploadClient = TyhUploadClient.create(TyhOptions.builder()
    .accessId(ACCESS_ID)
    .secretKey(SECRET_KEY).build());

// 上传余位数据
UploadSurplusCmd openParkingSurplusCmd = UploadSurplusCmd.builder()
    .parkingCode(PARKING_CODE)
    .total(20)
    .surplus(10).build();

try {
    TyhResponse reponse = uploadClient.uploadSurplus(openParkingSurplusCmd);
    if (!reponse.ifSuccess()) {
          System.out.println("调用失败，错误码="+ reponse.getCode() + "，失败原因="+reponse.getMsg());
    }
} catch (Exception e) {
        e.printStackTrace();
        System.out.println("调用失败，失败原因="+e.getMessage());
}             
```



