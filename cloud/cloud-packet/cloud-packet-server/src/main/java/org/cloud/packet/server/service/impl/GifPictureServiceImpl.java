package org.cloud.packet.server.service.impl;

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
		gifPictureRepository.save(gifPicture);
	}

	@Override
	public void delByPicid(long picid) {
		gifPictureRepository.delete(picid);
	}

}
