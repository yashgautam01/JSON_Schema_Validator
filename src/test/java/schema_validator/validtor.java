package schema_validator;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.testng.annotations.Test;

public class validtor {

    @Test
    public void get() {
    	System.out.println(getClass().getClassLoader().getResource("json_schema/schema.json"));

        given()
            .when()
            .get("http://localhost:3000/users") // Replace with your API URL
            .then()
            .assertThat()
            .body(matchesJsonSchemaInClasspath("json_schema/schema.json"))
            .statusCode(200)
            .log().all();
    }
}
