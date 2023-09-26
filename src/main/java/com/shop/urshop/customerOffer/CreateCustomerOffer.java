package com.shop.urshop.customerOffer;

import com.shop.urshop.entity.CustomerOffer;
import com.shop.urshop.entity.Product;
import com.shop.urshop.product.ProductRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

//@Component
public class CreateCustomerOffer {

    private final CustomerOfferRepository customerOfferRepository;
    private final ProductRepository productRepository;


    public CreateCustomerOffer(CustomerOfferRepository customerOfferRepository, ProductRepository productRepository) {
        this.customerOfferRepository = customerOfferRepository;
        this.productRepository = productRepository;
    }

    public Set<Product> getProducts(){
        List<Product> products = productRepository.findAll();

        int maxStock = products.stream()
                .mapToInt(Product::getStock)
                .max()
                .orElse(0);

    return products.stream()
        .filter(product -> product.getStock() == maxStock)
        .collect(Collectors.toSet());
    }
    public float getTotalAmount(){
        Set<Product> maxStockProducts = getProducts();

        float totalAmount = 0;
        for (Product product : maxStockProducts) {
            totalAmount += product.getPrice();
        }

        return totalAmount;
    }

    //@Scheduled(fixedRate = 30000)
    public void saveDailyName() {
        CustomerOffer customerOffer =CustomerOffer.builder()
                .totalAmount(200)
                .products(getProducts())
                .build();
        customerOfferRepository.save(customerOffer);
    }
}