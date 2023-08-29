package com.learn.Shop.db.mapper;

import com.learn.Shop.domain.BoughtProduct;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BoughtProductRowMapper implements RowMapper<BoughtProduct> {
    @Override
    public BoughtProduct mapRow(ResultSet rs, int rowNum) throws SQLException {
        BoughtProduct boughtProduct = new BoughtProduct();
        boughtProduct.setProductId(rs.getInt("product_id"));
        boughtProduct.setCustomerId(rs.getInt("customer_id"));
        boughtProduct.setQuantity(rs.getInt("quantity"));
        boughtProduct.setBoughtAt(rs.getTimestamp("boughtAt"));
        return boughtProduct;
    }

}
