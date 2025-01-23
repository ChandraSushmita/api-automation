package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BPIVerificationTest {

    @Test
    public void verifyBPIResponse() {
        // Send GET request to the endpoint
        Response response = RestAssured
                .given()
                .get("https://api.coindesk.com/v1/bpi/currentprice.json");

        // Verify the response status code
        Assert.assertEquals(response.statusCode(), 200, "Expected status code 200");

        // Parse the response JSON
        String responseBody = response.getBody().asString();
        System.out.println("Response Body: " + responseBody);

        // Verify there are 3 BPIs (USD, GBP, EUR)
        Assert.assertTrue(responseBody.contains("USD"), "Response should contain USD");
        Assert.assertTrue(responseBody.contains("GBP"), "Response should contain GBP");
        Assert.assertTrue(responseBody.contains("EUR"), "Response should contain EUR");

        // Verify GBP description equals 'British Pound Sterling'
        String gbpDescription = response.jsonPath().getString("bpi.GBP.description");
        Assert.assertEquals(gbpDescription, "British Pound Sterling", "GBP description mismatch");
    }
}
