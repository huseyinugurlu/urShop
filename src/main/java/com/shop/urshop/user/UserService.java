package com.shop.urshop.user;

import com.shop.urshop.controller.user.AuthRequest;
import com.shop.urshop.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    User getById(int categoryId);

    void add(User user);

    void update(User user);

    void delete(int userId);
    void changePassword(String newPassword,String jwtToken);

    String authenticate(AuthRequest authRequest);
}
