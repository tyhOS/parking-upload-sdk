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
  private String restHost = "https://jiguang.hfcsbc.com/open/api";

  private String accessId;

  private String secretKey;

  private Boolean allowUpload;

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

  @Override
  public Boolean getAllowUpload() {
    return this.allowUpload;
  }

}
