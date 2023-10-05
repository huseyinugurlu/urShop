package com.shop.urshop.controller.user;


import com.shop.urshop.entity.User;

import java.time.LocalDate;

public record GetByIdUserResponse(String userName,String email,String creationDate) {

    public static GetByIdUserResponse fromUser(User user){
        return new GetByIdUserResponse(user.getUserName(),user.getEmail(), user.getCreationDate());
    }
}
