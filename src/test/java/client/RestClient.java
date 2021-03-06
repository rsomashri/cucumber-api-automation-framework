package client;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.ManageProperties;
import utils.TestProperties;

import java.io.File;
import java.util.Map;

public class RestClient {
    TestProperties properties;
    RequestSpecification request;

    Response response;

    public RestClient(String token)
    {
       this.properties= ManageProperties.loadProperties();
        RestAssured.baseURI=properties.getBaseUrl();
        this.request= RestAssured.given();
        setHeaders(token);

    }
    public RestClient(RequestSpecification requestSpecification){
        this.request= requestSpecification;

    }
    public void setHeaders(String token)
    {
        request.header("Authorization","Bearer " + token);
    }
    public Response getWithQueryParams(Map<String, String> parameters,String url){
        response=request.queryParams(parameters).get(url);
        return response;

    }
    public Response postWithJson(String url, File requestFile){
        response= request.body(requestFile).post(url);
    return response;
    }


}
