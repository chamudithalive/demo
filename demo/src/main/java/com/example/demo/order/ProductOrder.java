package com.example.demo.order;

import java.util.Date;
import java.util.List;

import com.example.demo.product.Product;
import com.example.demo.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductOrder {
    @Id
    private int orderId;
    private User user;
    private Date orderDate;
    private List<Product> products;
    private String status;
}
