package org.cloud.packet.server.service.breaker;

import java.util.List;

import org.cloud.packet.server.model.PictureDTO;
import org.cloud.packet.server.service.PictureService;
import org.springframework.stereotype.Component;

@Component
public class PictureServiceBreaker implements PictureService{

	@Override
	public List<PictureDTO> listByProid(long proid) {
		throw new RuntimeException();
	}

	@Override
	public List<PictureDTO> listByProidType(long proid, int type) {
		throw new RuntimeException();
	}

	@Override
	public List<PictureDTO> listByProids(List<Long> proids) {
		throw new RuntimeException();
	}

	@Override
	public List<PictureDTO> listByTypeProids(int type, List<Long> proids) {
		throw new RuntimeException();
	}



}
