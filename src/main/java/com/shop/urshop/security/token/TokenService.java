package com.shop.urshop.security.token;

import com.shop.urshop.entity.User;
import com.shop.urshop.security.SecurityUser;

public interface TokenService {
  String createToken(SecurityUser securityUser);

  User getUser(Object source);
}
