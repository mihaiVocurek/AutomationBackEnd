package backend.services;

import backend.ResponseCodes;
import backend.client.RestClient;
import backend.endpoints.Endpoints;
import io.restassured.response.Response;
import org.testng.Assert;

public class BookStoreService {

    private final RestClient restClient;

    public BookStoreService(String baseUri){
        this.restClient = new RestClient(baseUri);
    }

    public void validateResponse(Response response, int expectedStatus, String expectedStatusLine){
        System.out.println(response.getStatusLine());
        response.getBody().prettyPrint();
        Assert.assertEquals(response.getStatusCode(),expectedStatus);
        Assert.assertTrue(response.getStatusLine().contains(expectedStatusLine));
    }

    public void getAllBooks(){

        Response response = restClient.getRequestSpecification().get(Endpoints.GET_ALL_BOOKS);
        System.out.println(response.getStatusLine());
        response.getBody().prettyPrint();

        validateResponse(response, ResponseCodes.OK, ResponseCodes.OK_LINE);
    }
}