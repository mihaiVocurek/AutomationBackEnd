package tests;

import backend.services.AccountService;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import frontend.pages.BookStorePage;
import frontend.pages.IndexPage;
import frontend.sharedData.SharedData;

public class DeleteUserTest extends SharedData {

    @Test
    public void testMethod(){

        /*System.out.println("=== Step 1: Create user ===");

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

        System.out.println("=== Step 5: Get deleted user ===");
        //request.header("Authorization", "Bearer " + token);
        response = request.get("/Account/v1/User/" + userId);

        System.out.println(response.getStatusLine());
        response.getBody().prettyPrint();

        Assert.assertEquals(response.getStatusCode(), 401);
        Assert.assertTrue(response.getStatusLine().contains("Unauthorized"));

        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.interactWithBookStoreApplicationMenu();

        BookStorePage bookStorePage = new BookStorePage(getDriver());
        bookStorePage.interactWithLoginSubmenu();

        bookStorePage.userLogin(requestBody.get("userName").toString(), requestBody.get("password").toString());
        bookStorePage.validateLogin();*/

        AccountService accountService = new AccountService("https://demoqa.com");

        String userName = "MihaiTesting" + System.currentTimeMillis();
        String password = "Parola123!";

        String userId = accountService.createUser(userName,password);
        String token = accountService.generateToken(userName,password);

        accountService.getUser(userId, token);
        accountService.deleteUser(userId, token);
        accountService.getUserUnauthorized(userId);

        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.interactWithBookStoreApplicationMenu();

        BookStorePage bookStorePage = new BookStorePage(getDriver());
        bookStorePage.interactWithLoginSubmenu();

        bookStorePage.userLogin(userName, password);
        bookStorePage.validateLogin();


    }

}