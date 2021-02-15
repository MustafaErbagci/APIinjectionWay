Feature: Retrieving a weather information for Locations

  Scenario Outline: I verify the location search payload matches with the schema expected
    Given accept type is application-json
    When I send a GET request to location Search web service to retrieve weather info for "<cityName>"
    Then I verify the statusCode is 200
    And I verify the Content Type is "application/json"
    And  I verify the location search payload matches with the jsonSchema

    Examples:
      | cityName   |
      | Nottingham |
      | London     |
      | Bristol    |

  Scenario Outline: Verifying if the woeid ID of <cityName> is retrieved correctly
    Given accept type is application-json
    When I send a GET request to location Search web service to retrieve weather info for "<cityName>"
    Then I verify the statusCode is 200
    And  I verify the payload belongs to "<cityName>"
    Examples:
      | cityName   |
      | Nottingham |
      | nottingham |
      | NOtTInGHAM |
      | London     |
      | Bristol    |
      | Swansea    |

#    defect
  Scenario Outline: I verify the location Search endpoint work as expected with invalid inputs which is <invalidCityName>
    Given accept type is application-json
    When I send a GET request to location Search web service to retrieve weather info for "<invalidCityName>"
    Then I verify the statusCode is NOT 200
    Examples:
      | invalidCityName |
      | 1236 nottingham |
      | London1236      |
      | Anottingham     |
      | sdfasdfasf      |
      |                 |
      | ...             |
      | asdf            |


  Scenario Outline:  Verifying if the location Search payload members are correct
    When I send a GET request to location Search web service to retrieve weather info for "<cityName>"
    Then  I verify the statusCode is 200
    And I verify if the payload has those items
      | location_type |
      | title         |
      | woeid         |
      | latt_long     |

    Examples:
      | cityName   |
      | Nottingham |
      | London     |
      | Bristol    |
      | Swansea    |

#  ---------------

  Scenario Outline: Verifying if the location response matches with the  LocationJsonSchema for <cityName>
    Given accept type is application-json
    And   I send a GET request to Location web service for "<cityName>"
    Then  I verify the statusCode is 200
    And   I verify the Content Type is "application/json"
    And   I verify the location response matches with the LocationJsonSchema
    Examples:
      | cityName   |
      | Nottingham |
      | Birmingham |
      | London     |
      | Liverpool  |

  Scenario Outline:Verifying if the location payload matches with the Schema for <cityName> and <date>
    When  I send a GET request to Location web service for "<cityName>" and the date of "<date>"
    Then  I verify the statusCode is 200
    And   I verify the Content Type is "application/json"
    And   I verify the location response matches with the LocationJsonSchema
    Examples:
      | cityName   | date       |
      | Nottingham | 2021/02/14 |
      | London     | 2019/02/14 |
      | Liverpool  | 2021/03/24 |
      | Worcester  | 2018/12/14 |

  Scenario Outline: Verifying if the Location response correct for <cityName>>
    Given accept type is application-json
    When  I send a GET request to Location web service for "<cityName>"
    Then  I verify the statusCode is 200
    Then  I verify Location response correct for "<cityName>"
    Examples:
      | cityName      |
      | Nottingham    |
      | birmingham    |
      | London        |
      | Liverpool     |
      | Ankara        |
      | San Francisco |
      | san Francisco |

  Scenario Outline: Verifying if the Location endpoint works as expected with invalid woeid numbers
    Given accept type is application-json
    When  I send a GET request to Location web service with woeid number for "<woeid>"
    Then  I verify the statusCode is NOT 200
    Examples:
      | woeid       |
      | asAAdf      |
      | ........    |
      | 133dfasf    |
      | 9999999999  |
      | 123445      |
      | 66666666666 |
      | 01          |
      | 0           |
      | 00          |
      | 3214        |
      | AAAA        |


  Scenario Outline: Verifying if the Location response headers have headers for <cityName>>
    Given accept type is application-json
    When  I send a GET request to Location web service for "<cityName>"
    Then  I verify the statusCode is 200
    Then I verify if the headers have the header which is "<header>"
    Examples:
      | cityName   | header       |
      | Nottingham | Date         |
      | London     | Content-Type |
      | Bristol    | Server       |

# at postman status code is 200  ??????????????????????
  Scenario Outline: I should not be able to send <requestType> request to Location Search End Point without authentication
    Given I send "<requestType>"  to location Search endpoint without authentication for "<cityName>"
    Then I verify the status code should be 405
    Examples:
      | requestType | cityName   |
      | post        | nottingham |
      | put         | London     |
      | patch       | Birmingham |
      | delete      | Liverpool  |
      | delete      | ...        |
      | delete      | ...1236    |


  Scenario Outline: I should not be able to send <requestType> to Location end point without authentication
    Given I send "<requestType>" request to location endpoint for "<cityName>" without authentication
    Then I verify the status code should be 405

    Examples:
      | requestType | cityName   |
      | post        | nottingham |
      | post        | London     |
      | post        | Birmingham |
      | put         | nottingham |
      | patch       | London     |
      | put         | Birmingham |
      | delete      | Liverpool  |


    Scenario Outline: Verifying I retrieve latt-long info correctly
      Then I send a GET request to Location web service for "<cityName>" 's latLong
      And I verify the statusCode is 200
      Then I verify the response has "<cityName>" 's informations

      Examples:
        | cityName      |
        | Nottingham    |
        | birmingham    |
        | London        |
        | Liverpool     |

  Scenario Outline: Verifying I retrieve distance keyword in latt-long payload
    Then I send a GET request to Location web service for "<cityName>" 's latLong
    And I verify the statusCode is 200
    Then I verify the response has "distance" key value

    Examples:
      | cityName      |
      | Nottingham    |
      | birmingham    |
      | London        |
      | Liverpool     |

  Scenario Outline: Verifying I retrieve distance as 0 in latt-long payload for <cityName>
    Then I send a GET request to Location web service for "<cityName>" 's latLong
    And I verify the statusCode is 200
    Then I verify the response has distance value is 0 for the city

    Examples:
      | cityName      |
      | Nottingham    |
      | birmingham    |
      | London        |
      | Liverpool     |

  Scenario Outline: Verifying if the lat-long payload matches with the LatLongJsonSchema
    Then I send a GET request to Location web service for "<cityName>" 's latLong
    And I verify the statusCode is 200
    Then I verify the latt-long search payload matches with the LatLongJSonSchema

    Examples:
      | cityName      |
      | Nottingham    |
      | birmingham    |
      | London        |
      | Liverpool     |
#defecet
  Scenario: Verify the location search body content type is XML
    And accept type is xml
    When I send a GET request to location Search web service to retrieve weather info for "London"
    Then  I verify the Content Type is "application/xml"
#defect
  Scenario: Verify the location search body content type is HTML
    Given accept type is HTML
    When I send a GET request to location Search web service to retrieve weather info for "London"
    Then  I verify the Content Type is "application/xml"





