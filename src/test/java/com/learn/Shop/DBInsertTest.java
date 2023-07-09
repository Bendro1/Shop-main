package com.learn.Shop;



import com.learn.Shop.domain.Customer;
import com.learn.Shop.domain.Merchant;
import com.learn.Shop.domain.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;

@SpringBootTest
public class DBInsertTest {

    private final String insertCustomer = "INSERT INTO customer(name,surname,email,address,age,phone_number) values (?,?,?,?,?,?)";
    private final String insertMerchant = "INSERT INTO merchant(name,email,address) values(?,?,?)";
    private final String insertProduct ="INSERT INTO product(merchant_id,name,description,price,created_at,avaliable) values(?,?,?,?,?,?)";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void createProduct(){
        Product product = new Product();
        product.setMerchantId(1);
        product.setName("Klavesnica");
        product.setDescription("velmi dobra klavesnica");
        product.setPrice(15.85);
        product.setCreatedAt(Timestamp.from(Instant.now()));
        product.setAvailable(10);

        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(insertProduct);
                ps.setInt(1,product.getMerchantId());
                ps.setString(2,product.getName());
                ps.setString(3,product.getDescription());
                ps.setDouble(4,product.getPrice());
                ps.setTimestamp(5,product.getCreatedAt());
                ps.setInt(6,product.getAvailable());
                return ps;

            };
        });
    }

    @Test
    public void createCustomer(){
        Customer customer = new Customer();
        customer.setName("Jozef");
        customer.setSurname("Bednar");
        customer.setAddress("xxx");
        customer.setEmail("xxx");
        customer.setAge(26);
        customer.setPhoneNumber("xxx");

        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps=con.prepareStatement(insertCustomer);
                ps.setString(1,customer.getName());
                ps.setString(2,customer.getSurname());
                ps.setString(3,customer.getEmail());
                ps.setString(4,customer.getAddress());
                ps.setInt(5,customer.getAge());
                ps.setString(6,customer.getPhoneNumber());
                return ps;
            }
        });
    }
    @Test
    public void createMerchatnt(){
        Merchant merchant = new Merchant();
        merchant.setName("merchant");
        merchant.setEmail("email");
        merchant.setAddress("address");

        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(insertMerchant);
                ps.setString(1,merchant.getName());
                ps.setString(2,merchant.getEmail());
                ps.setString(3,merchant.getAddress());
                return ps;
            }
        });
    }
}
