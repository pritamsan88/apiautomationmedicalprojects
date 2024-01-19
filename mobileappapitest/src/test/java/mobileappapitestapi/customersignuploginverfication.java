package mobileappapitestapi;
import static io.restassured.RestAssured.*;
//import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class customersignuploginverfication {
	
	
	@Test(priority = 1)
	public void customer_phoneverification()
	{
		
		
		given()
		.pathParam("phone","8420764240")
		.when()
		.get("https://dev.mantramedic.com/api/customer/PhoneVerification/{phone}")
		.then()
		.statusCode(200)
		.log().all();
	}
	
@Test(priority = 2)
	public void customer_signup()
	{
		String url="https://dev.mantramedic.com/api/customer/Signup";
		String contenttype="application/json";
		String jsonString = "{\"full_name\" : \"Goutam Sanyal\",\"date_of_birth\" : \"1990-06-12\",\"gender\":\"M\",\"email\":\"goutam77@gmail.com\",\"phone_no\" : \"8420764241\",\"pin\" : \"6415\"}";

		
		Response response=(Response) RestAssured.
				given()
				.contentType(contenttype)
				.body(jsonString)
				.when()
				.post(url)
				.then()
				.log().all()
				.extract().response();
		
		Assert.assertEquals(response.statusCode(), 201,"Response code mismatch");
	}
@Test(priority = 3)	
public void customer_signin() {
	
	String Url="https://dev.mantramedic.com/api/customer/Login";
	String contenttype="application/json";
	String jsonbody="{\"phone_number\" :\"9748049729\",\"pin\":\"1234\"}";
	Response response1=(Response) RestAssured.
			given()
			.contentType(contenttype)
			.body(jsonbody)
			.when()
			.post(Url)
			.then()
			.log().all()
			.extract().response();
	Assert.assertEquals(response1.statusCode(), 200,"Response code mismatch");
	String fullname=response1.jsonPath().get("data.full_name");
	//System.out.println(fullname);
	Assert.assertEquals(fullname, "Pritam Sanyal","Name is match");
}

	
	
}
