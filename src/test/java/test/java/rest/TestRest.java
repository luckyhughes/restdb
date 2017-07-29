package test.java.rest;

import static org.junit.Assert.*;

import org.json.JSONObject;
import org.junit.*;
import static com.jayway.restassured.RestAssured.*;

public class TestRest {
	private String myjsonString;

	@Test
	public void TC1() {

		int respCode = given().contentType("application/json").when()
				.get("http://localhost:8080/person/search?firstName=Shanaya").then().extract().statusCode();
		assertEquals(200, respCode);
	}

	@Test
	public void TC2() {

		JSONObject myObj = new JSONObject();

		myObj.put("firstName", "Anisha");
		myObj.put("lastName", "Garg");
		given().contentType("application/json").body(myjsonString).when().post("/person").then().extract().statusCode();
		String response = given().contentType("application/json").body(myjsonString).when().post("/person").then()
				.extract().asString();
		assertEquals(myjsonString, response);
	}

	@Test
	public void TC3(){
		
		  given().contentType("application/json").body(myjsonString).when().get("http://localhost:8080/person/count").
		then().assertThat().statusCode(200);
		
	}
	
	@Test
	public void TC4(){
		given().contentType("application/json").body(myjsonString).when()
		.get("http://localhost:8080/person/{personid}").getStatusCode();
	}
}