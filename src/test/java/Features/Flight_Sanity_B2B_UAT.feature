
@sanity_Flight_B2B_UAT
Feature: Flight sanity testing  Dbtravel B2B UAT


    Scenario Outline: TC_01 "One way" refundable stop_filters and add markup in percenatge and local_taxes
    Given User is on dbtravel Landing page with the "uatb2b" environment
    When User SighnIn with username and password for "uatb2b"
    Then User select the trip and pass origin and destination from given sheetName <SheetName> and rowNumber <RowNumber>
    Then select the date for trip
    Then User select the passenger for trip
    Then select the class for trip
    And User clicks on the search button for flight
    Then user select search filter number of stops
    Then user select search filter fare type
    Then select the Flight and click on book
    Then User handel the Price Change Alert Popup
    Then user select marktype radio button
    Then user select either percent or flat toggle
    Then user enter local taxes
    Then check for Fare Details total amounts calculation

    Examples: 
      | SheetName | RowNumber |
      |         0 |         0 |


    Scenario Outline: TC_02 "One way" refundable price_filters and add markup in percenatge and local_taxes
    Given User is on dbtravel Landing page with the "uatb2b" environment
    When User SighnIn with username and password for "uatb2b"
    Then User select the trip and pass origin and destination from given sheetName <SheetName> and rowNumber <RowNumber>
    Then select the date for trip
    Then User select the passenger for trip
    Then select the class for trip
    And User clicks on the search button for flight
    Then user apply pricerange filters
    Then user select search filter fare type
    Then select the Flight and click on book
    Then User handel the Price Change Alert Popup
    Then user select marktype radio button
    Then user select either percent or flat toggle
    Then user enter local taxes
    Then check for Fare Details total amounts calculation

    Examples: 
      | SheetName | RowNumber |
      |         0 |         1 |


    Scenario Outline: TC_03 "One way" refundable trip_duration_filters and add markup in fixed type and local_taxes
    Given User is on dbtravel Landing page with the "uatb2b" environment
    When User SighnIn with username and password for "uatb2b"
    Then User select the trip and pass origin and destination from given sheetName <SheetName> and rowNumber <RowNumber>
    Then select the date for trip
    Then User select the passenger for trip
    Then select the class for trip
    And User clicks on the search button for flight
    Then user apply trip duration filters
    Then user select search filter fare type
    Then select the Flight and click on book
    Then User handel the Price Change Alert Popup
    Then user select marktype radio button
    Then user select either percent or flat toggle
    Then user enter local taxes
    Then check for Fare Details total amounts calculation

    Examples: 
      | SheetName | RowNumber |
      |         0 |         2 |


    Scenario Outline: TC_4 "One way" refundable departure from and add markdown in percenatge and local_taxes
    Given User is on dbtravel Landing page with the "uatb2b" environment
    When User SighnIn with username and password for "uatb2b"
    Then User select the trip and pass origin and destination from given sheetName <SheetName> and rowNumber <RowNumber>
    Then select the date for trip
    Then User select the passenger for trip
    Then select the class for trip
    And User clicks on the search button for flight
    And user selects departure time from
    Then user select search filter fare type   
    Then select the Flight and click on book
    Then User handel the Price Change Alert Popup
    Then user select marktype radio button
    Then user select either percent or flat toggle
    Then user enter local taxes
    Then check for Fare Details total amounts calculation

    Examples: 
      | SheetName | RowNumber |
      |         0 |         3 |

    #@sanity_Flight_B2B
    Scenario Outline: TC_5 "One way" refundable Onward airline and add markdown in fixed type and local_taxes
    Given User is on dbtravel Landing page with the "uatb2b" environment
    When User SighnIn with username and password for "uatb2b"
    Then User select the trip and pass origin and destination from given sheetName <SheetName> and rowNumber <RowNumber>
    Then select the date for trip
    Then User select the passenger for trip
    Then select the class for trip
    And User clicks on the search button for flight
    And user selects Onward airlines
    Then select the Flight and click on book
    Then User handel the Price Change Alert Popup
    Then user select marktype radio button
    Then user select either percent or flat toggle
    Then user enter local taxes
    Then check for Fare Details total amounts calculation

    Examples: 
      | SheetName | RowNumber |
      |         0 |         4 |


