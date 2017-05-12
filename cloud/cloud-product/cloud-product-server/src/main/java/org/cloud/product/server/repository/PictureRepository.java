package org.cloud.product.server.repository;

import java.util.List;

import org.cloud.product.server.model.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PictureRepository extends JpaRepository<Picture, Long>{
	
	public List<Picture> findByProid(long proid);
	
	public List<Picture> findByProidAndType(long proid,int type);
	
	@Query(value="select * from product_product_picture o where o.proid in(?1)",nativeQuery=true)
	public List<Picture> findByProids(List<Long> proids);
	
	@Query(value="select * from product_product_picture o where o.type=?1 and o.proid in(?2)",nativeQuery=true)
	public List<Picture> findByTypeAndProids(int type,List<Long> proids);
}
