package Lesson_9;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static java.util.Collections.emptyMap;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static Lesson_9.Constants.*;

public class PostmanEchoTest extends BaseTest {

    @Test
    public void testGetRequest() {
        given().param(FOO1, BAR1)
                .param(FOO2, BAR2)
                .when()
                .get("/get")
                .then().log().body()
                .spec(responseSpec)
                .and().body("args." + FOO1, equalTo(BAR1))
                .and().body("args." + FOO2, equalTo(BAR2))
                .and().body("url", equalTo(BASE_URL + "/get?" + FOO1 + "=" + BAR1 + "&" + FOO2 + "=" + BAR2));
    }

    @Test
    public void testPostRawText() {
        String requestBody = "{\n    \"test\": \"value\"\n}";

        given().log().body()
                .contentType(CONTENT_TYPE_TEXT).body(requestBody)
                .when()
                .post("/post")
                .then().log().body()
                .spec(responseSpec)
                .body("args", is(emptyMap()))   // Проверяем, что args пустой объект
                .and().body("data", equalTo(requestBody))
                .and().body("files", is(emptyMap()))    // Проверяем, что files пустой объект
                .and().body("form", is(emptyMap()))    // Проверяем, что files пустой объект
                .and().body("headers.content-length", equalTo("23"))
                .and().body("headers.content-type", equalTo(CONTENT_TYPE_TEXT))
                .and().body("json", equalTo(null))
                .and().body("url", equalTo(BASE_URL + "/post"));
    }

    @Test
    public void testPostFormData() {
        String contentTypeFormData = "application/x-www-form-urlencoded; charset=UTF-8";

        given().contentType(contentTypeFormData)
                .formParam(FOO1, BAR1)
                .formParam(FOO2, BAR2)
                .when()
                .post("/post")
                .then().log().body()
                .spec(responseSpec)
                .body("args", is(emptyMap()))   // Проверяем, что args пустой объект
                .and().body("data", is(""))   // Проверяем, что data пустая строка
                .and().body("files", is(emptyMap()))    // Проверяем, что files пустой объект
                .and().body("form." + FOO1, equalTo(BAR1))
                .and().body("form." + FOO2, equalTo(BAR2))
                .and().body("headers.content-length", equalTo("19"))
                .and().body("headers.content-type", equalTo(contentTypeFormData))
                .and().body("json." + FOO1, equalTo(BAR1))
                .and().body("json." + FOO2, equalTo(BAR2))
                .and().body("url", equalTo(BASE_URL + "/post"));
    }

    @Test
    public void testPutRequest() {
        given().log().body()
                .contentType(CONTENT_TYPE_TEXT).body(REQUEST_BODY)
                .when()
                .put("/put")
                .then().log().body()
                .spec(responseSpec)
                .body("args", is(emptyMap()))   // Проверяем, что args пустой объект
                .and().body("data", equalTo(REQUEST_BODY))
                .and().body("files", is(emptyMap()))    // Проверяем, что files пустой объект
                .and().body("form", is(emptyMap()))    // Проверяем, что files пустой объект
                .and().body("headers.content-length", equalTo("58"))
                .and().body("headers.content-type", equalTo(CONTENT_TYPE_TEXT))
                .and().body("json", equalTo(null))
                .and().body("url", equalTo(BASE_URL + "/put"));
    }

    @Test
    public void testPatchRequest() {
        given().log().body()
                .contentType(CONTENT_TYPE_TEXT).body(REQUEST_BODY)
                .when()
                .patch("/patch")
                .then().log().body()
                .spec(responseSpec)
                .body("args", is(emptyMap()))   // Проверяем, что args пустой объект
                .and().body("data", equalTo(REQUEST_BODY))
                .and().body("files", is(emptyMap()))    // Проверяем, что files пустой объект
                .and().body("form", is(emptyMap()))    // Проверяем, что files пустой объект
                .and().body("headers.content-length", equalTo("58"))
                .and().body("headers.content-type", equalTo(CONTENT_TYPE_TEXT))
                .and().body("json", equalTo(null))
                .and().body("url", equalTo(BASE_URL + "/patch"));
    }

    @Test
    public void testDeleteRequest() {
        given().log().body()
                .contentType(CONTENT_TYPE_TEXT).body(REQUEST_BODY)
                .when()
                .delete("/delete")
                .then().log().body()
                .spec(responseSpec)
                .body("args", is(emptyMap()))   // Проверяем, что args пустой объект
                .and().body("data", equalTo(REQUEST_BODY))
                .and().body("files", is(emptyMap()))    // Проверяем, что files пустой объект
                .and().body("form", is(emptyMap()))    // Проверяем, что files пустой объект
                .and().body("headers.content-length", equalTo("58"))
                .and().body("headers.content-type", equalTo(CONTENT_TYPE_TEXT))
                .and().body("json", equalTo(null))
                .and().body("url", equalTo(BASE_URL + "/delete"));
    }
}

