package test_restassur;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

public class httpReq {

	@Test
	void getListUsers() {

		 given()

		.when()
			 .get("https://reqres.in/api/users?page=2")

		.then()
			 .statusCode(200)
			 .body("page", equalTo(2))
			 .log().all();
	}
	
	@Test
	void getSingleUser() {
		
		 given()

		.when()
		     .get("https://reqres.in/api/users/2")

		.then()
		     .statusCode(200)
		     .log().all();		
	}
	
	@Test
	void createUser() {
		
		HashMap data = new HashMap();
		data.put("name", "Rohit");
		data.put("job", "Tester");
		
		 given() 
		      .contentType("application/json")
		      .body(data)
		      
		.when()
		     .post("https://reqres.in/api/users")
		
		.then()
		     .statusCode(201)
		     .log().all();
	}
}
