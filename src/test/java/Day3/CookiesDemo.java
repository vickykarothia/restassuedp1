package Day3;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class CookiesDemo {

//	@Test
	public void cookiesTest() {

		given().

				when().get("https://www.google.co.in/").

				then().cookie("AEC", "AVcja2cE2Y4KN1V8o5LIm-1RTRhLVgeJRjp7zK6c8H16pUZyg2zCE0nahg").log().all();
	}

	@Test
	public void getCookiesInfoTest() {

		Response res = given().

				when().get("https://www.google.co.in/");

//		System.out.println(res.getCookie("AEC"));
	Map<String,String>	info=res.getCookies();
	
       for(String k:info.keySet()) {
    	   System.out.println(k+"   "+res.getCookie(k));
       }
	}

}
