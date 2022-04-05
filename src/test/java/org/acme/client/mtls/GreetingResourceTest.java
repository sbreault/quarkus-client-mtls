package org.acme.client.mtls;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import io.quarkus.test.junit.mockito.InjectMock;


@QuarkusTest
public class GreetingResourceTest {

    @InjectMock
    @RestClient
    GreetingService greetingService;


    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/hello-client")
          .then()
             .statusCode(200)
             .body(is("hello"));
    }

}