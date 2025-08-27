package backend.client;

import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class RestClient {

    private final RequestSpecification requestSpecification;

    public RestClient(String baseUri){
        this.requestSpecification = given()
                .baseUri(baseUri)
                .header("Content-Type", "application/json");
    }

    public RequestSpecification getRequestSpecification(){
        return requestSpecification;
    }

}
