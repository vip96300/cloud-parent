package org.cloud.packet.server.repository;

import java.util.List;

import org.cloud.packet.server.model.PacCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PacCategoryRepository extends JpaRepository<PacCategory, Long> {

	List<PacCategory> findByPacid(long pacid);
	
	public PacCategory findByCategoryid(long categoryid);
	
	@Query(value="select * from packet_category o where o.categoryid in(?1)",nativeQuery=true)
	public List<PacCategory> findByCategoryids(List<Long> categoryids);
	
	@Query(value="select * from packet_category o where o.categoryid in(?1) and o.proid!=0",nativeQuery=true)
	public List<PacCategory> findByPacids(List<Long> pacids);
	
}
