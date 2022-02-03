package com.santosh.shoppingcart;

import java.math.BigDecimal;
import java.util.concurrent.ConcurrentHashMap;

public class ShoppingCart {
	private ConcurrentHashMap<String, Product> productMap;

	public ShoppingCart() {
		productMap = new ConcurrentHashMap<>();
	}
	
	public void addProduct(Product product) {
		Product existingProduct = productMap.putIfAbsent(product.getName(), product);
		if(existingProduct != null) {
			existingProduct.incrementQuantity(product.getQuantity());
		}
	}

	public BigDecimal calcTotalPriceBeforeTax() {
		double totalPrice = 0;
		for(Product next : productMap.values()) {
			totalPrice += (next.getPrice().doubleValue() * next.getQuantity());
		}
		return roundUp(totalPrice);
	}
	
	public BigDecimal calcTax() {
		BigDecimal totalPriceBeforeTax = calcTotalPriceBeforeTax();
		return roundUp(totalPriceBeforeTax.multiply(Constants.taxRate));
	}

	public BigDecimal calcTotalPriceAfterTax() {
		BigDecimal totalPriceBeforeTax = calcTotalPriceBeforeTax();
		BigDecimal tax = totalPriceBeforeTax.multiply(Constants.taxRate);
		return roundUp(totalPriceBeforeTax.add(tax));
	}
	
	private BigDecimal roundUp(double value) {
		return BigDecimal.valueOf(value)
				.setScale(Constants.roundingScale, BigDecimal.ROUND_HALF_UP);
	}

	private BigDecimal roundUp(BigDecimal value) {
		return value
				.setScale(Constants.roundingScale, BigDecimal.ROUND_HALF_UP);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		productMap.entrySet()
		.stream()
		.forEach(p -> sb.append(p.getValue().getName()
						+ "\tprice:" + p.getValue().getPrice()
						+ "\tqty:"   + p.getValue().getQuantity())
				)
		;
		return sb.toString();
		
	}
	
}
