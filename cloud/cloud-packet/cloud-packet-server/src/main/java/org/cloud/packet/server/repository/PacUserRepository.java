package org.cloud.packet.server.repository;

import java.io.Serializable;
import java.util.List;

import org.cloud.packet.server.model.PacUser;
import org.cloud.packet.server.model.Packet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacUserRepository extends JpaRepository<PacUser, Long> {
	
	List<Packet> findByUserid(String userid);
}
