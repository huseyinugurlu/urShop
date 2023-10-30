package com.shop.urshop.customerOffer;

import com.shop.urshop.entity.CustomerOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface CustomerOfferRepository extends JpaRepository<CustomerOffer, Integer> {
  @Transactional
  @Modifying
  @Query("UPDATE CustomerOffer  SET totalAmount = :totalAmount WHERE id=:id")
  void updateTotalAmountById(@Param("totalAmount") float totalAmount, @Param("id") int id);
}
