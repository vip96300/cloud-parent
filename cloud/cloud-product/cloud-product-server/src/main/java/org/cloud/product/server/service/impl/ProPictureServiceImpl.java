package org.cloud.product.server.service.impl;

import java.util.List;

import org.cloud.product.server.model.ProPicture;
import org.cloud.product.server.repository.ProPictureRepository;
import org.cloud.product.server.service.ProPictureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ProPictureServiceImpl implements ProPictureService{
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ProPictureRepository pictureRepository;
	
	@Override
	public List<ProPicture> listByProid(long proid) {
		logger.debug(this.getClass().getName());
		List<ProPicture> pictures=pictureRepository.findByProid(proid);
		return pictures;
	}

	@Override
	public List<ProPicture> listByProidType(long proid, int type) {
		List<ProPicture> pictures=pictureRepository.findByProidAndType(proid, type);
		return pictures;
	}

	@Override
	public ProPicture getByPicid(long picid) {
		ProPicture picture=pictureRepository.getOne(picid);
		return picture;
	}

	@Override
	public void add(ProPicture picture) {
		pictureRepository.save(picture);
	}

	@Override
	public void updByPicid(ProPicture picture) {
		pictureRepository.saveAndFlush(picture);
	}

	@Override
	public void delByPicid(long picid) {
		pictureRepository.delete(picid);
	}

}
