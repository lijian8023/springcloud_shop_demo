package com.anyan.product.controller;

import com.anyan.product.entity.Product;
import com.anyan.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@Value("${server.port}")
	private String port;

	@Value("${spring.cloud.client.ip-address}") //spring cloud 自动的获取当前应用的ip地址
	private String ip;

	@RequestMapping(value = "/findById/{id}",method = RequestMethod.GET)
	public Product findById(@PathVariable("id") Long id) {
		Product product = productService.findById(id);
		product.setProductName("访问的服务地址:"+ip + ":" + port);
		return product;
	}

	@RequestMapping(value = "save",method = RequestMethod.POST)
	public String save(@RequestBody Product product) {
		productService.save(product);
		return "保存成功";
	}
}
