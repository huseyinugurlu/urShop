package com.shop.urshop.customerOffer;

import com.shop.urshop.entity.CustomerOffer;
import com.shop.urshop.entity.Product;
import com.shop.urshop.entity.ProductCustomerOfferMap;
import com.shop.urshop.product.ProductRepository;
import com.shop.urshop.productCustomerOfferMap.ProductCustomerOfferMapRepository;
import java.util.*;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CreateCustomerOffer {

  @Value("${myapp.discount}")
  float discount;

  private final CustomerOfferRepository customerOfferRepository;
  private final ProductRepository productRepository;
  private final ProductCustomerOfferMapRepository productCustomerOfferMapRepository;

  public CreateCustomerOffer(
      CustomerOfferRepository customerOfferRepository,
      ProductRepository productRepository,
      ProductCustomerOfferMapRepository productCustomerOfferMapRepository) {
    this.customerOfferRepository = customerOfferRepository;
    this.productRepository = productRepository;
    this.productCustomerOfferMapRepository = productCustomerOfferMapRepository;
  }

  public Set<Product> getProducts() {
    List<Product> products = productRepository.findAll();
    return products.stream().filter(product -> product.getStock() < 3).collect(Collectors.toSet());
  }

  public float getTotalAmount(Set<Product> products) {
    float totalAmount = 0;
    for (Product product : products) {
      totalAmount += product.getPrice();
    }
    totalAmount = totalAmount - (totalAmount * discount);
    return totalAmount;
  }

  public CustomerOffer createCustomerOffer(Set<Product> products) {
    CustomerOffer customerOffer =
        CustomerOffer.builder().totalAmount(getTotalAmount(products)).build();
    customerOfferRepository.save(customerOffer);
    return customerOffer;
  }

  @Scheduled(cron = "0 0 * * * ?")
  public void createOfferMap() {
    System.out.println("çalıştı");
    final Set<Product> products = getProducts();
    final CustomerOffer customerOffer = createCustomerOffer(products);
    for (Product product : products) {
      final ProductCustomerOfferMap map = productCustomerOfferMapRepository.findByProduct(product);
      if (Objects.nonNull(map)) {
        final float totalAmount = getTotalAmount(products);
        if (totalAmount != map.getCustomerOffer().getTotalAmount()) {
          customerOfferRepository.updateTotalAmountById(
              totalAmount, map.getCustomerOffer().getId());
          System.out.println("güncellendi");
        }
      } else {
        ProductCustomerOfferMap productCustomerOfferMap =
            ProductCustomerOfferMap.builder().customerOffer(customerOffer).product(product).build();
        productCustomerOfferMapRepository.save(productCustomerOfferMap);
        System.out.println("eklendi");
      }
    }
  }
}
