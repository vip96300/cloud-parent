package org.cloud.product.server.repository;

import java.util.List;

import org.cloud.product.server.model.ProPicture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProPictureRepository extends JpaRepository<ProPicture, Long>{
	
	public List<ProPicture> findByProid(long proid);
	
	public List<ProPicture> findByProidAndType(long proid,int type);
}
