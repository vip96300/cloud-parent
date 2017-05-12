package org.cloud.packet.server.service;

import java.util.List;

import org.cloud.packet.server.model.PictureDTO;
import org.cloud.packet.server.service.breaker.PictureServiceBreaker;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="cloud-product-server",fallback=PictureServiceBreaker.class)
public interface PictureService {
	
	/**
	 * 根据产品编号获取图片列表
	 * @param proId
	 * @return
	 */
	@RequestMapping(value = "/product/product/picture/list_proid",method=RequestMethod.GET)
	public List<PictureDTO> listByProid(@RequestParam(value="proid",required=true)long proid);
	
	/**
	 * 根据产品编号和类型获取图片列表
	 * @param proid
	 * @param type
	 * @return
	 */
	@RequestMapping(value="/product/product/picture/list_proid_type",method=RequestMethod.GET)
	public List<PictureDTO> listByProidType(@RequestParam(value="proid",required=true)long proid,@RequestParam(value="type",required=true)int type);
	/**
	 * 根据产品编号集合获取图片列表
	 * @param proids
	 * @return
	 */
	@RequestMapping(value="/product/product/picture/list_proids",method=RequestMethod.GET)
	public List<PictureDTO> listByProids(@RequestParam(value="proids",required=true)List<Long> proids);
	/**
	 * 根据图片类型和产品编号集合获取图片列表
	 * @param proids
	 * @return
	 */
	@RequestMapping(value="/product/product/picture/list_type_proids",method=RequestMethod.GET)
	public List<PictureDTO> listByTypeProids(@RequestParam(value="type",required=true)int type,@RequestParam(value="proids",required=true)List<Long> proids);

}
