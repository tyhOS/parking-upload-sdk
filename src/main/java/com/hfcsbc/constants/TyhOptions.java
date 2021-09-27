package com.hfcsbc.constants;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TyhOptions implements Options {

  @Builder.Default
  private String restHost = "https://www.tyhos.cn/open/api/";

  private String accessId;

  private String secretKey;

  @Override
  public String getAccessId() {
    return this.accessId;
  }

  @Override
  public String getSecretKey() {
    return this.secretKey;
  }

  @Override
  public String getRestHost() {
    return this.restHost;
  }

}
