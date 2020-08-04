package com.restassur.base;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class RestBasic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		RequestSpecification spec = RestAssured.given();
//		Response response =	spec.get("https://www.google.com");
//		response.prettyPrint();
//		ValidatableResponse vr = response.then();
//					vr.statusCode(200);
		RestAssured.given()
					.expect()
					.statusCode(200)
					.when()
					.get("https://www.google.com");
		
		RestAssured.given()
		.when()
		.get("https://www.google.com")
		.then()
		.statusCode(200);
		
		
					
		

	}
	@Test
	void te() {
		
		Response re =
		RestAssured.given()
		.queryParam("statuscode", "200")
		.when()
		.get("https://www.google.com");
		
		re.prettyPrint();
		
		
	}
	
	@Test
	void te1() {
		
		Response re =
		RestAssured.given()
		.pathParam("id", 2)
		.when()
		.get("https://www.google.com");
		
		re.prettyPrint();
		
		
	}
	
	@Test
	void post1() {
		
		String payload ="string";
		RestAssured.given()
		.when()
		.contentType(ContentType.JSON)
		.when()
		.body(payload)
		.post()
		.then()
		.statusCode(201);
		
		
		
	}

}
