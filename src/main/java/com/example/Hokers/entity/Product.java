package com.example.Hokers.entity;
import jakarta.persistence.*;
import lombok.Data;
public class Product {
    @Data
    @Entity
    @Table(name = "tbl_product")
    public class product {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long productId;
        private String productName;
        private String typeproduct;
        private Long price;
    }
}
