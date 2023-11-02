package com.shop.urshop.controller.cashier;


public record CreateCashierRequest(
    String userName, String email, String password, long cashierNumber) {}
