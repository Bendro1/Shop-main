package com.learn.Shop.db.service.api;

import com.learn.Shop.domain.BoughtProduct;

import java.util.List;

public interface BoughtProductService {

     void add(BoughtProduct boughtProduct);

     List<BoughtProduct> getAllByCustomerId(int customerId);

}
