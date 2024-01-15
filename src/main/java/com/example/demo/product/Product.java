package com.example.demo.product;

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
public class Product {
    @Id
    private int productId;
    private String name;
    private User user;
    private double price;
    private String description;
}
