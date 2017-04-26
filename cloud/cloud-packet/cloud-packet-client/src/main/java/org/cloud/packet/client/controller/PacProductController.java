package org.cloud.packet.client.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.cloud.common.util.ValidUtil;
import org.cloud.packet.client.model.Gift;
import org.cloud.packet.client.model.PacProduct;
import org.cloud.packet.client.model.Product;
import org.cloud.packet.client.service.GiftService;
import org.cloud.packet.client.service.PacProductService;
import org.cloud.packet.client.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@RestController
@RequestMapping(value="/packet/category/product")
public class PacProductController {
	
	@Autowired
	private PacProductService pacProductService;
	@Autowired
	private ProductService productService;
	@Autowired
	private GiftService giftService;
	
	@ApiOperation(value="将产品加入到优选包产品选项")
	@ApiImplicitParams({@ApiImplicitParam(name="proid",value="产品编号",required=true,dataType="long"),
		@ApiImplicitParam(name="gifid",value="礼物编号",required=true,dataType="long")})
	@RequestMapping(value="add",method=RequestMethod.GET)
	public void add(@RequestParam(value="proid",required=true)long proid,@RequestParam(value="gifid",required=true)long gifid){
		Product product=productService.getByProid(proid);
		if(!ValidUtil.isValid(product)){
			return;
		}
		Gift gift=giftService.getByGifid(gifid);
		if(!ValidUtil.isValid(gift)){
			return;
		}
		PacProduct pacProduct=new PacProduct();
		pacProduct.setProductid(proid);
		pacProduct.setGifid(gifid);
		pacProductService.add(pacProduct);
	}
	
	@ApiOperation(value="根据产品编号删除产品，这里的删除是指将该产品撤离优选包")
	@RequestMapping(value="/del_productid",method=RequestMethod.GET)
	public void del_productid(@RequestParam(value="productid",required=true)long productid){
		pacProductService.delByProductid(productid);
	}
}
