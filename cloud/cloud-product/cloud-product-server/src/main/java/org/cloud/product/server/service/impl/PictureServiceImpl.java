package org.cloud.product.server.service.impl;

import java.util.List;

import org.cloud.product.server.model.Picture;
import org.cloud.product.server.repository.PictureRepository;
import org.cloud.product.server.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PictureServiceImpl implements PictureService{
	
	@Autowired
	private PictureRepository pictureRepository;
	
	@Override
	public List<Picture> listByProId(long proId) {
		List<Picture> pictures=pictureRepository.findByProId(proId);
		return pictures;
	}

}
