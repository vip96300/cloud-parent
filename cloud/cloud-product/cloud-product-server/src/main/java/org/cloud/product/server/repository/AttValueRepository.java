package org.cloud.product.server.repository;

import java.io.Serializable;
import java.util.List;

import org.cloud.product.server.model.AttValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttValueRepository extends JpaRepository<AttValue, Serializable>{
	
	public List<AttValue> findByCatid(long catid);

}
