package com.shop.urshop.customerOffer;

import com.shop.urshop.entity.CustomerOffer;
import com.shop.urshop.exception.BusinessException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerOfferManager implements CustomerOfferService {
  private final CustomerOfferRepository customerOfferRepository;

  @Autowired
  public CustomerOfferManager(CustomerOfferRepository customerOfferRepository) {
    this.customerOfferRepository = customerOfferRepository;
  }

  @Override
  public List<CustomerOffer> getAll() {
    return customerOfferRepository.findAll();
  }

  @Override
  public CustomerOffer getById(int offerId) {
    return customerOfferRepository
        .findById(offerId)
        .orElseThrow(() -> new BusinessException("Customer Offer not found!"));
  }

  @Override
  public void delete(int offerId) {
    if (customerOfferRepository.existsById(offerId)) {
      this.customerOfferRepository.deleteById(offerId);
    } else {
      throw new RuntimeException("Customer Offer not found!");
    }
  }
}
