package steps;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import lombok.SneakyThrows;
import model.HistoricPrice;
import model.PriceStatistics;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.NoSuchElementException;
import java.util.Objects;

import static org.apache.http.HttpStatus.SC_OK;

public class NyseSteps {

    private static final String STATISTICS_URI = "https://testathon-service.herokuapp.com/api/v2/stocks/data";

    @SneakyThrows
    public static void sendStockData(PriceStatistics priceStatistics) {
        ObjectMapper objectMapper = new ObjectMapper();
        Double maxClosingPrice = priceStatistics.getStockData().stream()
                .map(HistoricPrice::getValue)
                .mapToDouble(Double::valueOf)
                .max().orElseThrow(NoSuchElementException::new);
        priceStatistics.setHighestClosingPrice(String.valueOf(maxClosingPrice));
        byte[] statisticsJson = objectMapper.writeValueAsBytes(priceStatistics);
        RestAssured.given()
                .multiPart("file", "statistics.json", statisticsJson, "application/json")
                .post(STATISTICS_URI).prettyPeek()
                .then().assertThat().statusCode(SC_OK);
    }

    @SneakyThrows
    public static void sendMockStockData() {
        String path = Objects.requireNonNull(NyseSteps.class.getResource("/sample.json")).getPath();
        byte[] statisticsJson = Files.readAllBytes(Path.of(path));
        RestAssured.given()
                .multiPart("file", statisticsJson, "application/json")
                .post(STATISTICS_URI).prettyPeek()
                .then().assertThat().statusCode(SC_OK);
    }
}
