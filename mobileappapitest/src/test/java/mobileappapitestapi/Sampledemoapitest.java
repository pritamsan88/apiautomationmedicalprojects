package mobileappapitestapi;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Sampledemoapitest { 
	
	
@Test	
public void post_request()
{
    
	   
String jsonString = "{\"full_name\" : \"Amitpal\",\"date_of_birth\" : \"1990-06-12\",\"gender\":\"M\",\"email\":\"pal88@gmail.com\",\"phone_no\" : \"4589658965\",\"pin\" : \"1234\"}";

/*
	Construct a request specification
*/
RequestSpecification request= RestAssured.given();

/*
	Setting content type to specify the format in which the request payload will be sent.
*/
request.contentType(ContentType.JSON);

/*
	Adding URI
*/
request.baseUri("https://dev.mantramedic.com/api/customer/Signup");

/*
	Adding body as string
*/
request.body(jsonString);

/*
	Calling POST method on URI. After hitting, we get Response
*/
Response response = request.post();

/*
	Printing Response as string
*/
System.out.println(response.asString());

/*
	Get Validatable response to perform validation
*/
ValidatableResponse validatableResponse = response.then();

/*
	Validate status code as 201
*/
validatableResponse.statusCode(201);

System.out.println(response.getStatusCode());
System.out.println(response.getTime());
}
}

