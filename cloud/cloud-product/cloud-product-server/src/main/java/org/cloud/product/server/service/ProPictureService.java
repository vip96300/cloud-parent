package org.cloud.product.server.service;

import java.util.List;

import org.cloud.product.server.model.ProPicture;

public interface ProPictureService {
	
	/**
	 * 根据产品编号获取图片列表
	 * @param proId
	 * @return
	 */
	public List<ProPicture> listByProid(long proid);
	
	/**
	 * 根据产品编号和图片类型获取图片集合
	 * @param proid
	 * @param type
	 * @return
	 */
	public List<ProPicture> listByProidType(long proid,int type);
	
	/**
	 * 根据图片编号获取图片
	 * @param picid
	 * @return
	 */
	public ProPicture getByPicid(long picid);
	
	/**
	 * 添加图片
	 * @param picture
	 */
	public void add(ProPicture picture);
	
	/**
	 * 修改图片
	 * @param picture
	 */
	public void updByPicid(ProPicture picture);
	/**
	 * 根据编号删除图片
	 * @param picid
	 */
	public void delByPicid(long picid);
}
