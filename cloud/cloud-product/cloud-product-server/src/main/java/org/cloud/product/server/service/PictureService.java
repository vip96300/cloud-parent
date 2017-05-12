package org.cloud.product.server.service;

import java.util.List;

import org.cloud.product.server.model.Picture;

public interface PictureService {
	
	/**
	 * 根据产品编号获取图片列表
	 * @param proId
	 * @return
	 */
	public List<Picture> listByProid(long proid);
	
	/**
	 * 根据产品编号和图片类型获取图片集合
	 * @param proid
	 * @param type
	 * @return
	 */
	public List<Picture> listByProidType(long proid,int type);
	
	/**
	 * 根据图片编号获取图片
	 * @param picid
	 * @return
	 */
	public Picture getByPicid(long picid);
	
	/**
	 * 添加图片
	 * @param picture
	 */
	public void add(Picture picture);
	
	/**
	 * 修改图片
	 * @param picture
	 */
	public void updByPicid(Picture picture);
	/**
	 * 根据编号删除图片
	 * @param picid
	 */
	public void delByPicid(long picid);
	/**
	 * 根据产品编号集合获取图片列表
	 * @param proids
	 * @return
	 */
	public List<Picture> listByProids(List<Long> proids);
	/**
	 * 根据图片类型和产品编号集合获取图片列表
	 * @param proids
	 * @return
	 */
	public List<Picture> listByTypeProids(int type,List<Long> proids);
}
