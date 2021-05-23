package com.cjp.shopcart.shoppingcartservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjp.shopcart.shoppingcartservice.entities.Product;
import com.cjp.shopcart.shoppingcartservice.exception.InvalidProductIdException;
import com.cjp.shopcart.shoppingcartservice.repositories.ProductRepository;
import com.cjp.shopcart.shoppingcartservice.response.ProductPriceResponse;
import com.cjp.shopcart.shoppingcartservice.response.ProductResponse;
import com.cjp.shopcart.shoppingcartservice.util.Util;

@Service
public class ProductService {

	private final Logger logger;
	private final ProductRepository productRepository;
	private final ModelMapper modelMapper;
	
	@Autowired
	public ProductService(ProductRepository productRepository, ModelMapper modelMapper) {
		this.logger = LoggerFactory.getLogger(getClass());
		this.productRepository = productRepository;
		this.modelMapper = modelMapper;
	}
	
	public List<ProductResponse> getProductList() {
		logger.info(Util.GET_ALL_PRODUCTS_SERVICE);
		List<Product> productList = productRepository.findAll();
		return productList.stream().map(e -> modelMapper.map(e, ProductResponse.class)).collect(Collectors.toList());
	}
	
	public List<ProductPriceResponse> getPriceList(Long id) throws InvalidProductIdException {
		logger.info(Util.GET_PRICE_LIST_SERVICE);
		Optional<Product> productOpt = productRepository.findById(id);
		List<ProductPriceResponse> priceResponses = new ArrayList<>();
		if(!productOpt.isPresent()) {
			throw new InvalidProductIdException();
		}
		for (int i = 1; i <= 50; i++) {
			priceResponses.add(calculatePrice(i, productOpt.get()));
		}
		logger.info(Util.TWO_BRACKETS_VALUE, Util.GET_PRICE_LIST_SERVICE, Util.STATUS_SUCCESS);
		return priceResponses;
	}
	
	public ProductPriceResponse getProductPrice(Long id, int qty) throws InvalidProductIdException {
		logger.info(Util.CALCULATE_PRODUCT_PRICE_SERVICE);
		Optional<Product> productOpt = productRepository.findById(id);
		if(!productOpt.isPresent()) {
			throw new InvalidProductIdException();
		}
		return calculatePrice(qty, productOpt.get());
		
	}
	
	private ProductPriceResponse calculatePrice(int qty, Product product) {
		int cartons = qty / product.getCartonSize();
		int units = qty % product.getCartonSize();
		double unitPrice = (product.getCartonPrice() / product.getCartonSize());
		unitPrice *= units;
		unitPrice *=  (product.getCompensateRatio() + 100) / 100;
		double cartonPrice = product.getCartonPrice() * cartons;
		if(cartons >= product.getDiscountLevel()) {
			cartonPrice = (cartonPrice * (100 - product.getDiscount())) / 100;
		}
		return new ProductPriceResponse(qty, units, cartons, cartonPrice + unitPrice);
	}
}
