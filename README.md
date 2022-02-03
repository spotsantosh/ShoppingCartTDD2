ShoppingCart project demonstrates Test Driven Development concepts. It uses JUnit test cases to add features to the code.

How to run the project:
Run Junit tests provided in class com.santosh.shoppingcart.ShoppingCartTest. It has the following tests to capture functionality:

	addSingleProduct()
	addMultipleProducts()
	calcTaxOnMultipleProducts()
	
	

Assignment:
Shopping Cart ​ Overview Please write code delivering the acceptance criterias (AC) that follow. It is designed to be a straightforward coding exercise, and it should take you no more than 90 minutes. ​ What we are looking for: ​ Code Design: We are keen to understand how you design your code. We do not expect a command line, web or any other type of application. Invocation should be via tests. ​ Tests: We value unit testing highly. As such, your solution should have tests with sufficient test coverage, beyond the ACs below. ​ Simplicity: We value simplicity as an architectural virtue. Your solutions should reflect the difficulty of the assigned task, and no more. Layers of abstraction, patterns, or architectural features that aren’t specifically called for should not be included. ​ Self-explanatory code: The code must speak for itself. Long comments explaining the solution is a sign the solution is insufficiently simple. ​​ The problem statement - Acceptance Criterias ​ Create a shopping cart, add products to it, calculate the total price and sales tax for the items contained in the cart. ​ AC 0 : Add a single product. ​ Given:

    An empty shopping cart
    And a product, Dove Soap with a unit price of 39.99 ​ When:
    The user adds a single Dove Soap to the shopping cart ​ Then:
    The shopping cart should a single line item with 1 Dove Soap with a unit price of 39.99
    And the shopping cart's total price should equal 39.99
    All totals should be rounded up to 2 decimal places, i.e. 0.565 should result in 0.57 but 0.5649 should result in 0.56.
    You can follow this link if you want more details. ​ ​ AC 1 : Add many products. ​ Given:
    An empty shopping cart
    And a product, Dove Soap with a unit price of _39.99_​ When:
    The user adds 5 Dove Soaps to the shopping cart
    And then adds another 3 Dove Soaps to the shopping cart ​ Then:
    The shopping cart should contain a single line item, because product equality is not instance based
    The shopping cart should contain 8 Dove Soaps each with a unit price of 39.99
    And the shopping cart's total price should equal 319.92
    All totals should be rounded up to 2 decimal places as described in AC 0. ​ ​ AC 2 : Calculate tax rate with many products ​ Given:
    An empty shopping cart
    And a product, Dove Soap with a unit price of 39.99
    And another product, Axe Deo with a unit price of 99.99
    And a sales tax rate of 12.5% applicable to all products equally ​ When:
    The user adds 2 Dove Soaps to the shopping cart
    And then adds 2 Axe Deos to the shopping cart ​ Then:
    The shopping cart should contain a line item with 2 Dove Soaps each with a unit price of 39.99
    And the shopping cart should contain a line item with 2 Axe Deos each with a unit price of 99.99
    And the total sales tax amount for the shopping cart should equal 35.00
    And the shopping cart's total price should equal 314.96
    All totals should be rounded up to 2 decimal places as described in AC 0.

	