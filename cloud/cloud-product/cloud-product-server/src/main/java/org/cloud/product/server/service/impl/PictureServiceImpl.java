package org.cloud.product.server.service.impl;

import java.util.List;

import org.cloud.product.server.model.Picture;
import org.cloud.product.server.repository.PictureRepository;
import org.cloud.product.server.service.PictureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PictureServiceImpl implements PictureService{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private PictureRepository pictureRepository;
	
	@Override
	public List<Picture> listByProId(long proid) {
		logger.debug(this.getClass().getName());
		List<Picture> pictures=pictureRepository.findByProid(proid);
		return pictures;
	}

}
