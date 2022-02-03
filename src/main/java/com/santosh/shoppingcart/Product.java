package com.santosh.shoppingcart;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Product {
	private final String name;
	private final BigDecimal price;
	private AtomicInteger quantity = new AtomicInteger();

	public Product(String name, BigDecimal price, int qty) {
		this.name = name;
		this.price = price;
		this.quantity.set(qty);
	}

	public String getName() {
		return name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity.get();
	}

	public void setQuantity(int qty) {
		this.quantity.set(qty);
	}
	
	public void incrementQuantity() {
		this.quantity.incrementAndGet();
	}
	
	public void incrementQuantity(int incrementBy) {
		this.quantity.addAndGet(incrementBy);
	}

	@Override
	public int hashCode() {
		// use name only
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		// use name only
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + ", quantity=" + quantity.get() + "]";
	}
	
}
