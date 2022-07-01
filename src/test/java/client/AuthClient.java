package client;

import base.Base;
import io.restassured.RestAssured;

import io.restassured.specification.RequestSpecification;
import utils.ManageProperties;


public class AuthClient extends Base {
    String access_token;

    public String authClient() {
        properties = ManageProperties.loadProperties();
        response = RestAssured.given().auth().preemptive().basic(properties.getApiKeys(), properties.getApiSecretKey()).post(properties.getAuthUrl());
        access_token = response.jsonPath().getString("access_token");
        return access_token;
    }

    public RequestSpecification oAuthClientSetup() {
        properties = ManageProperties.loadProperties();
        request = RestAssured.given().auth().
                oauth(properties.getApiKeys(), properties.getApiSecretKey(),
                        properties.getAccessToken(), properties.getAccessSecret()).header("Content-Type", "application/json").log().all();
        return request;

    }

}
