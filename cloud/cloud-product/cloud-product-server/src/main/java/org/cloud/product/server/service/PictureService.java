package org.cloud.product.server.service;

import java.util.List;

import org.cloud.product.server.model.Picture;

public interface PictureService {
	
	/**
	 * 根据产品编号获取图片列表
	 * @param proId
	 * @return
	 */
	public List<Picture> listByProId(long proid);
}
