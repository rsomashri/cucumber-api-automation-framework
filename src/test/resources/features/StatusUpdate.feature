@Sanity
Feature: Updates the authenticating user's current status, also known as Tweeting.

  Scenario Outline: This is to validate the status update tweet is using post endpoint
    Given User has created a request with oAuth keys
    When User makes a post request with "<endpoint>" and "<requestbody>"
    Then Use validated that the response matching  "<responsebody>"
    Examples:
      | endpoint | requestbody         |responsebody|
      | /2/tweets | tweetRequest.json | tweetResponse.json |
