package org.cloud.packet.server.repository;

import org.cloud.packet.server.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	
}
