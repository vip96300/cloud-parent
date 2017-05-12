package org.cloud.packet.server.repository;

import java.util.List;

import org.cloud.packet.server.model.Packet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacketRepository extends JpaRepository<Packet, Long> {
	
	public Page<Packet> findByIsdel(int isdel,Pageable pageable);
	/**
	 * 获取封面那个
	 * @param ispk
	 * @return
	 */
	public List<Packet> findByIspk(int ispk);

}
