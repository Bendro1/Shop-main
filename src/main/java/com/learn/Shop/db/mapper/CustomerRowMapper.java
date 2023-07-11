package com.learn.Shop.db.mapper;

import com.learn.Shop.domain.Customer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class CustomerRowMapper implements RowMapper<Customer> {

    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Customer customer = new Customer();
        customer.setId(rs.getInt("id"));
        customer.setName(rs.getString("name"));
        customer.setSurname(rs.getString("surname"));
        customer.setSurname(rs.getString("email"));
        customer.setSurname(rs.getString("address"));
        customer.setAge(rs.getObject("age")== null ? null :rs.getInt("age"));
        customer.setPhoneNumber(rs.getString("phone_number"));

        return customer;
        
    }
}

