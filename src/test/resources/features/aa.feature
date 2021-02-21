Feature: aaa
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
