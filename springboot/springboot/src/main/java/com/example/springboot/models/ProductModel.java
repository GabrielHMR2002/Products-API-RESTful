package com.example.springboot.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "TB_PRODUCTS")
public class ProductModel implements Serializable {
private static final long serialVersionUID = 1L;

}
