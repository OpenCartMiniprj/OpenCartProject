Feature: fetching products in cart Details
Scenario: testing the get call for products in cart Details
 
Given url 'http://localhost/opencartpro/index.php?api_token=91e232d07553f929c2e6e25b38&route=api/cart/products'
When method GET
Then status 200