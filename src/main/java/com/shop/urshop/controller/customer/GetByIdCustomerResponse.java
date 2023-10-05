package com.shop.urshop.controller.customer;

import com.shop.urshop.entity.Customer;
import com.shop.urshop.entity.Order;
import com.shop.urshop.entity.PaymentCard;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

public record GetByIdCustomerResponse(
        String userName,
        String email,
        String creationDate,
        int customerNumber,
        Set<Order> order,
        Set<PaymentCard> paymentCard) {

    public static GetByIdCustomerResponse fromCustomer(Customer customer){
        return new GetByIdCustomerResponse(customer.getUserName(), customer.getEmail(), customer.getCreationDate(),customer.getCustomerNumber(),customer.getOrder(),customer.getPaymentCard());
    }
}
