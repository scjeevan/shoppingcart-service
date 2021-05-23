package com.cjp.shopcart.shoppingcartservice.response;

public class ProductPriceResponse {

	private int requestedQty;
	private int unit;
	private int cartons;
	private double amount;

	public ProductPriceResponse(int requestedQty, int unit, int cartons, double amount) {
		super();
		this.requestedQty = requestedQty;
		this.unit = unit;
		this.cartons = cartons;
		this.amount = amount;
	}

	public int getRequestedQty() {
		return requestedQty;
	}

	public void setRequestedQty(int requestedQty) {
		this.requestedQty = requestedQty;
	}

	public int getUnit() {
		return unit;
	}

	public void setUnit(int unit) {
		this.unit = unit;
	}

	public int getCartons() {
		return cartons;
	}

	public void setCartons(int cartons) {
		this.cartons = cartons;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "ProductPriceResponse [requestedQty=" + requestedQty + ", unit=" + unit + ", cartons=" + cartons
				+ ", amount=" + amount + "]";
	}

}
