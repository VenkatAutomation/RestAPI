package validations;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Iterator;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class Headers_Validations 
{
//	@Test
//	public void testHeaders()
//	{
//		given()
//		.when()
//		.get("https://www.google.com")
//		.then()
//		.header("Content-Type", "text/html; charset=ISO-8859-1")
//		.header("Content-Encoding", "gzip")
//		.header("Server", "gws");
//	}
	
	@Test
	public void getHeaderInfo()
	{
		Response res = given()
		.when()
		.get("https://www.google.com");
		
		//Getting single header info
//		String header_value = res.getHeader("Content-Type");
//		System.out.println(header_value);
		
		
		 Headers header_values = res.getHeaders();
		 //System.out.println(header_values); // getting header info
		
		for(Header h:header_values)
		{
			System.out.println(h.getName()+":"+h.getValue());
		}
		
		
		
		
		
		
		
	}
	
}
