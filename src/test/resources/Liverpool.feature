@REGRESSION @liverpool
Feature: Feature to cover liverpool scenarios

  Background:
    Given I start my browser
#  Scenario: Search laptops
    # Given : Detail : Given I use searchbox with "laptops"
    # When :  Accion Ex. Consume Api, click button
    # Then :  Validar Ex. Validate screen X loads
    # And / But : Given== When == Then
    # Feature
    # Scenario / Scenario Outline

  @scen-1 @positive
  Scenario Outline: Search a product
    Given I open liverpool webpage
    And I want to look for availbility of "<Article>"
    When I search I want to sort by "<Brand>" brand
    And size "<Size>"
    Then I open the first article in the screen

    Examples:
      | Article     | Brand   | Size        |
      | Smart tv    | SAMSUNG | 43 pulgadas |
      | me239jd293j | SAMSUNG | 43 pulgadas |

  @scen-1 @negative
  Scenario Outline: Validate product is not available
    Given I open liverpool webpage
    And I validate the article "<Article>" is not available

    Examples:
      | Article     |
      | me239jd293j |
#Story 1. Search Bar
#As a consumer, I want to be capable to easily search for different types of articles so I can:
#Find one or more articles of my interest
#Be notified if there are no articles
#Search the articles by brand, physical characteristic, model
#Story 2. Buying a Smart TV
#As a consumer, I want to be capable select a Smart TV from the catalog based on brand,
#size, and under a range of price so I can buy the best fit to my needs.
#Story 3. Create a consumer account
#As a consumer, I want to be capable create a consumer account so I can:
#Receive promotion notification
#Be logged when I want to buy a product 
