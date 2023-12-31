package com.shop.urshop.user;

import com.shop.urshop.controller.auth.AuthRequest;
import com.shop.urshop.controller.auth.AuthResponse;
import com.shop.urshop.entity.User;
import java.util.List;

public interface UserService {
  List<User> getAll();

  User getById(int categoryId);

  void add(User user);

  void update(User user);

  void delete(int userId);

  void changePassword(String newPassword, String jwtToken);

  AuthResponse authenticate(AuthRequest authRequest);
}
