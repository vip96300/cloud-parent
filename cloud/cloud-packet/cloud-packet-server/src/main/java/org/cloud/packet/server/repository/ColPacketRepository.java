package org.cloud.packet.server.repository;

import java.util.List;

import org.cloud.packet.server.model.ColPacket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ColPacketRepository extends JpaRepository<ColPacket, Long> {
	
	@Query(value="select * from packet_collect_packet o where o.colid in (?1)",nativeQuery=true)
	public List<ColPacket> findByColids(List<Long> colids);
	/**
	 * 根据收藏编号和类目编号获取
	 * @param colid
	 * @param catid
	 * @return
	 */
	@Query(value="select * from packet_collect_packet o where o.colid=?1 and o.catid=?2",nativeQuery=true)
	public ColPacket findByColidAndCatid(long colid,long catid);
	
	/**
	 * 根据收藏编号删除
	 * @param colid
	 */
	@Transactional
	@Modifying
	@Query(value="delete from packet_collect_packet where colid=?1",nativeQuery=true)
	public void deleteByColid(long colid);
}
