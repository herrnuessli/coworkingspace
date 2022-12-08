package ch.zli.m223;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import com.google.inject.Inject;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;


import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;

import io.quarkus.test.h2.H2DatabaseTestResource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;


@QuarkusTest
@QuarkusTestResource(H2DatabaseTestResource.class)
@TestMethodOrder(OrderAnnotation.class)

public class ApplicationUserTest {
    @Inject
    IntegrationTestDataService testDataService;
    
    @AfterEach
    public void reloadDatabase() {
    testDataService.reloadDatabase();
    }

    @Test
    @Order(1)
    public void testIndexEndpoint() {
    public void testDeleteEndpoint() {
    given()
        .when().delete("/applicationUsers/" + 1)
        .then()
        .statusCode(204);
    
    given()
        .when().get("/applicationUsers")
        .then()
        .statusCode(200)
        .body("size()", is(2));
    }   

    @Test
    @Order(3)
    public void testIndexEndpointAgainToShowIndependence() {
    given()
      .when().get("/applicationUsers")
      .then()
       .statusCode(200)
       .body("size()", is(3));
    }
}
