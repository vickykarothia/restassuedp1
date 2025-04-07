package Day3;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class LogDemo {

	@Test
	public void logTest() {
		when().get("https://www.google.co.in/")
		 .then()
		 .log()
//		 .body();
//		 .headers();
//		 .cookies();
		 .all();
	}
}
