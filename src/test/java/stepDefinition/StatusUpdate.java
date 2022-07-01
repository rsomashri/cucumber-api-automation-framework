package stepDefinition;

import base.Base;
import client.AuthClient;
import client.RestClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;
import pojo.TweetResponse;
import utils.Constants;
import utils.ManageProperties;
import utils.TestProperties;

import java.io.File;
import java.io.IOException;

public class StatusUpdate extends Base implements Constants {


    @Given("User has created a request with oAuth keys")
    public void authorizePostStatusTweets() {
        client = new AuthClient();
        this.properties = ManageProperties.loadProperties();
        System.out.println(properties.getBaseUrl());
        this.request = client.oAuthClientSetup().baseUri(properties.getBaseUrl());
    }

    @When("User makes a post request with {string} and {string}")
    public void postStatusTweets(String url, String fileName) {
        restClient = new RestClient(this.request);
        response = restClient.postWithJson(url, this.jsonPayload.getFile(requestPayloadPath + fileName));
    }

    @Then("Use validated that the response matching  {string}")
    public void useValidatedThatTheResponseMatching(String fileName) {
        objectMapper = new ObjectMapper();
        try{
        TweetResponse tweetResponse=objectMapper.readValue(this.jsonPayload.getFile(responsePayloadPath + fileName), TweetResponse.class);

     Assert.assertTrue(tweetResponse.getText().equalsIgnoreCase(response.jsonPath().getString("data.text")));
    } catch (
    IOException e) {
        throw new RuntimeException(e);
    }

    }
}
