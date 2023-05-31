package diffwaystocreatebodyinrequests;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;

import org.testng.annotations.Test;

public class Creating_Post_Req_With_Hashmap 
{

	@Test(priority = 1)
	public void post_Body_with_HashMap()
	{
		HashMap<String,Object> hm = new HashMap<String, Object>();
		hm.put("name","Rani");
		hm.put("location","Hyderabad");
		hm.put("mobile","1234567890");

		String coursesArr[]= {"Automation","Python"};
		hm.put("courses",coursesArr);


		given()
		.contentType("application/json")
		.body(hm)

		.when()
		.post("http://localhost:3000/students")

		.then()
		.statusCode(201)
		.body("name",equalTo("Rani"))
		.body("location",equalTo("Hyderabad"))
		.body("mobile",equalTo("1234567890"))
		.body("courses[0]",equalTo("Automation"))
		.body("courses[1]",equalTo("Python"))
		.header("Content-Type", "application/json; charset=utf-8")
		.log().all();
	}

	@Test(priority = 2)
	public void deleteRequest()
	{
		given()
		.contentType("application/json")
		.when()
		.delete("http://localhost:3000/students/4")
		.then()
		.statusCode(200)
		.log().all();
	}


}
