package api.test;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;

public class sample_test {
	@Test
	public void sample() {
		RestAssured.baseURI = "https://petstore.swagger.io/";
		String res = given().log().all().header("Content-Type", "application/json").when()
				.get("https://petstore.swagger.io/v2/pet/findByStatus?status=available").then().assertThat()
				.statusCode(200).extract().response().asString();
		System.out.println("........" + res);
	}
}
