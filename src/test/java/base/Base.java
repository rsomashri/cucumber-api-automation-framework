package base;

import client.RestClient;
import io.restassured.response.Response;
import utils.TestProperties;

public abstract class Base {

    public TestProperties prop;

    public RestClient restClient;

    public Response response;


}
