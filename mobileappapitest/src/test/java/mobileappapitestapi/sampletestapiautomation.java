package mobileappapitestapi;

import org.apache.commons.lang3.RandomStringUtils;

public class sampletestapiautomation {

	public static String fullname()
	{
		String fullname= RandomStringUtils.randomAlphabetic(3);
		return ("Amitdas"+fullname);
	}

	public static String dob ()
	{
		String dob= "1990-06-12";
		return (dob);
	}
	public static String email()
	{
		String email= RandomStringUtils.randomAlphabetic(3);
		return ("Amit"+email+"@gmail.com");
	}
	public static String gender()
	{
		String gender= "M";
		return (gender);
	}
	public static String phone ()
	{
		String phone= "8965412365";
		return (phone);
	}
	public static String pin()
	{
		String pin= "1234";
		return (pin);
	}
	
	
}
