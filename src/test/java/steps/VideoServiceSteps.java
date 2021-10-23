package steps;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import core.dto.VideoResponseDto;
import core.web.iWebElement;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.ResponseSpecification;
import lombok.SneakyThrows;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static steps.YoutubeSteps.navigateToSite;
import static steps.YoutubeSteps.searchText;

public class VideoServiceSteps {
    public static final String LINK_TO_VIDEO = "https://testathon-service.herokuapp.com/api/videos/title";

    public static ResponseSpecification okResponseSpecification() {
        return new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .expectStatusCode(HttpStatus.SC_OK)
                .build();
    }

    public static String getVideoName() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        Response response = given()
                .when()
                .get(LINK_TO_VIDEO);

        response.then()
                .assertThat()
                .spec(okResponseSpecification());

        return getResponseDto(response.getBody().asString()).getTitle();
    }

    @SneakyThrows
    private static VideoResponseDto getResponseDto(String response) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper.readValue(response, VideoResponseDto.class);
    }

    public static void selectVideoByTitle(String title) {
        navigateToSite();
        searchText(title);
    }
}
