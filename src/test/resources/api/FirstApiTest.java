package com.epam.testproject.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class FirstApiTest {

    private final Logger log = LogManager.getLogger();

    @Test
    public void restAssuredFirstTest() {
        log.info("First rest assured test run");
        given()
                .when()
                .get("https://github.com/")
                .then()
                .statusCode(200);
    }
}
