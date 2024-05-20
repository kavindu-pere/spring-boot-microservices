package com.codebykavindu.bookstore.orders.web.controllers;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;

import com.codebykavindu.bookstore.orders.AbstractIntegrationTest;
import com.codebykavindu.bookstore.orders.testdata.TestDataFactory;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

/**
 * @author Kavindu Perera
 */
class OrderControllerTests extends AbstractIntegrationTest {

    @Nested
    class CreateOrderTests {
        @Test
        void shouldCreateOrderSuccessfully() {
            var payload =
                    """
                            {
                                "customer" : {
                                    "name": "Kavindu",
                                    "email": "kavindu@gmail.com",
                                    "phone": "999999999"
                                },
                                "deliveryAddress" : {
                                    "addressLine1": "Birkelweg",
                                    "addressLine2": "Hans-Edenhofer-Straße 23",
                                    "city": "Berlin",
                                    "state": "Berlin",
                                    "zipCode": "94258",
                                    "country": "Germany"
                                },
                                "items": [
                                    {
                                        "code": "P100",
                                        "name": "Product 1",
                                        "price": 25.50,
                                        "quantity": 1
                                    }
                                ]
                            }
                    """;

            given().contentType(ContentType.JSON)
                    .body(payload)
                    .when()
                    .post("/api/v1/orders")
                    .then()
                    .statusCode(HttpStatus.CREATED.value())
                    .body("orderNumber", notNullValue());
        }

        @Test
        void shouldReturnBadRequestWhenMandatoryDataIsMissing() {
            var payload = TestDataFactory.createOrderRequestWithInvalidCustomer();
            given().contentType(ContentType.JSON)
                    .body(payload)
                    .when()
                    .post("/api/v1/orders")
                    .then()
                    .statusCode(HttpStatus.BAD_REQUEST.value());
        }
    }
}
