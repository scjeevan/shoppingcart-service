package com.cjp.shopcart.shoppingcartservice.response;

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
public class ProductResponseTest {

	private String stringData="test";
	private long longData=1;
	
	@InjectMocks
	ProductResponse productResponse;
	
	@Test
	public void test() {
		productResponse.setProductId(longData);
		productResponse.setProductName(stringData);
		assertEquals(longData, productResponse.getProductId());
		assertEquals(stringData, productResponse.getProductName());
	}
}
