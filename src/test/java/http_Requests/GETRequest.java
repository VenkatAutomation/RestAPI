package http_Requests;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class GETRequest 
{
	@Test
	public void getRequest()
	{
		given()
		.contentType("application/json")
		.when()
		.get("http://localhost:3000/students")
		.then()
		.statusCode(200)
		.log().all();
	}
}
