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
public class ProductPriceResponseTest {

	@InjectMocks
	ProductPriceResponse productPriceResponse = new ProductPriceResponse(1, 1, 1, 1);
	
	@Test
	public void test() {
		assertEquals(1, productPriceResponse.getAmount());
		assertEquals(1, productPriceResponse.getCartons());
		assertEquals(1, productPriceResponse.getRequestedQty());
		assertEquals(1, productPriceResponse.getUnit());
	}
}
