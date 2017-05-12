package org.cloud.packet.client.service.breaker;

import java.util.List;

import org.cloud.packet.client.model.Picture;
import org.cloud.packet.client.service.PictureService;
import org.springframework.stereotype.Component;
@Component
public class PictureServiceBreaker implements PictureService{

	@Override
	public List<Picture> listByProid(long proid) {
		throw new RuntimeException();
	}

	@Override
	public List<Picture> listByProidType(long proid, int type) {
		throw new RuntimeException();
	}

	@Override
	public List<Picture> listByProids(List<Long> proids) {
		throw new RuntimeException();
	}

	@Override
	public List<Picture> listByTypeProids(int type, List<Long> proids) {
		throw new RuntimeException();
	}



}
