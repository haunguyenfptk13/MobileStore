package com.hn.springbootmobilestore.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "Manufacturer")
@Data
@Accessors(chain = true)
public class Manufacturer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "manufacturer")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<Product> products;

    public Manufacturer(String name) {
        this.name = name;
    }

    public Manufacturer() {
    }
}
