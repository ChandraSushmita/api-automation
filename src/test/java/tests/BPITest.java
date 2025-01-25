package tests;

import base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BPITest extends BaseTest {

    @Test
    public void verifyBPIResponse() {
        // Send GET request
        Response response = RestAssured.given().get();

        // Verify status code
        Assert.assertEquals(response.getStatusCode(), 200, "Expected status code is 200");

        // Verify USD, GBP, EUR exist in the response
        Assert.assertTrue(response.getBody().asString().contains("USD"), "Response should contain USD");
        Assert.assertTrue(response.getBody().asString().contains("GBP"), "Response should contain GBP");
        Assert.assertTrue(response.getBody().asString().contains("EUR"), "Response should contain EUR");

        // Verify GBP description
        String gbpDescription = response.jsonPath().getString("bpi.GBP.description");
        Assert.assertEquals(gbpDescription, "British Pound Sterling", "GBP description mismatch");
    }
}
