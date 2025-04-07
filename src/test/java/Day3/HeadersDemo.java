package Day3;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;



public class HeadersDemo {

	@Test
	public void headerTest() {
		
	given().
		
		when().get("https://www.google.co.in/")
		.then().header("Content-Type","text/html; charset=ISO-8859-1")
		.and()
		.header("Content-Encoding","gzip");
	}
	
	@Test
	public void getHeaders() {
	Response	res=given().
		when().get("https://www.google.co.in/");
	
Headers	hed=res.getHeaders();

for(Header myhed:hed) {
	
	System.out.println(myhed.getName()+"   "+myhed.getValue());
	
}
		
	}
}