#
   Scenario Outline: TC_6 "One way" refundable Layover and add markdown in percenatge and local_taxes
    Given User is on dbtravel Landing page with the "uatb2b" environment
    When User SighnIn with username and password for "uatb2b"
    Then User select the trip and pass origin and destination from given sheetName <SheetName> and rowNumber <RowNumber>
    Then select the date for trip
    Then User select the passenger for trip
    Then select the class for trip
    And User clicks on the search button for flight
    And user selects Layover onwards
    Then select the Flight and click on book
    Then User handel the Price Change Alert Popup
    Then user select marktype radio button
    Then user select either percent or flat toggle
    Then user enter local taxes
    Then check for Fare Details total amounts calculation

    Examples: 
      | SheetName | RowNumber |
      |         0 |         5 |
      
      

#
   Scenario Outline: TC_7 "Round trip" refundable stop_filters and add markup in fixed type and local_taxes
    Given User is on dbtravel Landing page with the "uatb2b" environment
    When User SighnIn with username and password for "uatb2b"
    Then User select the trip and pass origin and destination from given sheetName <SheetName> and rowNumber <RowNumber>
    Then select the date for trip
    Then User select the passenger for trip
    Then select the class for trip
    And User clicks on the search button for flight
    Then user select search filter number of stops
    Then user select search filter fare type   
    Then select the Flight and click on book
    Then User handel the Price Change Alert Popup
    Then user select marktype radio button
    Then user select either percent or flat toggle
    Then user enter local taxes
    Then check for Fare Details total amounts calculation

    Examples: 
      | SheetName | RowNumber |
      |         0 |         6 |

#
   Scenario Outline: TC_8 "Round trip" refundable price_filters and add markup in fixed type and local_taxes
    Given User is on dbtravel Landing page with the "uatb2b" environment
    When User SighnIn with username and password for "uatb2b"
    Then User select the trip and pass origin and destination from given sheetName <SheetName> and rowNumber <RowNumber>
    Then select the date for trip
    Then User select the passenger for trip
    Then select the class for trip
    And User clicks on the search button for flight
    Then user apply pricerange filters
    Then select the Flight and click on book
    Then User handel the Price Change Alert Popup
    Then user select marktype radio button
    Then user select either percent or flat toggle
    Then user enter local taxes
    Then check for Fare Details total amounts calculation

    Examples: 
      | SheetName | RowNumber |
      |         0 |         7 |


    Scenario Outline: TC_9 "Round trip" refundable trip_duration_filters and add markup in fixed type and local_taxes
    Given User is on dbtravel Landing page with the "uatb2b" environment
    When User SighnIn with username and password for "uatb2b"
    Then User select the trip and pass origin and destination from given sheetName <SheetName> and rowNumber <RowNumber>
    Then select the date for trip
    Then User select the passenger for trip
    Then select the class for trip
    And User clicks on the search button for flight
    Then user apply trip duration filters
    Then user select search filter fare type   
    Then select the Flight and click on book
    Then User handel the Price Change Alert Popup
    Then user select marktype radio button
    Then user select either percent or flat toggle
    Then user enter local taxes
    Then check for Fare Details total amounts calculation

    Examples: 
      | SheetName | RowNumber |
      |         0 |         8 |

#
   Scenario Outline: TC_10 "Round trip" refundable departure from and add markdown in percenatge and local_taxes
    Given User is on dbtravel Landing page with the "uatb2b" environment
    When User SighnIn with username and password for "uatb2b"
    Then User select the trip and pass origin and destination from given sheetName <SheetName> and rowNumber <RowNumber>
    Then select the date for trip
    Then User select the passenger for trip
    Then select the class for trip
    And User clicks on the search button for flight
    And user selects departure time from
    Then user select search filter fare type   
    Then select the Flight and click on book
    Then User handel the Price Change Alert Popup
    Then user select marktype radio button
    Then user select either percent or flat toggle
    Then user enter local taxes
    Then check for Fare Details total amounts calculation

    Examples: 
      | SheetName | RowNumber |
      |         0 |         9 |

#
   Scenario Outline: TC_11 "Round trip" refundable Onward airline and add markdown in percenatge and local_taxes
    Given User is on dbtravel Landing page with the "uatb2b" environment
    When User SighnIn with username and password for "uatb2b"
    Then User select the trip and pass origin and destination from given sheetName <SheetName> and rowNumber <RowNumber>
    Then select the date for trip
    Then User select the passenger for trip
    Then select the class for trip
    And User clicks on the search button for flight
    And user selects Onward airlines
    And user selects return airlines
    Then user select search filter fare type   
    Then select the Flight and click on book
    Then User handel the Price Change Alert Popup
    Then user select marktype radio button
    Then user select either percent or flat toggle
    Then user enter local taxes
    Then check for Fare Details total amounts calculation

    Examples: 
      | SheetName | RowNumber |
      |         0 |        10 |

