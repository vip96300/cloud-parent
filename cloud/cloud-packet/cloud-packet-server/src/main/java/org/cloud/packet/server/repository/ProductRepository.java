package org.cloud.packet.server.repository;

import java.io.Serializable;

import org.cloud.packet.server.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
}
