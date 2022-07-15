package com.hfcsbc.constants;

import com.hfcsbc.utils.StringUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TyhOptions implements Options {

  public static final String DEFAULT_REST_HOST = "https://os.hfcsbc.com";
  public static final Long DEFAULT_TIME_OUT = 5000L;

  private String restHost;

  private String accessId;

  private String secretKey;

  private Boolean allowUpload;

  private Long timeout;

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
    return StringUtil.isEmpty(restHost) ? DEFAULT_REST_HOST : restHost;
  }

  @Override
  public Boolean getAllowUpload() {
    return this.allowUpload == null ? Boolean.TRUE : this.allowUpload;
  }

  @Override
  public Long getTimeout() {
    return this.timeout == null ? DEFAULT_TIME_OUT : this.timeout;
  }

}
