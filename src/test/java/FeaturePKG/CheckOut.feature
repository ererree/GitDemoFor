Feature: Place order for Product


@Checkout
Scenario Outline: Search Experience for product search in both home and offer page


Given User is on Greencart landing page
When user searched with shortname <Names> and extracted actual name of that product
And Added "3" Items of selected product to cart
Then user proceeds to checkout and validate the <Names> items in checkout page
And Verify user has to apply Promocode and place the order 

Examples: 
|Names|
| Tom |