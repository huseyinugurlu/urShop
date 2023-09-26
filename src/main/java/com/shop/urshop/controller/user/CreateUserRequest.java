package com.shop.urshop.controller.user;


import java.time.LocalDateTime;

public record CreateUserRequest(String userName, String email, String password,LocalDateTime creationDate) {
   
}
