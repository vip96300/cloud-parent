package org.cloud.packet.server.service;

import java.util.List;

import org.cloud.packet.server.model.Gift;
import org.springframework.data.domain.Pageable;

public interface GiftService {

	public void add(Gift gift);

	public List<Gift> list(Pageable pageable);

	public void updByGifid(Gift gift);

	public Gift getByGifid(long gifid);

	public void delByGifid(long gifid);
}
