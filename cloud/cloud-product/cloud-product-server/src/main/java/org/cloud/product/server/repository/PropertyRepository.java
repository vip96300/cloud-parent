package org.cloud.product.server.repository;

import java.io.Serializable;

import org.cloud.product.server.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property, Serializable>{

}
