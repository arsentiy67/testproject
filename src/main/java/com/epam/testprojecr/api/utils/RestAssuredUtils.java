package com.epam.testprojecr.api.utils;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;


public class RestAssuredUtils {
    public static final String BASE_URI = "";

    public static void configureRestAssured() {
        RestAssured.baseURI = BASE_URI;
        RestAssured.defaultParser = Parser.JSON;
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    public static ResponseSpecification okResponseSpecification() {
        return new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .expectStatusCode(HttpStatus.SC_OK)
                .build();
    }
}
