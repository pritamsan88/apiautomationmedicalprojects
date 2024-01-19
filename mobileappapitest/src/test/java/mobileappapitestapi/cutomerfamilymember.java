package mobileappapitestapi;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class cutomerfamilymember{
	
	@Test
	public void familymember() {
		
		String url=" https://dev.mantramedic.com/api/customer/Member/{CustomerId}";
		String contenttype="application/json";
		String token="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJJc3N1ZS1Gb3ItMjUtcHJpdGFtLnNhbnlhbEBlc29sem1haWwuY29tLTk3NDgwNDk3MjkiLCJhdWQiOiJBdWRpZW5jZS0yNS1wcml0YW0uc2FueWFsQGVzb2x6bWFpbC5jb20tOTc0ODA0OTcyOSIsInN1YiI6IlN1YmplY3QtT2YtMjUtcHJpdGFtLnNhbnlhbEBlc29sem1haWwuY29tLTk3NDgwNDk3MjkiLCJpYXQiOjE3MDU2NTY5NDYsImV4cCI6MTcwNjI2MTc0NiwidXNlcm5hbWUiOiI5NzQ4MDQ5NzI5IiwiaWQiOiIyNSIsInR5cGUiOiJjdXN0b21lciJ9.LsK5KksdGvQRkVQk9I8yap3opz0vEJThe0vAcaUQU1Q";

		Response response2=(Response) RestAssured.
				given()
				.header("Authorization","Bearer "+token )
				.pathParam("CustomerId", 25)
				.contentType(contenttype)
				.when()
				.get(url)
				.then()
				.log().all()
				.extract().response();
		Assert.assertEquals(response2.getStatusCode(), 200,"Response code mismatch");
		String messages= response2.jsonPath().get("messages");
		System.out.println(messages);
		Assert.assertEquals(messages, "Member list success.","Messages is mismatch");	
	}
	
	
}
