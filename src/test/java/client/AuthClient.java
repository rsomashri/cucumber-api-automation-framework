package client;
import groovy.transform.Final;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import org.junit.Test;
import utils.ManageProperties;
import utils.TestProperties;


public class AuthClient {

     Response resp;
    TestProperties properties;

    String access_token;


    public String authClient() {
       this.properties = ManageProperties.loadProperties();

      resp= RestAssured.given().auth().preemptive().basic(properties.getApiKeys(), properties.getApiSecretKey()).
               post(properties.getAuthUrl());
       access_token= resp.jsonPath().getString("access_token");
        return access_token;
    }

}
