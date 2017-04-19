package org.cloud.product.server.repository;

import java.io.Serializable;

import org.cloud.product.server.model.AttValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttValueRepository extends JpaRepository<AttValue, Serializable>{

}
