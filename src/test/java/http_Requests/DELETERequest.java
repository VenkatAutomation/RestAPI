package http_Requests;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;
public class DELETERequest 
{
	@Test
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
