package assignments;


import org.testng.annotations.Test;

import io.restassured.http.*;


import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;



public class POSTRequestCall {


	@Test()
	public void UserRegistrationSuccessful() 
	{ 


		String name =   RandomStringUtils.randomAlphabetic(6);
		String salary  = RandomStringUtils.randomNumeric(5);
		String age = RandomStringUtils.randomNumeric(2);

		String jsonBody = "	{\"name\":"+ name + ",\"salary\":" + salary + ",\"age\":"+age+"}";

		given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.and()
		.body(jsonBody)
		.when().log().all()
		.post("https://dummy.restapiexample.com/api/v1/create")   //hit the post end point
		.then()
		.assertThat()
		.statusCode(HttpStatus.SC_OK).log().all()
		.and()
		.body("status", equalTo("success"),("message"),equalTo("Successfully! Record has been added.")); // Match the output actual to expected	


	}



}
