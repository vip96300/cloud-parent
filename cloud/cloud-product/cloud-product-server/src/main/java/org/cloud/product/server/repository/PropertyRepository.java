package org.cloud.product.server.repository;

import java.util.List;

import org.cloud.product.server.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface PropertyRepository extends JpaRepository<Property, Long>{
	
	@Transactional
	@Modifying
	@Query(value="delete from product_product_property where attid in(select attid from product_category_attribute where groid=?1)",nativeQuery=true)
	void deleteByGroid(long groid);
	
	@Transactional
	@Modifying
	void deleteByAttid(long attid);
	
	List<Property> findByProductid(long productid);
}
