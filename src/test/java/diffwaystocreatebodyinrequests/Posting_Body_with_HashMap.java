package diffwaystocreatebodyinrequests;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

public class Posting_Body_with_HashMap 
{

	@Test
	public void creating_body_with_Hashmap()
	{
		
		HashMap<String,Object> hm = new HashMap<String, Object>();
		hm.put("name","vedha");
		hm.put("location","Gadwal");
		hm.put("role","Manual Tester");
		
		String[] coursesarr ={"Manual","Automation"};
		hm.put("courses",coursesarr);
		
		given()
			.contentType("application/json")
			.body(hm)
			
			.when()
			.post("http://localhost:3000/data")
			
			
			.then()
			.statusCode(201)
			.body("name",equalTo("vedha"))
			.body("location",equalTo("Gadwal"))
			.body("role",equalTo("Manual Tester"))
			.body("courses[0]",equalTo("Manual"))
			.body("courses[1]",equalTo("Automation"))
			.log().all();
	}
	
	
}
