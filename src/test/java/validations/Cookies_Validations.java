package validations;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Cookies_Validations 
{
	/*
	 * @Test public void getCookies() { given() .contentType("application/json")
	 * .when() .get("https://www.google.com") .then()
	 * .cookie("AEC","AUEFqZeBfHvLUvJfTP4EGEpK5tWDpZecnRjwuzQ53E49bIgQdzRTA0eUeg")//
	 * Cookies will change for every iteration so this case will fail .log().all();
	 * }
	 */

	@Test
	public void getCookiesInfo()
	{
		Response res = given()
				.contentType("application/json")
				.when()
				.get("https://www.google.com");

		//Getting single cookie info
		//		String Cookie_value = res.getCookie("AEC");
		//		System.out.println("Cookie value is : "+Cookie_value);


		//Getting all Cookies Info

		Map<String,String> Cookies_values = res.getCookies();
		//System.out.println(Cookies_values.keySet()); //to get cookies Key values

		for(String k:Cookies_values.keySet())
		{
			String Cookie_value = res.getCookie(k);
			System.out.println(k+" : "+Cookie_value);
		}


	}


}
