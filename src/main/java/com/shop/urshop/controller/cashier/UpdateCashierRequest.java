package com.shop.urshop.controller.cashier;

import java.time.LocalDateTime;

public record UpdateCashierRequest(
    String userName, String email, LocalDateTime creationDate, long cashierNumber) {}
