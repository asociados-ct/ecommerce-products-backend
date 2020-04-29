package com.asociadosct.ecommerceproducts.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "name", length = 30)
    private String name;

    @Column(name = "description", length = 50)
    private String description;

    @Column(name = "weigth")
    private int weigth;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "photo1")
    private byte[] photo1;

    @Column(name = "photo2")
    private byte[] photo2;

    @Column(name = "photo3")
    private byte[] photo3;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
}