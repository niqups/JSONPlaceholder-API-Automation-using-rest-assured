import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class JSONPlaceholderAPITests {


    static {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    public void testGetRequest() {
        Response response = given()
                .contentType("application/json")
                .when()
                .get("/posts")
                .then()
                .statusCode(200)
                .extract().response();

        System.out.println("GET Response: " + response.asPrettyString());
    }

    @Test
    public void testGetRequestUsingId() {
        Response response = given()
                .contentType("application/json")
                .when()
                .get("/posts/1")
                .then()
                .statusCode(200)
                .extract().response();

        System.out.println("GET Response: " + response.asPrettyString());
    }
    @Test
    public void testGetRequestUsingIdAndComment() {
        Response response = given()
                .contentType("application/json")
                .when()
                .get("/posts/1")
                .then()
                .statusCode(200)
                .extract().response();

        System.out.println("GET Response: " + response.asPrettyString());
    }

    @Test
    public void testGetRequestUsingIdAndCommentAsParameter() {
        Response response = given()
                .contentType("application/json")
                .when()
                .get("/comments?postId=1")
                .then()
                .statusCode(200)
                .extract().response();

        System.out.println("GET Response: " + response.asPrettyString());
    }


    @Test
    public void testPostRequest() {
        Response response = given()
                .contentType("application/json")
                .body("{\"title\": \"foo\", \"body\": \"bar\", \"userId\": 1}")
                .when()
                .post("/posts")
                .then()
                .statusCode(201)
                .extract().response();

        System.out.println("POST Response: " + response.asPrettyString());
    }

    @Test
    public void testPutRequest() {
        Response response = given()
                .contentType("application/json")
                .body("{\"id\":1,\"title\": \"foo\", \"body\": \"bar\", \"userId\": 1}")
                .when()
                .put("/posts/1")
                .then()
                .statusCode(200)
                .extract().response();

        System.out.println("PUT Response: " + response.asPrettyString());
    }

    @Test
    public void testPatchRequest() {
        Response response = given()
                .contentType("application/json")
                .body("{\"title\": \"foo\"}")
                .when()
                .patch("/posts/1")
                .then()
                .statusCode(200)
                .extract().response();

        System.out.println("PATCH Response: " + response.asPrettyString());
    }

    @Test
    public void testDeleteRequest() {
        Response response = given()
                .contentType("application/json")
                .when()
                .delete("/posts/1")
                .then()
                .statusCode(200)
                .extract().response();

        System.out.println("DELETE Response: " + response.asPrettyString());
    }


}

