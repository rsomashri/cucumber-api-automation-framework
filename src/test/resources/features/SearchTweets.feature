Feature: To search latest tweets for a user and validate if the tweets exists using GET endpoint

  Scenario Outline: This is to validate if the tweets is fetched using the GET endpoint
    Given User has an valid token
    When User makes a request with "<endpoint>" for the "<id>"
    Then Use validated that the response matching "<user_id>"
    Examples:
      | endpoint                | id              | user_id             |
      | /2/tweets/search/recent | from:twitterdev | 1541512325479268353 |

