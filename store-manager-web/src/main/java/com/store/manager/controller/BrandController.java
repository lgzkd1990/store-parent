package com.store.manager.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;


@RestController
@RequestMapping("/brand")
public class BrandController {
	
	//注入远程服务对象
	@Reference(timeout=10000000)
	private BrandService brandService;
	
	/**
	 * 需求:查询所有品牌数据
	 */
	@RequestMapping("/findAll")
	public List<TbBrand> findAll(){
		//调用远程服务对象方法
		List<TbBrand> list = brandService.findAll();
		
		return list;
	}

}
