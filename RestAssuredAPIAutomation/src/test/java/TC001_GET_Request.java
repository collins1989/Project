import org.testng.Assert;
import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_GET_Request {
	
	@Test
	public void getUserDetails()
	{
		//Specify base URL
		RestAssured.baseURI = "https://api.github.com/users";
		//RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		
		  //Request object
		  RequestSpecification httpRequest=RestAssured.given();
		  
		  //Response object
		  Response response=httpRequest.request(Method.GET,"/6wl");
		  
		//print response in console window
		  
		  String responseBody=response.getBody().asString();
		  System.out.println("Response Body is:" +responseBody);
		  Assert.assertTrue(responseBody.contains("15330"));
		  Assert.assertTrue(responseBody.contains("Manchester"));
		  Assert.assertTrue(responseBody.contains("Amplience"));
		  Assert.assertTrue(responseBody.contains("Gregory Loscombe"));
		  Assert.assertTrue(responseBody.contains("28"));
		  Assert.assertTrue(responseBody.contains("11"));
		  Assert.assertTrue(responseBody.contains("14"));
		  
		  
		  
		 
		  
		  
		  
		  //status code validation
		  int statusCode=response.getStatusCode();
		  System.out.println("Status code is: "+statusCode);
		  Assert.assertEquals(statusCode, 200);
		  
		  
		  //status line verification
		  String statusLine=response.getStatusLine();
		  System.out.println("Status line is:"+statusLine);
		  Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		  String headers =response.getHeaders().toString();
		  System.out.println(headers);
	}

}
