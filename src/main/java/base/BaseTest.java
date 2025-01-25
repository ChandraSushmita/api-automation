package base;

import io.restassured.RestAssured;

public class BaseTest {
    public BaseTest() {
        // Base URL for Rest-Assured
        RestAssured.baseURI = "https://api.coindesk.com/v1/bpi/currentprice.json";
    }
}
