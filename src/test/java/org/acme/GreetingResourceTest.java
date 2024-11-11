package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.startsWith;

@QuarkusTest
class GreetingResourceTest {
    @Test
    void testNumberResource() {

        RestAssured.given()
                .when().get("/api/numbers")
                .then()
                    .statusCode(200)
                    .contentType("application/json")
                .body("isbn_13", startsWith("13-"));


    }

}