package com.shop.urshop.customerOffer;

import com.shop.urshop.entity.CustomerOffer;
import java.util.List;

public interface CustomerOfferService {
    List<CustomerOffer> getAll();

    CustomerOffer getById(int offerId);

    void delete(int offerId);
}
