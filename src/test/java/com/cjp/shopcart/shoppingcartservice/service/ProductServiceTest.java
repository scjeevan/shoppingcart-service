package com.cjp.shopcart.shoppingcartservice.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.cjp.shopcart.shoppingcartservice.entities.Product;
import com.cjp.shopcart.shoppingcartservice.exception.InvalidProductIdException;
import com.cjp.shopcart.shoppingcartservice.repositories.ProductRepository;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@ActiveProfiles(value = "test")
public class ProductServiceTest {

	@InjectMocks
	ProductService productService;
	
	@Mock
	ProductRepository productRepository;
	
	@Mock
	ModelMapper modelMapper;
	
	
	@Test
	public void getProductListTest() {
		List<Product> productList = new ArrayList<Product>();
		when(productRepository.findAll()).thenReturn(productList);
		assertNotNull(productService.getProductList());
	}
	
	@Test
	public void getPriceListTestSuccess() throws InvalidProductIdException {
		Product product = new Product();
		product.setCartonPrice(175.0);
		product.setCartonSize(1);
		product.setCompensateRatio(1.0);
		product.setDiscount(1.0);
		product.setDiscountLevel(1);
		product.setProductId(1L);
		product.setProductName("test");
		Optional<Product> productOpt = Optional.of(product);
		when(productRepository.findById(Mockito.anyLong())).thenReturn(productOpt);
		assertNotNull(productService.getPriceList(Mockito.anyLong()));
	}
	
	@Test
	public void getPriceListTestFail() throws InvalidProductIdException {
		Optional<Product> productOpt = Optional.empty();
		when(productRepository.findById(Mockito.anyLong())).thenReturn(productOpt);
		assertThrows(InvalidProductIdException.class, () -> productService.getPriceList(Mockito.anyLong()));
	}
}
