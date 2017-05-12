package org.cloud.packet.client.controller;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.cloud.common.util.ValidUtil;
import org.cloud.packet.client.controller.dto.Result;
import org.cloud.packet.client.model.Gift;
import org.cloud.packet.client.model.PacProduct;
import org.cloud.packet.client.model.Picture;
import org.cloud.packet.client.model.Product;
import org.cloud.packet.client.service.GiftService;
import org.cloud.packet.client.service.PacProductService;
import org.cloud.packet.client.service.PictureService;
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
	@Autowired
	private PictureService pictureService;
	
	@ApiOperation(value="将产品加入到优选包产品选项")
	@ApiImplicitParams({@ApiImplicitParam(name="productid",value="产品编号",required=true,dataType="long"),
		@ApiImplicitParam(name="gifid",value="礼物编号",required=false,dataType="long")})
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Result<Object> add(@RequestParam(value="productid",required=true)long productid,@RequestParam(value="gifid",required=false)Long gifid){
		Product product=productService.getByProid(productid);
		if(!ValidUtil.isValid(product)){
			return null;
		}
		if(ValidUtil.isValid(gifid)){
			Gift gift=giftService.getByGifid(gifid);
			if(!ValidUtil.isValid(gift)){
				return null;
			}
		}
		PacProduct pacProduct=new PacProduct();
		pacProduct.setProductid(productid);
		pacProduct.setGifid(gifid);
		pacProduct.setCatid(product.getCatid());
		pacProductService.add(pacProduct);
		return new Result<Object>(200,null,null);
	}
	
	@ApiOperation(value="获取优选包的产品列表")
	@ApiImplicitParams({@ApiImplicitParam(name="page",value="当前页",required=true,dataType="int"),
		@ApiImplicitParam(name="size",value="每页数",required=true,dataType="int")})
	@RequestMapping(value="/products",method=RequestMethod.POST)
	public Result<List<Product>> products(@RequestParam(value="page",required=true)int page,
			@RequestParam(value="size",required=true)int size){
		List<PacProduct> pacProducts=pacProductService.list(page, size);
		List<Long> proids=new ArrayList<Long>();
		for(PacProduct pacProduct:pacProducts){
			proids.add(pacProduct.getProductid());
		}
		if(proids.isEmpty()){
			return new Result<List<Product>>(200,null,null);
		}
		List<Product> products=productService.listByProids(proids);
		return new Result<List<Product>>(200,null,products);
	}
	
	@ApiOperation(value="根据类目编号获取优选包的产品列表")
	@ApiImplicitParams({@ApiImplicitParam(name="categoryid",value="类目编号",required=true,dataType="long"),
		@ApiImplicitParam(name="page",value="当前页",required=true,dataType="int"),
		@ApiImplicitParam(name="size",value="每页数",required=true,dataType="int")})
	@RequestMapping(value="/products_categoryid",method=RequestMethod.POST)
	public Result<List<Product>> products_categoryid(@RequestParam(value="categoryid",required=true)long categoryid,
			@RequestParam(value="page",required=true)int page,
			@RequestParam(value="size",required=true)int size){
		List<PacProduct> pacProducts=pacProductService.listByCatid(categoryid,page, size);
		if(pacProducts.isEmpty()){
			return new Result<List<Product>>(200,null,null);
		}
		List<Long> proids=new ArrayList<Long>();
		for(PacProduct pacProduct:pacProducts){
			proids.add(pacProduct.getProductid());
		}
		List<Picture> pictures=pictureService.listByTypeProids(1,proids);
		List<Product> products=productService.listByProids(proids);
		for(Product product:products){
			for(Picture picture:pictures){
				if(product.getProid()==picture.getProid()){
					product.getPictures().add(picture);
				}
			}
		}
		return new Result<List<Product>>(200,null,products);
	}
	
	@ApiOperation(value="根据产品编号删除产品，这里的删除是指将该产品撤离优选包")
	@ApiImplicitParams({@ApiImplicitParam(name="productid",value="产品编号",required=true,dataType="long")})
	@RequestMapping(value="/del_productid",method=RequestMethod.POST)
	public Result<Object> del_productid(@RequestParam(value="productid",required=true)long productid){
		pacProductService.delByProductid(productid);
		return new Result<Object>(200,null,null);
	}
}
