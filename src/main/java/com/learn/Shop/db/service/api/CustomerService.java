package com.learn.Shop.db.service.api;

import com.learn.Shop.domain.Customer;
import org.springframework.lang.Nullable;

import java.util.List;

public interface CustomerService {

    List<Customer> getCustomer();

    @Nullable
    Customer get(int id);

    @Nullable
    Integer add(Customer customer);
}
