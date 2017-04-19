package org.cloud.product.server.repository;

import java.io.Serializable;

import org.cloud.product.server.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Serializable>{

}
