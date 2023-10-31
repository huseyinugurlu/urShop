package com.shop.urshop.controller.cashier;

import java.time.LocalDateTime;

public record CreateCashierRequest(
    String userName,
    String email,
    String password,
    long cashierNumber) {}
