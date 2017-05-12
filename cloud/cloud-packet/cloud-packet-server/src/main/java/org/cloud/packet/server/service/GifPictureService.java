package org.cloud.packet.server.service;

import java.util.List;

import org.cloud.packet.server.model.GifPicture;

public interface GifPictureService {

	public void add(GifPicture gifPicture);
	
	public List<GifPicture> listByGifid(long gifid);

	public void delByPicid(long picid);
}
