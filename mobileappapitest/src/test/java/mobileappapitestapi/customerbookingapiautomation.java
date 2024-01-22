package mobileappapitestapi;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class customerbookingapiautomation {
	
	@Test(priority = 2)
	public void customerbooking()
	{
		String url=" https://dev.mantramedic.com/api/customer/Booking/{CustomerId}";
		String contenttype="application/json";
		String jsonbody="{\"booking_title\" :\"Test Checkup\",\"booking_type\":\"V\",\"booking_details\" :\"Booking details description\",\"booking_date\" :\"2024-01-22\",\"booking_lat\" :\"22.6573\",\"booking_long\" :\"88.3624\",\"service_id\" :\"1\",\"sub_service_ids\" :\"1,2\",\"member_id\" :\"76\",\"phone_no\" :\"9748049729\",\"email_id\" :\"pritam.sanyal@esolzmail.com\",\"prescription\" :\"wefdedfssa\",\"booking_address\" :\"Dakshineswar, Kolkata, West Bengal\",\"payment_mode\" :\"online\"}";
		String token="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJJc3N1ZS1Gb3ItMjUtcHJpdGFtLnNhbnlhbEBlc29sem1haWwuY29tLTk3NDgwNDk3MjkiLCJhdWQiOiJBdWRpZW5jZS0yNS1wcml0YW0uc2FueWFsQGVzb2x6bWFpbC5jb20tOTc0ODA0OTcyOSIsInN1YiI6IlN1YmplY3QtT2YtMjUtcHJpdGFtLnNhbnlhbEBlc29sem1haWwuY29tLTk3NDgwNDk3MjkiLCJpYXQiOjE3MDU2NTY5NDYsImV4cCI6MTcwNjI2MTc0NiwidXNlcm5hbWUiOiI5NzQ4MDQ5NzI5IiwiaWQiOiIyNSIsInR5cGUiOiJjdXN0b21lciJ9.LsK5KksdGvQRkVQk9I8yap3opz0vEJThe0vAcaUQU1Q";
		Response response2=(Response) RestAssured.
				given()
				.pathParam("CustomerId","25")
				.header("Authorization","Bearer "+token)
				.contentType(contenttype)
				.body(jsonbody)
				.when()
				.post(url)
				.then()
				.log().all()
				.extract().response();
		Assert.assertEquals(response2.statusCode(),200,"Response code is mismatch");
	String bookingtitle= response2.jsonPath().get("data.booking_title");
	System.out.println(bookingtitle);
	Assert.assertEquals(bookingtitle, "Test Checkup","Name is mismatch");
	String messages= response2.jsonPath().get("messages");
	System.out.println(messages);
	Assert.assertEquals(messages, "Customer Booking Success.","Messages is mismatch");	
		
		
	}
	@Test (priority = 1)
	public void servicedetails()
	{
		String url=" https://dev.mantramedic.com/api/customer/Service/{CustomerId}";
		String contenttype="application/json";
		String token="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJJc3N1ZS1Gb3ItMjUtcHJpdGFtLnNhbnlhbEBlc29sem1haWwuY29tLTk3NDgwNDk3MjkiLCJhdWQiOiJBdWRpZW5jZS0yNS1wcml0YW0uc2FueWFsQGVzb2x6bWFpbC5jb20tOTc0ODA0OTcyOSIsInN1YiI6IlN1YmplY3QtT2YtMjUtcHJpdGFtLnNhbnlhbEBlc29sem1haWwuY29tLTk3NDgwNDk3MjkiLCJpYXQiOjE3MDU2NTY5NDYsImV4cCI6MTcwNjI2MTc0NiwidXNlcm5hbWUiOiI5NzQ4MDQ5NzI5IiwiaWQiOiIyNSIsInR5cGUiOiJjdXN0b21lciJ9.LsK5KksdGvQRkVQk9I8yap3opz0vEJThe0vAcaUQU1Q";

		Response response3= (Response) RestAssured.
				given()
				.pathParam("CustomerId", "25")
				.contentType(contenttype)
				.header("Authorization","Bearer "+token)
				.when()
				.get(url)
				.then()
				.log().all()
				.extract().response();
		Assert.assertEquals(response3.statusCode(),200,"Response code is mismatch");
		
		JsonPath jsonPathEvaluator = response3.jsonPath();
		List<String> allservices = jsonPathEvaluator.getList("data.list.name");
		for (String services:allservices)
		{
			System.out.println("Serivces  : "+services);
		}
	}

}
