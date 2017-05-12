package org.cloud.packet.server.repository;

import java.util.List;

import org.cloud.packet.server.model.PacPicture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PacPictureRepository extends JpaRepository<PacPicture, Long> {
	
	@Query(value="select * from packet_packet_picture o where o.type=?1 and o.pacid in(?2)",nativeQuery=true)
	public List<PacPicture> findByTypeAndPacids(int type,List<Long> pacids);
}
