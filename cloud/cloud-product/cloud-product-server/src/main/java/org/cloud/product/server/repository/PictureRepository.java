package org.cloud.product.server.repository;

import java.io.Serializable;
import java.util.List;

import org.cloud.product.server.model.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PictureRepository extends JpaRepository<Picture, Serializable>{
	
	public List<Picture> findByProId(long proId);
}
