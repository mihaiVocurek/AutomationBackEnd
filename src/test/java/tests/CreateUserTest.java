package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BookStorePage;
import pages.IndexPage;
import sharedData.SharedData;

public class CreateUserTest extends SharedData {

    @Test
    public void testMethod(){

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

        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.interactWithBookStoreApplicationMenu();

        BookStorePage bookStorePage = new BookStorePage(getDriver());
        bookStorePage.interactWithLoginSubmenu();
        bookStorePage.userLogin(requestBody.get("userName").toString(), requestBody.get("password").toString());
    }
}
