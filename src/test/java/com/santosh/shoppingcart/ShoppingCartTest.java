package com.santosh.shoppingcart;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ShoppingCartTest {
	private ShoppingCart cart;
	
	// delta is 0.01 if roundingScale is 2
	private double delta = Math.pow(10, -( Constants.roundingScale));
	
	@BeforeEach
	private void beforeEach() {
		cart = new ShoppingCart();
	}
	
	/*
	 * AC 0 : Add a single product.
	 * 
	 * Given: An empty shopping cart And a product,
	 * _Dove Soap_ with a unit price of _39.99_
	 * 
	 * When: The user adds a single _Dove
	 * Soap_ to the shopping cart
	 * 
	 * Then: The shopping cart should a single line
	 * item with 1 Dove Soap with a unit price of _39.99_ And the shopping cart's
	 * total price should equal _39.99_ All totals should be rounded up to 2 decimal
	 * places, i.e. 0.565 should result in 0.57 but 0.5649 should result in 0.56.
	 * 
	 */
	@Test
	public void addSingleProduct() {
		cart.addProduct(new Product("Dove Soap", BigDecimal.valueOf(39.99), 1));
		BigDecimal totalPriceBeforeTax = cart.calcTotalPriceBeforeTax();
		assertEquals("AC0 FAILED: add single product test failed.",
				39.99d, totalPriceBeforeTax.doubleValue(), delta);
	}
	
	/*
	 * AC 1 : Add many products.
	 * 
	 * Given: An empty shopping cart And a product,
	 * _Dove Soap_ with a unit price of _39.99_
	 * ​
	 * When: The user adds 5 _Dove Soaps_
	 * to the shopping cart And then adds another 3 _Dove Soaps_ to the shopping
	 * cart
	 * 
	 * Then: The shopping cart should contain a single line item, because
	 * product equality is not instance based The shopping cart should contain 8
	 * Dove Soaps each with a unit price of _39.99_ And the shopping cart's total
	 * price should equal _319.92_ All totals should be rounded up to 2 decimal
	 * places as described in AC 0.
	 */
	@Test
	public void addMultipleProducts() {
		cart.addProduct(new Product("Dove Soap", BigDecimal.valueOf(39.99), 5));
		cart.addProduct(new Product("Dove Soap", BigDecimal.valueOf(39.99), 3));
		BigDecimal totalPriceBeforeTax = cart.calcTotalPriceBeforeTax();
		assertEquals("AC1 FAILED: add multiple products test failed.",
				319.92d, totalPriceBeforeTax.doubleValue(), delta);
	}
	
	/**
	 * AC 2 : Calculate tax rate with many products
	​Given:
	* An empty shopping cart
	* And a product, _Dove Soap_ with a unit price of _39.99_
	* And another product, _Axe Deo_ with a unit price of _99.99_
	* And a sales tax rate of 12.5% applicable to all products equally
		​
	When:
	* The user adds 2 _Dove Soaps_ to the shopping cart
	* And then adds 2 _Axe Deos_ to the shopping cart
	​
	Then:
	* The shopping cart should contain a line item with 2 Dove Soaps each with a
	unit price of _39.99_
	* And the shopping cart should contain a line item with 2 Axe Deos each with a
	unit price of _99.99_
	* And the total sales tax amount for the shopping cart should equal _35.00_
	* And the shopping cart's total price should equal _314.96_
	* All totals should be rounded up to 2 decimal places as described in AC 0.
	 */

	@Test
	public void calcTaxOnMultipleProducts() {
		cart.addProduct(new Product("Dove Soap", BigDecimal.valueOf(39.99), 2));
		cart.addProduct(new Product("Axe Deos",  BigDecimal.valueOf(99.99), 2));
		BigDecimal tax = cart.calcTax();
		assertEquals("AC2.1 FAILED: calculat Tax rate with multiple products test failed.",
				35.00d, tax.doubleValue(), delta);

		BigDecimal totalPriceAfterTax = cart.calcTotalPriceAfterTax();
		assertEquals("AC2.2 FAILED: calculat total price with multiple products test failed.",
				314.96d, totalPriceAfterTax.doubleValue(), delta);
	}	
	
}
