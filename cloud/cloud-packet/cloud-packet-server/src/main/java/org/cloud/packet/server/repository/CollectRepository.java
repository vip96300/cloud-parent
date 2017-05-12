package org.cloud.packet.server.repository;

import java.util.List;

import org.cloud.packet.server.model.Collect;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollectRepository extends JpaRepository<Collect, Long> {
	
	public List<Collect> findByUserid(String userid,Pageable pageable);
}
