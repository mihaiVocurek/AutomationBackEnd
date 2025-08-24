package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteUserTest {

    @Test
    public void testMethod(){

        System.out.println("=== Step 1: Create user ===");

        RequestSpecification request = RestAssured.given();
        request.baseUri("https://demoqa.com");
        request.header("Content-Type", "application/json");

        JSONObject requestBody = new JSONObject();
        requestBody.put("userName","MihaiTesting" + System.currentTimeMillis());
        requestBody.put("password", "Parola123!");

        request.body(requestBody.toString());

        Response response = request.post("/Account/v1/User");
        System.out.println(response.getStatusLine());
        response.getBody().prettyPrint();

        Assert.assertEquals(response.getStatusCode(), 201);
        Assert.assertTrue(response.getStatusLine().contains("Created"));

        String userId = response.path("userID");


        System.out.println("=== Step 2: Generate token ===");
        response = request.post("/Account/v1/GenerateToken");

        System.out.println(response.getStatusLine());
        response.getBody().prettyPrint();

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(response.getStatusLine().contains("OK"));

        String token = response.path("token");


        System.out.println("=== Step 3: Get user ===");
        request.header("Authorization", "Bearer " + token);
        response = request.get("/Account/v1/User/" + userId);

        System.out.println(response.getStatusLine());
        response.getBody().prettyPrint();

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(response.getStatusLine().contains("OK"));


        System.out.println("=== Step 4: Delete user ===");
        response = request.delete("/Account/v1/User/" + userId);

        System.out.println(response.getStatusLine());
        response.getBody().prettyPrint();

        Assert.assertEquals(response.getStatusCode(), 204);
        Assert.assertTrue(response.getStatusLine().contains("No Content"));

    }

}