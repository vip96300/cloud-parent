package org.cloud.packet.server.service;

import org.cloud.packet.server.model.GifPicture;

public interface GifPictureService {

	public void add(GifPicture gifPicture);
	

	public void delByPicid(long picid);
}
