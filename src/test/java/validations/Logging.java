package validations;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Logging 
{
	//	@Test
	//	public void logging()
	//	{
	//		given()
	//		.when()
	//		.get("http://localhost:3000/students")
	//		.then()
	//		//.log().body();
	//		.log().cookies();
	//		//.log().headers();
	//	}


	public static void main(String[] args)
	{
		RequestSpecification request= RestAssured.given();

		// Setting content type to specify the format in which the request payload will be sent.
		request.contentType(ContentType.JSON);

		// Adding URI
		request.baseUri("http://localhost:3000/data");

		// Adding body as string
		//request.body(jsonString);

		// Calling POST method on URI. After hitting, we get Response
		Response response = request.get();

		// Printing Response as string
		System.out.println(response.asString());

		try 
		{
			PrintStream out = new PrintStream(new File("D:/temp/eclipse-workspace/RESTAssured/targetFile.txt"));
			System.setOut(out);
		}
		catch(FileNotFoundException fx) 
		{
			System.out.println(fx);
		}

		// Get Validatable response to perform validation
		ValidatableResponse validatableResponse = response.then();   

		// Validate status code as 201
		validatableResponse.statusCode(200);

		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());


	}

}