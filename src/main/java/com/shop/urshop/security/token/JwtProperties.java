package com.shop.urshop.security.token;

import java.time.Duration;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties("jwt")
public class JwtProperties {
  private String algorithm;
  private String secretKey;
  private String issuer;
  private Duration expiration;
}
