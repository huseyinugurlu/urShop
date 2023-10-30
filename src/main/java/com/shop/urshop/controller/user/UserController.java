package com.shop.urshop.controller.user;

import com.shop.urshop.controller.ApiConstants;
import com.shop.urshop.user.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiConstants.BASE_URL + ApiConstants.USER)
public class UserController {
  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping(ApiConstants.GET_ALL)
  public List<GetAllUserResponse> getAll() {
    return GetAllUserResponse.fromUsers(userService.getAll());
  }

  @GetMapping(ApiConstants.BY_ID)
  public GetByIdUserResponse getByIdUserResponse(@PathVariable int id) {
    return GetByIdUserResponse.fromUser(userService.getById(id));
  }
}
