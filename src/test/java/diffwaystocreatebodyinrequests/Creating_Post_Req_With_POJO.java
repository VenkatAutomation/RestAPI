package diffwaystocreatebodyinrequests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;

public class Creating_Post_Req_With_POJO 
{

	@Test(priority = 1)
	public void post_Body_with_POJO()
	{
		POJO_For_Post_Req data = new POJO_For_Post_Req();

		data.setName("Rani");
		data.setLocation("Hyderabad");
		data.setMobile("1234567890");

		String coursesarr[] = {"Automation","Python"};
		data.setCourses(coursesarr);

		given()
		.contentType("application/json")
		.body(data)

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
