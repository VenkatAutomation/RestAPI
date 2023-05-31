package validations;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class Query_And_Path_Parameters 
{
	@Test
	public void query_and_path_parameters()
	{
		given()
		.pathParam("mypath", "students")
		//.queryParam("id",1)
		//.queryParam("id",2)
		.queryParam("id",3)
		.when()
		.get("http://localhost:3000/{mypath}")
		.then()
		.log().all();
	}
}
