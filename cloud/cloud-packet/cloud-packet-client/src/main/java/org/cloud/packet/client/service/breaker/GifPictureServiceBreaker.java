package org.cloud.packet.client.service.breaker;

import org.cloud.packet.client.model.GifPicture;
import org.cloud.packet.client.service.GifPictureService;
import org.springframework.stereotype.Component;
@Component
public class GifPictureServiceBreaker implements GifPictureService{

	@Override
	public void add(GifPicture gifPicture) {
		throw new RuntimeException();
	}

	@Override
	public void delByPicid(long picid) {
		throw new RuntimeException();
	}

}
