package stepDefinition;


import base.Base;
import client.AuthClient;
import client.RestClient;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;


public class SearchTweets extends Base {
    AuthClient client;
    String token;
    @Given("User has an valid token")
    public void authorizeUser(){
        client = new AuthClient();
        this.token= client.authClient();
       restClient= new RestClient(token);
    }
    @When("User makes a request with {string} for the {string}")
    public void searchLatestTweets(String endpoint, String id){
        HashMap<String,String> tweetQueryParam= new HashMap<String,String>();
        tweetQueryParam.put("query",id);
        response=restClient.getWithQueryParams(tweetQueryParam,endpoint);
    }

    @Then("Use validated that the response matching {string}")
    public void useValidatedThatTheResponseMatching(String expectedUser_id) {
       String actual_id =response.jsonPath().getString("data.id[0]");
       Assert.assertTrue(actual_id.equalsIgnoreCase(expectedUser_id));
    }



}
