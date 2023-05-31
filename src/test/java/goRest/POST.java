package goRest;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.json.JSONObject;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class POST {
	public int res;

	@Test
	public void postUser() {

		Faker fake = new Faker();
		
		JSONObject hm = new JSONObject();
		hm.put("name",fake.name());
		hm.put("gender","Male");
		hm.put("email",fake.internet().emailAddress());
		hm.put("status","Active");
		
		String BearerToken="f7efb7d9775f3e00e2f2715d847a052047a9dbe8300464ca4279a9544c8abc4a";
		
	res =given()
				.headers("Authorization","Bearer "+BearerToken)
				.contentType("application/json")
				.body(hm.toString())
			
			.when()
				.post("https://gorest.co.in/public/v2/users")
				.jsonPath().getInt("id");
	
		System.out.println(res);
	}
	}

