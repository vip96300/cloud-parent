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
	public List<Picture> listByProid(long proid) {
		List<Picture> pictures=pictureRepository.findByProid(proid);
		return pictures;
	}

	@Override
	public List<Picture> listByProidType(long proid, int type) {
		List<Picture> pictures=pictureRepository.findByProidAndType(proid, type);
		return pictures;
	}

	@Override
	public Picture getByPicid(long picid) {
		Picture picture=pictureRepository.getOne(picid);
		return picture;
	}

	@Override
	public void add(Picture picture) {
		picture.setTime(System.currentTimeMillis());
		pictureRepository.save(picture);
	}

	@Override
	public void updByPicid(Picture picture) {
		pictureRepository.saveAndFlush(picture);
	}

	@Override
	public void delByPicid(long picid) {
		pictureRepository.delete(picid);
	}

	@Override
	public List<Picture> listByProids(List<Long> proids) {
		if(proids.isEmpty()){
			return null;
		}
		List<Picture> pictures=pictureRepository.findByProids(proids);
		return pictures;
	}

	@Override
	public List<Picture> listByTypeProids(int type, List<Long> proids) {
		if(proids.isEmpty()){
			return null;
		}
		List<Picture> pictures=pictureRepository.findByTypeAndProids(type, proids);
		return pictures;
	}

}
