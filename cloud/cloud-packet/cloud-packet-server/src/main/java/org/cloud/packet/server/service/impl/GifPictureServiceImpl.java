package org.cloud.packet.server.service.impl;

import java.util.List;

import org.cloud.packet.server.model.GifPicture;
import org.cloud.packet.server.repository.GifPictureRepository;
import org.cloud.packet.server.service.GifPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class GifPictureServiceImpl implements GifPictureService{

	@Autowired
	private GifPictureRepository gifPictureRepository;
	
	@Override
	public void add(GifPicture gifPicture) {
		gifPicture.setTime(System.currentTimeMillis());
		gifPictureRepository.save(gifPicture);
	}

	@Override
	public void delByPicid(long picid) {
		gifPictureRepository.delete(picid);
	}

	@Override
	public List<GifPicture> listByGifid(long gifid) {
		List<GifPicture> gifPictures=gifPictureRepository.findByGifid(gifid);
		return gifPictures;
	}

}
