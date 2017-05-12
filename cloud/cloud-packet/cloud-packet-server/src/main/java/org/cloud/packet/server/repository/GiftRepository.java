package org.cloud.packet.server.repository;

import java.util.List;

import org.cloud.packet.server.model.Gift;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GiftRepository extends JpaRepository<Gift, Long> {
	
	public List<Gift> findByIsdel(Pageable pageable ,int isdel);
	
	/**
	 * @param proids 优选包产品编号，不是产品编号
	 * @return
	 */
	@Query(value="select * from packet_gift o where o.gifid in (?1)",nativeQuery=true)
	public List<Gift> findByProids(List<Long> proids);
}
