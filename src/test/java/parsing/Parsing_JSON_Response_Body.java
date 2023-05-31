package parsing;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Parsing_JSON_Response_Body 
{
	@Test
	public void testResponseBody()
	{
		Response res =given()
			.contentType(ContentType.JSON)
			.when()
			.get("http://localhost:3000/Movies");
		
       JSONObject jo = new JSONObject(res.asString());
		
		for (int i = 0; i < jo.getJSONArray("Movies").length(); i++)
		{
			String award_name=jo.getJSONArray("Movies").getJSONObject(i).get("award").toString();
			System.out.println(award_name);
		}
	}
}
