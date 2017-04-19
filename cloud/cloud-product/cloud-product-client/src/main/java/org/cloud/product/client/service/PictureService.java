package org.cloud.product.client.service;

import java.util.List;

import org.cloud.product.client.model.Picture;
import org.cloud.product.client.service.breaker.AttributeServiceBreaker;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
@FeignClient(value="cloud-product-server")
public interface PictureService {
	
	/**
	 * 根据产品编号获取图片列表
	 * @param proId
	 * @return
	 */
	@RequestMapping(value = "/product/product/picture/list_proId",method=RequestMethod.GET)
	public List<Picture> listByProId(@RequestParam(value="proId")long proId);
}
