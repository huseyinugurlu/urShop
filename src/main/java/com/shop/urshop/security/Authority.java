package com.shop.urshop.security;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

@Getter
public enum Authority implements GrantedAuthority {
  ROLE_CUSTOMER,
  ROLE_CASHIER;

  @Override
  public String getAuthority() {
    return name();
  }
}
