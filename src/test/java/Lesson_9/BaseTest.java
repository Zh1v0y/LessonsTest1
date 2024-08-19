package Lesson_9;

import io.restassured.RestAssured;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static Lesson_9.Constants.BASE_URL;

public class BaseTest {

    protected static ResponseSpecification responseSpec;

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = BASE_URL;

        responseSpec = RestAssured.expect()
                .statusCode(HttpStatus.SC_OK)
                .and().body("headers.host", equalTo("postman-echo.com"))
                .and().body("headers.x-forwarded-proto", equalTo("https"))
                .and().body("headers.x-request-start", notNullValue())
                .and().body("headers.connection", equalTo("close"))
                .and().body("headers.x-forwarded-port", equalTo("443"))
                .and().body("headers.x-amzn-trace-id", notNullValue())
                .and().body("headers.accept", equalTo("*/*"))
                .and().body("headers.user-agent", notNullValue())
                .and().body("headers.accept-encoding", equalTo("gzip,deflate"));
    }

    @AfterAll
    public static void tearDown() {
        RestAssured.reset();
        responseSpec = null;
    }
}

