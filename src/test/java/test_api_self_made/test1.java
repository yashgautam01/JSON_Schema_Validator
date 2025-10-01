package test_api_self_made;
import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class test1 {
	@Test
	public void get() {
		given()
			.header("Content-Type","Application/json")
		.when()
			.get("http://localhost:3000/users")
		.then()
			.statusCode(200).log().all();
		
	}
	@Test
	public void post() {
		JSONObject obj = new JSONObject();
		
		obj.put("name", "yash");
		
		
		
		
		
		given().header("Content-Type","Application/json").body(obj.toString())
		.when().post("http://localhost:3000/users")
		.then().statusCode(201).log().all();
		
	}
	@Test
	public void put() {
		JSONObject obj  = new JSONObject();
		obj.put("name", "ram");
		given().header("Content-Type","Application/json").contentType(ContentType.JSON).accept(ContentType.JSON).body(obj.toString())
		.when().patch("http://localhost:3000/users/5")
		.then().statusCode(200).log().all();
	}
	@Test
	public void delete() {
		given().when().delete("http://localhost:3000/users/b5bc")
		.then().statusCode(200).log().all();
	}
	

}
