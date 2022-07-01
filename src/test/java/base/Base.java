package base;

import client.AuthClient;
import client.RestClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.ManageJsonPayload;
import utils.TestProperties;

public abstract class Base {


    public  static RestClient restClient;

    public static Response response;

    public static TestProperties properties;

    public static RequestSpecification request;

    public static AuthClient client;

    public static ManageJsonPayload jsonPayload;

    public static ObjectMapper objectMapper;


}
