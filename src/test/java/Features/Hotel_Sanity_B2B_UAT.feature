
@sanity_Hotel_B2B_UAT
Feature: Hotel Sanity_TestCases  Dbtravel B2B UAT

  Background: 


    Scenario Outline: Validate the Payment on Review page with normal booking with multi pax
    Given User is on dbtravel Landing page with the "uatb2b" environment
    When User SighnIn with username and password for "uatb2b"
    Then User selct the Hotel option on home page
    Then Select the Nationality
    Then User pass the cityname for hotlbooking from given sheetName <SheetIndex> and rowNumber <RowNumber>
    Then User select the date for hotle booking INdate and Outdate
    Then User select the Adult and child and room as per requirment
    And User clicks on the search button
    Then User selects the hotel
    And User selects the refundable room
    And User handle the Room not available Popup
    Then Calculate_the_AmountOnReviewPage

    Examples: 
      | SheetIndex | RowNumber |
      |          1 |         0 |
      |          1 |         1 |
      |          1 |         2 |
      |          1 |         3 |
      |          1 |         4 |
      |          1 |         5 |
      |          1 |         6 |
      |          1 |         7 |
      |          1 |         8 |
      |          1 |         9 |


  Scenario Outline: TC_01 Validate the Payment on review page with Domestic Multipax Refundable Add Mark up in percentage Add local taxes
    Given User is on dbtravel Landing page with the "uatb2b" environment
    When User SighnIn with username and password for "uatb2b"
    Then User selct the Hotel option on home page
    Then Select the Nationality
    Then User pass the cityname for hotlbooking from given sheetName <SheetIndex> and rowNumber <RowNumber>
    Then selec the Advanced Search
    When User select the fare type Refundable frome Advanced Search
    Then User select the date for hotle booking INdate and Outdate
    Then User select the Adult and child and room as per requirment
    And User clicks on the search button
    Then User selects the hotel
    And User selects the refundable room
    And User handle the Room not available Popup
    Then Add Mark Up or Makr Down
    Then Add Percentage or Flat
    Then Add local taxes
    Then Calculate_the_AmountOnReviewPage

    Examples: 
      | SheetIndex | RowNumber |
      |          1 |         0 |


  Scenario Outline: TC_02 Validate the Payment on review page with Domestic	Multipax 	Breakfast	Refundable Add Mark up in Fixed type Add local Taxes
    Given User is on dbtravel Landing page with the "uatb2b" environment
    When User SighnIn with username and password for "uatb2b"
    Then User selct the Hotel option on home page
    Then Select the Nationality
    Then User pass the cityname for hotlbooking from given sheetName <SheetIndex> and rowNumber <RowNumber>
    Then selec the Advanced Search
    When User select the brekfast option frome select breakfast
    Then User select the date for hotle booking INdate and Outdate
    Then User select the Adult and child and room as per requirment
    And User clicks on the search button
    Then User selects the hotel
    And User selects the refundable room
    And User handle the Room not available Popup
    Then Add Mark Up or Makr Down
    Then Add Percentage or Flat
    Then Add local taxes
    Then Calculate_the_AmountOnReviewPage

    Examples: 
      | SheetIndex | RowNumber |
      |          1 |         1 |


  Scenario Outline: TC_03 Validate the Payment on review page with Domestic	Multipax	Rating	Refundable Add Mark down in percentage Add local Taxes
    Given User is on dbtravel Landing page with the "uatb2b" environment
    When User SighnIn with username and password for "uatb2b"
    Then User selct the Hotel option on home page
    Then Select the Nationality
    Then User pass the cityname for hotlbooking from given sheetName <SheetIndex> and rowNumber <RowNumber>
    Then selec the Advanced Search
    When User select the star rating
    Then User select the date for hotle booking INdate and Outdate
    Then User select the Adult and child and room as per requirment
    And User clicks on the search button
    Then User selects the hotel
    And User selects the refundable room
    And User handle the Room not available Popup
    Then Add Mark Up or Makr Down
    Then Add Percentage or Flat
    Then Add local taxes
    Then Calculate_the_AmountOnReviewPage

    Examples: 
      | SheetIndex | RowNumber |
      |          1 |         2 |


  Scenario Outline: TC_04 Validate the Payment on review page with Domestic	Multipax	Refundable Quick filter Add Markdown in Fixed type Add local Taxes
    Given User is on dbtravel Landing page with the "uatb2b" environment
    When User SighnIn with username and password for "uatb2b"
    Then User selct the Hotel option on home page
    Then Select the Nationality
    Then User pass the cityname for hotlbooking from given sheetName <SheetIndex> and rowNumber <RowNumber>
    Then User select the date for hotle booking INdate and Outdate
    Then User select the Adult and child and room as per requirment
    And User clicks on the search button
    Then User select the Quick filter
    Then User selects the hotel
    And User selects the refundable room
    And User handle the Room not available Popup
    Then Add Mark Up or Makr Down
    Then Add Percentage or Flat
    Then Add local taxes
    Then Calculate_the_AmountOnReviewPage

    Examples: 
      | SheetIndex | RowNumber |
      |          1 |         3 |


  Scenario Outline: TC_05 Validate the Payment on review page with Domestic	Multipax	Refundable Star Rating Add Mark up in percentage Add local taxes
    Given User is on dbtravel Landing page with the "uatb2b" environment
    When User SighnIn with username and password for "uatb2b"
    Then User selct the Hotel option on home page
    Then Select the Nationality
    Then User pass the cityname for hotlbooking from given sheetName <SheetIndex> and rowNumber <RowNumber>
    Then User select the date for hotle booking INdate and Outdate
    Then User select the Adult and child and room as per requirment
    And User clicks on the search button
    Then User select the Star Rating
    Then User selects the hotel
    And User selects the refundable room
    And User handle the Room not available Popup
    Then Add Mark Up or Makr Down
    Then Add Percentage or Flat
    Then Add local taxes
    Then Calculate_the_AmountOnReviewPage

    Examples: 
      | SheetIndex | RowNumber |
      |          1 |         4 |


  Scenario Outline: TC_06 Validate the Payment on review page with International Multipax Refundable Price Range Add Mark up in Fixed type Add local Taxes
    Given User is on dbtravel Landing page with the "uatb2b" environment
    When User SighnIn with username and password for "uatb2b"
    Then User selct the Hotel option on home page
    Then Select the Nationality
    Then User pass the cityname for hotlbooking from given sheetName <SheetIndex> and rowNumber <RowNumber>
    Then User select the date for hotle booking INdate and Outdate
    Then User select the Adult and child and room as per requirment
    And User clicks on the search button
    Then User select the Price Range
    Then User selects the hotel
    And User selects the refundable room
    And User handle the Room not available Popup
    Then Add Mark Up or Makr Down
    Then Add Percentage or Flat
    Then Add local taxes
    Then Calculate_the_AmountOnReviewPage

    Examples: 
      | SheetIndex | RowNumber |
      |          1 |         5 |


  Scenario Outline: TC_07 Validate the Payment on review page with International Multipax Refundable Amenities Add Mark down in percentage  Add local Taxes
    Given User is on dbtravel Landing page with the "uatb2b" environment
    When User SighnIn with username and password for "uatb2b"
    Then User selct the Hotel option on home page
    Then Select the Nationality
    Then User pass the cityname for hotlbooking from given sheetName <SheetIndex> and rowNumber <RowNumber>
    Then User select the date for hotle booking INdate and Outdate
    Then User select the Adult and child and room as per requirment
    And User clicks on the search button
    Then User select the Amenities
    Then User selects the hotel
    And User selects the refundable room
    And User handle the Room not available Popup
    Then Add Mark Up or Makr Down
    Then Add Percentage or Flat
    Then Add local taxes
    Then Calculate_the_AmountOnReviewPage

    Examples: 
      | SheetIndex | RowNumber |
      |          1 |         6 |


  Scenario Outline: TC_08 Validate the Payment on review page with International Multipax Refundable Vacation Type Add Mark down in Fixed type Add local Taxes
    Given User is on dbtravel Landing page with the "uatb2b" environment
    When User SighnIn with username and password for "uatb2b"
    Then User selct the Hotel option on home page
    Then Select the Nationality
    Then User pass the cityname for hotlbooking from given sheetName <SheetIndex> and rowNumber <RowNumber>
    Then User select the date for hotle booking INdate and Outdate
    Then User select the Adult and child and room as per requirment
    And User clicks on the search button
    Then User select the Vacation Type filter
    Then User selects the hotel
    And User selects the refundable room
    And User handle the Room not available Popup
    Then Add Mark Up or Makr Down
    Then Add Percentage or Flat
    Then Add local taxes
    Then Calculate_the_AmountOnReviewPage

    Examples: 
      | SheetIndex | RowNumber |
      |          1 |         7 |


  Scenario Outline: TC_09 Validate the Payment on review page with International Multipax Refundable Property Type	Add Mark up in percentage Add local taxes
    Given User is on dbtravel Landing page with the "uatb2b" environment
    When User SighnIn with username and password for "uatb2b"
    Then User selct the Hotel option on home page
    Then Select the Nationality
    Then User pass the cityname for hotlbooking from given sheetName <SheetIndex> and rowNumber <RowNumber>
    Then User select the date for hotle booking INdate and Outdate
    Then User select the Adult and child and room as per requirment
    And User clicks on the search button
    Then User select the Property Type filter
    Then User selects the hotel
    And User selects the refundable room
    And User handle the Room not available Popup
    Then Add Mark Up or Makr Down
    Then Add Percentage or Flat
    Then Add local taxes
    Then Calculate_the_AmountOnReviewPage

    Examples: 
      | SheetIndex | RowNumber |
      |          1 |         8 |


  Scenario Outline: TC_10 Validate the Payment on review page with International Multipax Refundable Add Mark down in Fixed type Add local Taxes
    Given User is on dbtravel Landing page with the "uatb2b" environment
    When User SighnIn with username and password for "uatb2b"
    Then User selct the Hotel option on home page
    Then Select the Nationality
    Then User pass the cityname for hotlbooking from given sheetName <SheetIndex> and rowNumber <RowNumber>
    Then User select the date for hotle booking INdate and Outdate
    Then User select the Adult and child and room as per requirment
    And User clicks on the search button
    Then User selects the hotel
    And User selects the refundable room
    And User handle the Room not available Popup
    Then Add Mark Up or Makr Down
    Then Add Percentage or Flat
    Then Add local taxes
    Then Calculate_the_AmountOnReviewPage

    Examples: 
      | SheetIndex | RowNumber |
      |          1 |         9 |


  Scenario Outline: TC_11 Validate the Payment on review page with Domestic Multipax Non-Refundable Add Mark up in percentage Add local taxes
    Given User is on dbtravel Landing page with the "uatb2b" environment
    When User SighnIn with username and password for "uatb2b"
    Then User selct the Hotel option on home page
    Then Select the Nationality
    Then User pass the cityname for hotlbooking from given sheetName <SheetIndex> and rowNumber <RowNumber>
    Then selec the Advanced Search
    When User select the fare type Refundable frome Advanced Search
    Then User select the date for hotle booking INdate and Outdate
    Then User select the Adult and child and room as per requirment
    And User clicks on the search button
    Then User selects the hotel
    And User selects the non-refundable room
    And User handle the Room not available Popup
    Then Add Mark Up or Makr Down
    Then Add Percentage or Flat
    Then Add local taxes
    Then Calculate_the_AmountOnReviewPage

    Examples: 
      | SheetIndex | RowNumber |
      |          1 |         0 |


  Scenario Outline: TC_12 Validate the Payment on review page with Domestic	Multipax 	Breakfast	Non-Refundable Add Mark up in Fixed type Add local Taxes
    Given User is on dbtravel Landing page with the "uatb2b" environment
    When User SighnIn with username and password for "uatb2b"
    Then User selct the Hotel option on home page
    Then Select the Nationality
    Then User pass the cityname for hotlbooking from given sheetName <SheetIndex> and rowNumber <RowNumber>
    Then selec the Advanced Search
    When User select the brekfast option frome select breakfast
    Then User select the date for hotle booking INdate and Outdate
    Then User select the Adult and child and room as per requirment
    And User clicks on the search button
    Then User selects the hotel
    And User selects the non-refundable room
    And User handle the Room not available Popup
    Then Add Mark Up or Makr Down
    Then Add Percentage or Flat
    Then Add local taxes
    Then Calculate_the_AmountOnReviewPage

    Examples: 
      | SheetIndex | RowNumber |
      |          1 |         1 |


  Scenario Outline: TC_13 Validate the Payment on review page with Domestic	Multipax	Rating	Non-Refundable Add Mark down in percentage Add local Taxes
    Given User is on dbtravel Landing page with the "uatb2b" environment
    When User SighnIn with username and password for "uatb2b"
    Then User selct the Hotel option on home page
    Then Select the Nationality
    Then User pass the cityname for hotlbooking from given sheetName <SheetIndex> and rowNumber <RowNumber>
    Then selec the Advanced Search
    When User select the star rating
    Then User select the date for hotle booking INdate and Outdate
    Then User select the Adult and child and room as per requirment
    And User clicks on the search button
    Then User selects the hotel
    And User selects the non-refundable room
    And User handle the Room not available Popup
    Then Add Mark Up or Makr Down
    Then Add Percentage or Flat
    Then Add local taxes
    Then Calculate_the_AmountOnReviewPage

    Examples: 
      | SheetIndex | RowNumber |
      |          1 |         2 |


  Scenario Outline: TC_14 Validate the Payment on review page with Domestic	Multipax	Non-Refundable Quick filter Add Markdown in Fixed type Add local Taxes
    Given User is on dbtravel Landing page with the "uatb2b" environment
    When User SighnIn with username and password for "uatb2b"
    Then User selct the Hotel option on home page
    Then Select the Nationality
    Then User pass the cityname for hotlbooking from given sheetName <SheetIndex> and rowNumber <RowNumber>
    Then User select the date for hotle booking INdate and Outdate
    Then User select the Adult and child and room as per requirment
    And User clicks on the search button
    Then User select the Quick filter
    Then User selects the hotel
    And User selects the non-refundable room
    And User handle the Room not available Popup
    Then Add Mark Up or Makr Down
    Then Add Percentage or Flat
    Then Add local taxes
    Then Calculate_the_AmountOnReviewPage

    Examples: 
      | SheetIndex | RowNumber |
      |          1 |         3 |


  Scenario Outline: TC_15 Validate the Payment on review page with Domestic	Multipax	Non-Refundable Star Rating Add Mark up in percentage Add local taxes
    Given User is on dbtravel Landing page with the "uatb2b" environment
    When User SighnIn with username and password for "uatb2b"
    Then User selct the Hotel option on home page
    Then Select the Nationality
    Then User pass the cityname for hotlbooking from given sheetName <SheetIndex> and rowNumber <RowNumber>
    Then User select the date for hotle booking INdate and Outdate
    Then User select the Adult and child and room as per requirment
    And User clicks on the search button
    Then User select the Star Rating
    Then User selects the hotel
    And User selects the non-refundable room
    And User handle the Room not available Popup
    Then Add Mark Up or Makr Down
    Then Add Percentage or Flat
    Then Add local taxes
    Then Calculate_the_AmountOnReviewPage

    Examples: 
      | SheetIndex | RowNumber |
      |          1 |         4 |


  Scenario Outline: TC_16 Validate the Payment on review page with International Multipax Non-Refundable Price Range Add Mark up in Fixed type Add local Taxes
    Given User is on dbtravel Landing page with the "uatb2b" environment
    When User SighnIn with username and password for "uatb2b"
    Then User selct the Hotel option on home page
    Then Select the Nationality
    Then User pass the cityname for hotlbooking from given sheetName <SheetIndex> and rowNumber <RowNumber>
    Then User select the date for hotle booking INdate and Outdate
    Then User select the Adult and child and room as per requirment
    And User clicks on the search button
    Then User select the Price Range
    Then User selects the hotel
    And User selects the non-refundable room
    And User handle the Room not available Popup
    Then Add Mark Up or Makr Down
    Then Add Percentage or Flat
    Then Add local taxes
    Then Calculate_the_AmountOnReviewPage

    Examples: 
      | SheetIndex | RowNumber |
      |          1 |         5 |


  Scenario Outline: TC_17 Validate the Payment on review page with International Multipax Non-Refundable Amenities Add Mark down in percentage  Add local Taxes
    Given User is on dbtravel Landing page with the "uatb2b" environment
    When User SighnIn with username and password for "uatb2b"
    Then User selct the Hotel option on home page
    Then Select the Nationality
    Then User pass the cityname for hotlbooking from given sheetName <SheetIndex> and rowNumber <RowNumber>
    Then User select the date for hotle booking INdate and Outdate
    Then User select the Adult and child and room as per requirment
    And User clicks on the search button
    Then User select the Amenities
    Then User selects the hotel
    And User selects the refundable room
    And User handle the Room not available Popup
    Then Add Mark Up or Makr Down
    Then Add Percentage or Flat
    Then Add local taxes
    Then Calculate_the_AmountOnReviewPage

    Examples: 
      | SheetIndex | RowNumber |
      |          1 |         6 |


  Scenario Outline: TC_18 Validate the Payment on review page with International Multipax Non-Refundable Vacation Type Add Mark down in Fixed type Add local Taxes
    Given User is on dbtravel Landing page with the "uatb2b" environment
    When User SighnIn with username and password for "uatb2b"
    Then User selct the Hotel option on home page
    Then Select the Nationality
    Then User pass the cityname for hotlbooking from given sheetName <SheetIndex> and rowNumber <RowNumber>
    Then User select the date for hotle booking INdate and Outdate
    Then User select the Adult and child and room as per requirment
    And User clicks on the search button
    Then User select the Vacation Type filter
    Then User selects the hotel
    And User selects the non-refundable room
    And User handle the Room not available Popup
    Then Add Mark Up or Makr Down
    Then Add Percentage or Flat
    Then Add local taxes
    Then Calculate_the_AmountOnReviewPage

    Examples: 
      | SheetIndex | RowNumber |
      |          1 |         7 |


  Scenario Outline: TC_19 Validate the Payment on review page with International Multipax Non-Refundable Property Type	Add Mark up in percentage Add local taxes
    Given User is on dbtravel Landing page with the "uatb2b" environment
    When User SighnIn with username and password for "uatb2b"
    Then User selct the Hotel option on home page
    Then Select the Nationality
    Then User pass the cityname for hotlbooking from given sheetName <SheetIndex> and rowNumber <RowNumber>
    Then User select the date for hotle booking INdate and Outdate
    Then User select the Adult and child and room as per requirment
    And User clicks on the search button
    Then User select the Property Type filter
    Then User selects the hotel
    And User selects the non-refundable room
    And User handle the Room not available Popup
    Then Add Mark Up or Makr Down
    Then Add Percentage or Flat
    Then Add local taxes
    Then Calculate_the_AmountOnReviewPage

    Examples: 
      | SheetIndex | RowNumber |
      |          1 |         8 |


  Scenario Outline: TC_20 Validate the Payment on review page with International Multipax Non-Refundable Add Mark down in Fixed type Add local Taxes
    Given User is on dbtravel Landing page with the "uatb2b" environment
    When User SighnIn with username and password for "uatb2b"
    Then User selct the Hotel option on home page
    Then Select the Nationality
    Then User pass the cityname for hotlbooking from given sheetName <SheetIndex> and rowNumber <RowNumber>
    Then User select the date for hotle booking INdate and Outdate
    Then User select the Adult and child and room as per requirment
    And User clicks on the search button
    Then User selects the hotel
    And User selects the non-refundable room
    And User handle the Room not available Popup
    Then Add Mark Up or Makr Down
    Then Add Percentage or Flat
    Then Add local taxes
    Then Calculate_the_AmountOnReviewPage

    Examples: 
      | SheetIndex | RowNumber |
      |          1 |         9 |
