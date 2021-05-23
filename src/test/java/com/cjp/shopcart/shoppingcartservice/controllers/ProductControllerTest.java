package com.cjp.shopcart.shoppingcartservice.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.cjp.shopcart.shoppingcartservice.exception.InvalidProductIdException;
import com.cjp.shopcart.shoppingcartservice.response.ProductPriceResponse;
import com.cjp.shopcart.shoppingcartservice.response.ProductResponse;
import com.cjp.shopcart.shoppingcartservice.service.ProductService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@ActiveProfiles(value = "test")
public class ProductControllerTest {

	@InjectMocks
	ProductController productController;
	
	@Mock
	ProductService productService;
	
	@Before
	public void init() throws InvalidProductIdException {
		List<ProductResponse> productList = new ArrayList<>();
		List<ProductPriceResponse> priceResponses = new ArrayList<>();
		when(productService.getProductList()).thenReturn(productList);
		when(productService.getPriceList(Mockito.anyLong())).thenReturn(priceResponses);
	}
	
	@Test
	public void getProductListSuccess() {
		assertEquals("SUCCESS", productController.getProductList().get("STATUS"));
	}
	
	@Test
	public void getProductListFail() {
		doThrow(RuntimeException.class).when(productService).getProductList();
		assertEquals("FAILED", productController.getProductList().get("STATUS"));
	}
	
	@Test
	public void calculatePriceSuccess() {
		assertEquals("SUCCESS", productController.calculatePrice(Mockito.anyLong()).get("STATUS"));
	}
	
	@Test
	public void calculatePriceFail() throws InvalidProductIdException {
		doThrow(InvalidProductIdException.class).when(productService).getPriceList(Mockito.anyLong());
		assertEquals("FAILED", productController.calculatePrice(Mockito.anyLong()).get("STATUS"));
	}
	
	@Test
	public void getProductPriceSuccess() {
		assertEquals("SUCCESS", productController.getProductPrice(Mockito.anyLong(), Mockito.anyInt()).get("STATUS"));
	}
	
	@Test
	public void getProductPriceFail() throws InvalidProductIdException {
		doThrow(RuntimeException.class).when(productService).getProductPrice(Mockito.anyLong(), Mockito.anyInt());
		assertEquals("FAILED", productController.getProductPrice(Mockito.anyLong(), Mockito.anyInt()).get("STATUS"));
	}
}
