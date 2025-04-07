package Day2;

import java.util.HashMap;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class DifferentWaysToCraetePost {
	/*
	 * different ways to creating post request 1)by using hashmap; 2)by org.json
	 * 3)by POJO class 4)by external json file data;
	 * 
	 */

//	@Test(priority=1)
	public void postUsingHashmapTest() {
		// by using hashmap

		String[] caurses = { "c", "c++" };
		HashMap data = new HashMap();
		data.put("name", "vikas");
		data.put("location", "india");
		data.put("phone_no", "2857975");
		data.put("caurses", caurses);

		given().contentType("application/json").body(data).

				when().post("http://localhost:3000/students").

				then().statusCode(201).body("name", equalTo("vikas")).body("location", equalTo("india"))
				.body("phone_no", equalTo("2857975")).body("caurses[0]", equalTo("c"))
				.body("caurses[1]", equalTo("c++")).header("Content-Type", "application/json").log().all();

	}
	
//	@Test(priority=2)
	public void deleteStudents() {
		when().delete("http://localhost:3000/students/4").then().statusCode(200);
	}
	
	@Test
	public void postUsingJsonLibraryTest() {
		
		String[] caurses = { "c", "c++" };
		JSONObject data = new JSONObject();
		data.put("name", "vikas");
		data.put("location", "india");
		data.put("phone_no", "2857975");
		data.put("caurses", caurses);

		given().contentType("application/json").body(data.toString()).

				when().post("http://localhost:3000/students").

				then().statusCode(201).body("name", equalTo("vikas")).body("location", equalTo("india"))
				.body("phone_no", equalTo("2857975")).body("caurses[0]", equalTo("c"))
				.body("caurses[1]", equalTo("c++")).header("Content-Type", "application/json").log().all();

	}
	
	
	@Test
	public void postUsingPOJOTest() {
		
		String[] caurses = { "c", "c++" };
		POJO_postRequest data=new POJO_postRequest();    
 
		data.setName("akash");
		data.setPhone_no("4687955");
		data.setLocation("india");
		data.setCaurses(caurses);
		
		given().contentType("application/json").body(data).

				when().post("http://localhost:3000/students").

				then().statusCode(201).body("name", equalTo("akash")).body("location", equalTo("india"))
				.body("phone_no", equalTo("4687955")).body("caurses[0]", equalTo("c"))
				.body("caurses[1]", equalTo("c++")).header("Content-Type", "application/json").log().all();

	}

}
