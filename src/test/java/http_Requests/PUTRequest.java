package http_Requests;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

public class PUTRequest 
{
	@Test
	public void putRequest()
	{
		HashMap<String,String> hm = new HashMap<String, String>();
		hm.put("name","Anjali(Pandu)");
		hm.put("location","ESI");
		hm.put("role", "Chatted Accountant");
		
		given()
		.contentType("application/json")
		.body(hm)
		.when()
		.put("http://localhost:3000/students/4")
		.then()
		.statusCode(200)
		.log().all();
	}
}
