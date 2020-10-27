package com.hn.springbootmobilestore.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Product")
@Data
@Accessors(chain = true)
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productID", nullable = false)
    private Integer productID;

    @Column(name = "productName")
    private String productName;

    @ManyToOne
    @JoinColumn(name = "categoryID")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private  Category category;

    @ManyToOne
    @JoinColumn(name = "statusID")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private StatusProduct statusProduct;

    @Column(name = "price")
    private Float price;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "manufacturerID")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Manufacturer manufacturer;

    @Column(name = "image")
    private String image;


}
