package com.shop.urshop.controller.user;

import com.shop.urshop.entity.User;
import java.util.List;

public record GetAllUserResponse(int id, String userName, String email, String creationDate) {

  public static List<GetAllUserResponse> fromUsers(List<User> users) {
    return users.stream().map(GetAllUserResponse::fromUser).toList();
  }

  public static GetAllUserResponse fromUser(User user) {
    return new GetAllUserResponse(
        user.getId(), user.getName(), user.getEmail(), user.getCreationDate());
  }
}
