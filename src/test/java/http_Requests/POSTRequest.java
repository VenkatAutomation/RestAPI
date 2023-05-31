package http_Requests;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

public class POSTRequest 
{
	@Test
	public void postRequest()
	{
		HashMap<String,Object> hm = new HashMap<String, Object>();
		hm.put("name", "Anjali");
		hm.put("location","ESI");
		hm.put("role","Tester");
		
		given()
		.contentType("application/json")
		.body(hm)
		.when()
		.post("http://localhost:3000/students")
		.then()
		.statusCode(201)
		.log().all();
	}
}