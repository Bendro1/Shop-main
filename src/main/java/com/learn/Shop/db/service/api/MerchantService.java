package com.learn.Shop.db.service.api;

import com.learn.Shop.domain.Merchant;
import org.springframework.lang.Nullable;

import java.util.List;

public interface MerchantService {

    List<Merchant> getMerchants();

    @Nullable
    Merchant get(int it);
    @Nullable
    Integer add(Merchant merchant);
}