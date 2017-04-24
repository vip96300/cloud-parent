package org.cloud.product.server.repository;

import java.io.Serializable;
import java.util.List;

import org.cloud.product.server.model.ProPicture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProPictureRepository extends JpaRepository<ProPicture, Serializable>{
	
	public List<ProPicture> findByProid(long proid);
	
	public List<ProPicture> findByProidAndType(long proid,int type);
}