#
   Scenario Outline: TC_12 "Round trip" refundable Layover and add markdown in percenatge and local_taxes
    Given User is on dbtravel Landing page with the "uatb2b" environment
    When User SighnIn with username and password for "uatb2b"
    Then User select the trip and pass origin and destination from given sheetName <SheetName> and rowNumber <RowNumber>
    Then select the date for trip
    Then User select the passenger for trip
    Then select the class for trip
    And User clicks on the search button for flight
    And user selects Layover onwards
    And user selects Layover returns
    Then user select search filter fare type   
    Then select the Flight and click on book
    Then User handel the Price Change Alert Popup
    Then user select marktype radio button
    Then user select either percent or flat toggle
    Then user enter local taxes
    Then check for Fare Details total amounts calculation

    Examples: 
      | SheetName | RowNumber |
      |         0 |        11 |


    Scenario Outline: TC_13 "Half-Round-Trip" refundable Stops add markdown in Flat type and local_taxes
    Given User is on dbtravel Landing page with the "uatb2b" environment
    When User SighnIn with username and password for "uatb2b"
    Then User select the trip and pass origin and destination from given sheetName <SheetName> and rowNumber <RowNumber>
    Then select the date for trip
    Then User select the passenger for trip
    Then select the class for trip
    And User clicks on the search button for flight
    Then user select search filter number of stops
    Then select the Flight and click on book
    Then User handel the Price Change Alert Popup
    Then user select marktype radio button
    Then user select either percent or flat toggle
    Then user enter local taxes
    Then check for Fare Details total amounts calculation

    Examples: 
      | SheetName | RowNumber |
      |         0 |        12 |


  Scenario Outline: TC_14 "Half-Round-Trip" refundable Price range and  Add Mark up in percenatge and local_taxes
    Given User is on dbtravel Landing page with the "uatb2b" environment
    When User SighnIn with username and password for "uatb2b"
    Then User select the trip and pass origin and destination from given sheetName <SheetName> and rowNumber <RowNumber>
    Then select the date for trip
    Then User select the passenger for trip
    Then select the class for trip
    And User clicks on the search button for flight
    Then user apply pricerange filters
    Then select the Flight and click on book
    Then User handel the Price Change Alert Popup
    Then user select marktype radio button
    Then user select either percent or flat toggle
    Then user enter local taxes
    Then check for Fare Details total amounts calculation

    Examples: 
      | SheetName | RowNumber |
      |         0 |        13 |


    Scenario Outline: TC_15 "Multicity" refundable Stops filter and  Add Markdown in flatType and local_taxes
    Given User is on dbtravel Landing page with the "uatb2b" environment
    When User SighnIn with username and password for "uatb2b"
    Then User select the trip and pass origin and destination from given sheetName <SheetName> and rowNumber <RowNumber>
    Then select the date for trip
    Then User select the passenger for trip
    Then select the class for trip
    And User clicks on the search button for flight
    Then user select search filter number of stops
    Then select the Flight and click on book
    Then User handel the Price Change Alert Popup
    Then user select marktype radio button
    Then user select either percent or flat toggle
    Then user enter local taxes
    Then check for Fare Details total amounts calculation

    Examples: 
      | SheetName | RowNumber |
      |         0 |        14 |


    Scenario Outline: TC_16 "One way" Non Refundable RBD class Advanced Search ( can select multiple rbd ) and add Mark up in percenatge and local_taxes
    Given User is on dbtravel Landing page with the "uatb2b" environment
    When User SighnIn with username and password for "uatb2b"
    And User select the Advanced Search option
    Then User select the trip and pass origin and destination from given sheetName <SheetName> and rowNumber <RowNumber>
    Then select the date for trip
    Then User select the RBD classes
    Then User select the passenger for trip
    And User clicks on the search button for flight
    Then select the Flight and click on book
    Then User handel the Price Change Alert Popup
    Then user select marktype radio button
    Then user select either percent or flat toggle
    Then user enter local taxes
    Then check for Fare Details total amounts calculation

    Examples: 
      | SheetName | RowNumber |
      |         0 |        15 |
      


    Scenario Outline: TC_17 "One way" Non Refundable  Advanced Search Cabin class  ( can select different cabin class and add Add Mark up in Flat typeAdd local Taxes
    Given User is on dbtravel Landing page with the "uatb2b" environment
    When User SighnIn with username and password for "uatb2b"
    And User select the Advanced Search option
    Then User select the trip and pass origin and destination from given sheetName <SheetName> and rowNumber <RowNumber>
    Then select the date for trip
    Then User select the Cabin classes
    Then User select the passenger for trip
    And User clicks on the search button for flight
    Then select the Flight and click on book
    Then User handel the Price Change Alert Popup
    Then user select marktype radio button
    Then user select either percent or flat toggle
    Then user enter local taxes
    Then check for Fare Details total amounts calculation

    Examples: 
      | SheetName | RowNumber |
      |         0 |        16 |


    Scenario Outline: TC_18 "One way" Non Refundable  Advanced Search Supplier name and Add Mark down in percentage Add local Taxes
    Given User is on dbtravel Landing page with the "uatb2b" environment
    When User SighnIn with username and password for "uatb2b"
    And User select the Advanced Search option
    Then User select the trip and pass origin and destination from given sheetName <SheetName> and rowNumber <RowNumber>
    Then select the date for trip
    Then User select the Supplier name
    Then User select the passenger for trip
    And User clicks on the search button for flight
    Then select the Flight and click on book
    Then User handel the Price Change Alert Popup
    Then user select marktype radio button
    Then user select either percent or flat toggle
    Then user enter local taxes
    Then check for Fare Details total amounts calculation

    Examples: 
      | SheetName | RowNumber |
      |         0 |        17 |


    Scenario Outline: TC_19 "One way" Non Refundable  Advanced Search Depature Time and Add Mark down in Fixed type Add local Taxes
    Given User is on dbtravel Landing page with the "uatb2b" environment
    When User SighnIn with username and password for "uatb2b"
    And User select the Advanced Search option
    Then User select the trip and pass origin and destination from given sheetName <SheetName> and rowNumber <RowNumber>
    Then select the date for trip
    Then User select the Depature Time
    Then User select the passenger for trip
    And User clicks on the search button for flight
    Then select the Flight and click on book
    Then User handel the Price Change Alert Popup
    Then user select marktype radio button
    Then user select either percent or flat toggle
    Then user enter local taxes
    Then check for Fare Details total amounts calculation

    Examples: 
      | SheetName | RowNumber |
      |         0 |        18 |


    Scenario Outline: TC_20 "Round trip" Non Refundable  Advanced Search RBD class ( can select multiple rbd ) and Add Mark up in percentage Add local taxes
    Given User is on dbtravel Landing page with the "uatb2b" environment
    When User SighnIn with username and password for "uatb2b"
    And User select the Advanced Search option
    Then User select the trip and pass origin and destination from given sheetName <SheetName> and rowNumber <RowNumber>
    Then select the date for trip
    Then User select the RBD classes
    Then User select the passenger for trip
    And User clicks on the search button for flight
    Then select the Flight and click on book
    Then User handel the Price Change Alert Popup
    Then user select marktype radio button
    Then user select either percent or flat toggle
    Then user enter local taxes
    Then check for Fare Details total amounts calculation

    Examples: 
      | SheetName | RowNumber |
      |         0 |        19 |


    Scenario Outline: TC_21 "Round trip" Non Refundable  Advanced Search Cabin class and Add Mark up in Fixed type Add local Taxes
    Given User is on dbtravel Landing page with the "uatb2b" environment
    When User SighnIn with username and password for "uatb2b"
    And User select the Advanced Search option
    Then User select the trip and pass origin and destination from given sheetName <SheetName> and rowNumber <RowNumber>
    Then select the date for trip
    Then User select the Cabin classes
    Then User select the passenger for trip
    And User clicks on the search button for flight
    Then select the Flight and click on book
    Then User handel the Price Change Alert Popup
    Then user select marktype radio button
    Then user select either percent or flat toggle
    Then user enter local taxes
    Then check for Fare Details total amounts calculation

    Examples: 
      | SheetName | RowNumber |
      |         0 |        20 |


    Scenario Outline: TC_22 "Round trip" Non Refundable  Advanced Search Supplier name , Departure time and Add Mark down in percentage Add local Taxes
    Given User is on dbtravel Landing page with the "uatb2b" environment
    When User SighnIn with username and password for "uatb2b"
    And User select the Advanced Search option
    Then User select the trip and pass origin and destination from given sheetName <SheetName> and rowNumber <RowNumber>
    Then select the date for trip
    Then User select the Depature Time
    Then User select the Supplier name
    Then User select the passenger for trip
    And User clicks on the search button for flight
    Then select the Flight and click on book
    Then User handel the Price Change Alert Popup
    Then user select marktype radio button
    Then user select either percent or flat toggle
    Then user enter local taxes
    Then check for Fare Details total amounts calculation

    Examples: 
      | SheetName | RowNumber |
      |         0 |        21 |


    Scenario Outline: TC_23 "Half round trip" Non Refundable  Advanced Search RBD class ( can select multiple rbd )Supplier name , Departure time and Add Mark down in Fixed type Add local Taxes
    Given User is on dbtravel Landing page with the "uatb2b" environment
    When User SighnIn with username and password for "uatb2b"
    And User select the Advanced Search option
    Then User select the trip and pass origin and destination from given sheetName <SheetName> and rowNumber <RowNumber>
    Then select the date for trip
    Then User select the RBD classes
    Then User select the passenger for trip
    And User clicks on the search button for flight
    Then select the Flight and click on book
    Then User handel the Price Change Alert Popup
    Then user select marktype radio button
    Then user select either percent or flat toggle
    Then user enter local taxes
    Then check for Fare Details total amounts calculation

    Examples: 
      | SheetName | RowNumber |
      |         0 |        22 |


  Scenario Outline: TC_24 "Half round trip" Non Refundable  Advanced Search Cabin class  ( can select different cabin class and Add Mark up in percentage Add local taxes
    Given User is on dbtravel Landing page with the "uatb2b" environment
    When User SighnIn with username and password for "uatb2b"
    And User select the Advanced Search option
    Then User select the trip and pass origin and destination from given sheetName <SheetName> and rowNumber <RowNumber>
    Then select the date for trip
    Then User select the Cabin classes
    Then User select the passenger for trip
    And User clicks on the search button for flight
    Then select the Flight and click on book
    Then User handel the Price Change Alert Popup
    Then user select marktype radio button
    Then user select either percent or flat toggle
    Then user enter local taxes
    Then check for Fare Details total amounts calculation

    Examples: 
      | SheetName | RowNumber |
      |         0 |        23 |


    Scenario Outline: TC_25 "Multicity" Non Refundable  Advanced Search Cabin class  ( can select different cabin class and Add Mark down in Fixed type Add local Taxes
    Given User is on dbtravel Landing page with the "uatb2b" environment
    When User SighnIn with username and password for "uatb2b"
    And User select the Advanced Search option
    Then User select the trip and pass origin and destination from given sheetName <SheetName> and rowNumber <RowNumber>
    Then select the date for trip
    Then User select the Cabin classes
    Then User select the passenger for trip
    And User clicks on the search button for flight
    Then select the Flight and click on book
    Then User handel the Price Change Alert Popup
    Then user select marktype radio button
    Then user select either percent or flat toggle
    Then user enter local taxes
    Then check for Fare Details total amounts calculation

    Examples: 
      | SheetName | RowNumber |
      |         0 |        24 |


    Scenario Outline: TC_26 "One way" Non Refundable  Advanced Search and Add Mark down in percentage Add local Taxes
    Given User is on dbtravel Landing page with the "uatb2b" environment
    When User SighnIn with username and password for "uatb2b"
    And User select the Advanced Search option
    Then User select the trip and pass origin and destination from given sheetName <SheetName> and rowNumber <RowNumber>
    Then select the date for trip
    Then User select the Depature Time
    Then User select the Supplier name
    Then User select the Cabin classes
    Then User select the RBD classes
    Then User select the passenger for trip
    And User clicks on the search button for flight
    Then select the Flight and click on book
    Then User handel the Price Change Alert Popup
    Then user select marktype radio button
    Then user select either percent or flat toggle
    Then user enter local taxes
    Then check for Fare Details total amounts calculation

    Examples: 
      | SheetName | RowNumber |
      |         0 |        25 |


    Scenario Outline: TC_27 "Round trip" Non Refundable  Advanced Search all and Add Mark down in percentage Add local Taxes
    Given User is on dbtravel Landing page with the "uatb2b" environment
    When User SighnIn with username and password for "uatb2b"
    And User select the Advanced Search option
    Then User select the trip and pass origin and destination from given sheetName <SheetName> and rowNumber <RowNumber>
    Then select the date for trip
    Then User select the Depature Time
    Then User select the Supplier name
    Then User select the Cabin classes
    Then User select the RBD classes
    Then User select the passenger for trip
    And User clicks on the search button for flight
    Then select the Flight and click on book
    Then User handel the Price Change Alert Popup
    Then user select marktype radio button
    Then user select either percent or flat toggle
    Then user enter local taxes
    Then check for Fare Details total amounts calculation

    Examples: 
      | SheetName | RowNumber |
      |         0 |        26 |
