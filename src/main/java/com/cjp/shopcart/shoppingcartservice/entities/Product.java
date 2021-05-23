package com.cjp.shopcart.shoppingcartservice.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;
	private String productName;
	private Integer cartonSize;
	private Double cartonPrice;
	private Double compensateRatio;
	private Integer discountLevel;
	private Double discount;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getCartonSize() {
		return cartonSize;
	}

	public void setCartonSize(Integer cartonSize) {
		this.cartonSize = cartonSize;
	}

	public Double getCartonPrice() {
		return cartonPrice;
	}

	public void setCartonPrice(Double cartonPrice) {
		this.cartonPrice = cartonPrice;
	}

	public Double getCompensateRatio() {
		return compensateRatio;
	}

	public void setCompensateRatio(Double compensateRatio) {
		this.compensateRatio = compensateRatio;
	}

	public Integer getDiscountLevel() {
		return discountLevel;
	}

	public void setDiscountLevel(Integer discountLevel) {
		this.discountLevel = discountLevel;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

}
