package com.cjp.shopcart.shoppingcartservice.exception;

import com.cjp.shopcart.shoppingcartservice.util.Util;

public class InvalidProductIdException extends Exception {

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return Util.INVALID_PRODUCT_ID;
	}
}
