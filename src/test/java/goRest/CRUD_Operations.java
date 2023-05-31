package goRest;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.response.Response;


public class CRUD_Operations 
{
	public  int res;
	
	@Test(priority = 1)
	public void postUser()
	{
		HashMap<String,String> hm = new HashMap<String, String>();
		hm.put("name","Venkat");
		hm.put("gender","Male");
		hm.put("email","Venkat@gmail.com");
		hm.put("status","Active");
		
		String BearerToken="f7efb7d9775f3e00e2f2715d847a052047a9dbe8300464ca4279a9544c8abc4a";
		
		res =given()
				.headers("Authorization","Bearer "+BearerToken)
			.contentType("application/json")
//			.pathParam("mypath","public/v2")
//			.pathParam("mypath1","/users")
			.body(hm)
			.when()
			.post("https://gorest.co.in/public/v2/users")
			.jsonPath().getInt("id");	
	}
	
	@Test(priority = 2)
	public void getUser()
	{
		given()
			.auth().oauth2("f7efb7d9775f3e00e2f2715d847a052047a9dbe8300464ca4279a9544c8abc4a")
//			.pathParam("mypath","public/v2")
//			.pathParam("mypath1","/users")
//			.queryParam("querypath1"+"/"+res)
			.when()
			.get("https://gorest.co.in/public/v2/users/"+res)
			.then()
			.log().all();
	}
	
	@Test(priority = 3)
	public void putUser()
	{
		HashMap<String,String> hm = new HashMap<String, String>();
		hm.put("name","VenkatRamana");
		hm.put("gender","Male");
		hm.put("email","venkat123@gmail.com");
		hm.put("status","Active");
		
		given()
			.auth().oauth2("f7efb7d9775f3e00e2f2715d847a052047a9dbe8300464ca4279a9544c8abc4a")
			.body(hm)
			
//			.pathParam("mypath","public/v2")
//			.pathParam("mypath1","/users")
//			.queryParam("querypath1"+"/"+res)
			
			.when()
			.put("public/v2/users/"+res)
			.then()
			.assertThat().statusCode(200)
			.body("name",equalTo("VenkatRamana"))
			.body("gender",equalTo("Male"))
			.body("email",equalTo("venkat123@gmail.com"))
			.body("status",equalTo("Active"))
			.log().all();
	}
	
	@Test(priority = 4)
	public void deletUser()
	{
		
		given()
			.auth().oauth2("f7efb7d9775f3e00e2f2715d847a052047a9dbe8300464ca4279a9544c8abc4a")
//			.pathParam("mypath","public/v2")
//			.pathParam("mypath1","/users")
//			.queryParam("querypath1"+"/"+res)
			.when()
			.delete("https://gorest.co.in/public/v2/users/"+res)
			.then()
			.log().all();
	}
}


