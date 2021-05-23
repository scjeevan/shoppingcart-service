package com.cjp.shopcart.shoppingcartservice.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@ActiveProfiles(value = "test")
public class ProductTest {

	private String stringData="test";
	private int intData=1;
	private double doubleData=1;
	private long longData=1;
	
	@InjectMocks
	Product product = new Product();
	
	@Test
	public void test() {
		product.setCartonPrice(doubleData);
		product.setCartonSize(intData);
		product.setCompensateRatio(doubleData);
		product.setDiscount(doubleData);
		product.setDiscountLevel(intData);
		product.setProductId(longData);
		product.setProductName(stringData);
		assertEquals(doubleData, product.getCartonPrice());
		assertEquals(intData, product.getCartonSize());
		assertEquals(doubleData, product.getCompensateRatio());
		assertEquals(doubleData, product.getDiscount());
		assertEquals(intData, product.getDiscountLevel());
		assertEquals(longData, product.getProductId());
		assertEquals(stringData, product.getProductName());
	}
}
