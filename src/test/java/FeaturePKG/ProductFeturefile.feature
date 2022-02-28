Feature: Search Product and Place order

@Offerspage
Scenario Outline: Search Experience for product search in both home and offer page


Given User is on Greencart landing page
When user searched with shortname <Names> and extracted actual name of that product
Then user searched for same shortname <Names> in offer page
And Validate the product name in offerspage matches with landing page

Examples: 
|Names|
| Tom |
| Bit |