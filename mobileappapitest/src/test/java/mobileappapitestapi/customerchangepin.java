package mobileappapitestapi;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class customerchangepin {

	int id;
	String resetcode;
	
	@Test
	public void customerforgotpin()
	{
		String url="https://dev.mantramedic.com/api/customer/ForgotPin";
		String contenttype="application/json";
		String username="{\r\n"
				+ "\"username\":\"pritam.sanyal@esolzmail.com\"\r\n"
				+ "}\r\n"
				+ "";
		
		Response pin=(Response) RestAssured.
				given()
				.contentType(contenttype)
				.body(username)
				.when()
				.put(url)
				.then()
				.log().all()
				.extract().response();
		Assert.assertEquals(pin.statusCode(),200,"Status code mismatch");
		id=pin.jsonPath().get("data.id");
		System.out.println(id);
		resetcode=pin.jsonPath().get("data.reset_code");
		System.out.println(resetcode);
	}
	
	@Test (dependsOnMethods = "customerforgotpin" )

	public void resetpin()
	{
		String url="https://dev.mantramedic.com/api/customer/ResetPin/{genarated pin}";
		String contenttype="application/json";
		String body= "{\r\n"
				+ "\"resetcode\":"+resetcode+",\r\n"
				+ "\"new_pin\": \"5544\"\r\n"
				+ "}";
				
				//"{\"resetcode\" : + resetcode +,\"new_pin\" :\"6415\"}";
		Response resetpin=(Response) RestAssured.
				given()
				.contentType(contenttype)
				.pathParam("genarated pin", id)
				.body(body)
				.when()
				.put(url)
				.then()
				.log().all()
				.extract().response();
		Assert.assertEquals(resetpin.statusCode(),200,"Status code mismatch");
				
		
	}
}
