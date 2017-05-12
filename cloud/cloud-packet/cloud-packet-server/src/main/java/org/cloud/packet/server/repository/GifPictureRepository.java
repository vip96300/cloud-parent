package org.cloud.packet.server.repository;

import java.util.List;

import org.cloud.packet.server.model.GifPicture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GifPictureRepository extends JpaRepository<GifPicture, Long> {
	
	public List<GifPicture> findByGifid(long gifid);
	
	@Query(value="select * from packet_gift_picture o where o.gifid in(?1)",nativeQuery=true)
	public List<GifPicture> findByGifids(List<Long> gifids);
	
	@Query(value="select * from packet_gift_picture o where o.type=?1 and o.gifid in(?2)",nativeQuery=true)
	public List<GifPicture> findByTypeAndGifids(int type,List<Long> gifids);
}
