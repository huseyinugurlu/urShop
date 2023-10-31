package com.shop.urshop.controller.auth;

import com.shop.urshop.controller.ApiConstants;
import com.shop.urshop.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiConstants.BASE_URL + ApiConstants.AUTH)
public class AuthController {
  private final UserService userService;

  @Autowired
  public AuthController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping(ApiConstants.CHANGE_PASSWORD)
  public void changePassword(
      @RequestHeader("Authorization") String jwtToken,
      @RequestBody final ResetPswrdRequest resetPswrdRequest) {
    this.userService.changePassword(resetPswrdRequest.getNewPassword(), jwtToken);
  }

  @PostMapping(ApiConstants.LOGIN)
  public String authenticate(@RequestBody AuthRequest authRequest) {
    return userService.authenticate(authRequest);
  }
}
