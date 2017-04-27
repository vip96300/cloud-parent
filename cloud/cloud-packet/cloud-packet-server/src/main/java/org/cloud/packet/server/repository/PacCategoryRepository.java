package org.cloud.packet.server.repository;

import java.io.Serializable;
import java.util.List;

import org.cloud.packet.server.model.PacCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacCategoryRepository extends JpaRepository<PacCategory, Long> {

	List<PacCategory> findByPacid(long pacid);
	
}
