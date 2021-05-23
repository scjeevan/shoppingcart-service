package com.cjp.shopcart.shoppingcartservice.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cjp.shopcart.shoppingcartservice.response.ProductPriceResponse;
import com.cjp.shopcart.shoppingcartservice.response.ProductResponse;
import com.cjp.shopcart.shoppingcartservice.service.ProductService;
import com.cjp.shopcart.shoppingcartservice.util.Util;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class ProductController {

	private final Logger logger;
	private final ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.logger = LoggerFactory.getLogger(getClass());
		this.productService = productService;
	}

	@GetMapping("/products")
	public Map<String, Object> getProductList() {
		logger.info(Util.GET_ALL_PRODUCTS_CONTROLLER);
		Map<String, Object> response = new HashMap<>();
		try {
			List<ProductResponse> productList = productService.getProductList();
			response.put(Util.STATUS_VALUE, Util.STATUS_SUCCESS);
			response.put(Util.MESSAGE_VALUE, Util.GET_ALL_PRODUCTS_SUCCESS);
			response.put(Util.DATA_VALUE, productList);
			logger.info(Util.TWO_BRACKETS_VALUE, Util.GET_ALL_PRODUCTS_CONTROLLER, Util.STATUS_SUCCESS);
		} catch (Exception ex) {
			logger.error(Util.TWO_BRACKETS_VALUE, Util.GET_ALL_PRODUCTS_CONTROLLER, ex.getMessage());
			response.put(Util.STATUS_VALUE, Util.STATUS_FAILED);
			response.put(Util.MESSAGE_VALUE, Util.GET_ALL_PRODUCTS_FAILED);
			return response;
		}
		logger.info(Util.TWO_BRACKETS_VALUE, Util.GET_ALL_PRODUCTS_CONTROLLER, response);
		return response;
	}
	
	@GetMapping("/product/prices/{id}")
	public Map<String, Object> calculatePrice(@PathVariable("id") Long id) {
		logger.info(Util.GET_PRICE_LIST_CONTROLLER);
		Map<String, Object> response = new HashMap<>();
		try {
			List<ProductPriceResponse> priceResponses = productService.getPriceList(id);
			response.put(Util.STATUS_VALUE, Util.STATUS_SUCCESS);
			response.put(Util.MESSAGE_VALUE, Util.GET_PRODUCT_PRICE_LIST_SUCCESS);
			response.put(Util.DATA_VALUE, priceResponses);
			logger.info(Util.TWO_BRACKETS_VALUE, Util.GET_PRICE_LIST_CONTROLLER, Util.STATUS_SUCCESS);
		} catch (Exception ex) {
			logger.error(Util.TWO_BRACKETS_VALUE, Util.GET_PRICE_LIST_CONTROLLER, ex.getMessage());
			response.put(Util.STATUS_VALUE, Util.STATUS_FAILED);
			response.put(Util.MESSAGE_VALUE, Util.GET_PRODUCT_PRICE_LIST_FAILED);
			return response;
		}
		logger.info(Util.TWO_BRACKETS_VALUE, Util.GET_PRICE_LIST_CONTROLLER, response);
		return response;
	}
	
	@GetMapping("/product/calculate/{id}")
	public Map<String, Object> getProductPrice(@PathVariable("id") Long id, @RequestParam(value = "qty") int qty) {
		logger.info(Util.CALCULATE_PRODUCT_PRICE_CONTROLLER);
		Map<String, Object> response = new HashMap<>();
		try {
			ProductPriceResponse priceResponse = productService.getProductPrice(id, qty);
			response.put(Util.STATUS_VALUE, Util.STATUS_SUCCESS);
			response.put(Util.MESSAGE_VALUE, Util.GET_PRODUCT_PRICE_DETAILS_SUCCESS);
			response.put(Util.DATA_VALUE, priceResponse);
			logger.info(Util.TWO_BRACKETS_VALUE, Util.CALCULATE_PRODUCT_PRICE_CONTROLLER, Util.STATUS_SUCCESS);
		} catch (Exception ex) {
			logger.error(Util.TWO_BRACKETS_VALUE, Util.CALCULATE_PRODUCT_PRICE_CONTROLLER, ex.getMessage());
			response.put(Util.STATUS_VALUE, Util.STATUS_FAILED);
			response.put(Util.MESSAGE_VALUE, Util.GET_PRODUCT_PRICE_DETAILS_FAILED);
			return response;
		}
		logger.info(Util.TWO_BRACKETS_VALUE, Util.CALCULATE_PRODUCT_PRICE_CONTROLLER, response);
		return response;
	}
}
