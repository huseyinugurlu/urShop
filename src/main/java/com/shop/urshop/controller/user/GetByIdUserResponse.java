package com.shop.urshop.controller.user;

import com.shop.urshop.entity.User;

public record GetByIdUserResponse(int id, String userName, String email, String creationDate) {

  public static GetByIdUserResponse fromUser(User user) {
    return new GetByIdUserResponse(
        user.getId(), user.getName(), user.getEmail(), user.getCreationDate());
  }
}
