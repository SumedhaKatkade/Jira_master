package api.test;

import org.testng.annotations.Test;
import api.utility.commonUtility;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.Cookie;
import io.restassured.path.json.JsonPath;

public class Jira_API {

	@Test
	public Cookie createSession() {
		RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
		RestAssured.baseURI = "http://localhost:8080/";
		String createSession = given().log().all().header("Content-Type", "application/json")
				.body(JsonData.createSessionData()).when().post("rest/auth/1/session").then().statusCode(200).extract()
				.response().asString();
		System.out.println("Response of create session: " + createSession);
		JsonPath createSessionRes = commonUtility.jasonParser(createSession);
		String session_Id = createSessionRes.getString("session.value");
		System.out.println("Session Id : " + session_Id);

		Cookie myCookie = new Cookie.Builder("JSESSIONID", session_Id).setSecured(true).setComment("session id cookie")
				.build();
		return myCookie;
	}

	@Test
	public void createProject() {
		RestAssured.baseURI = "http://localhost:8080";
		Cookie myCookie = createSession();
		String createProjectRes = given().log().all().header("Content-Type", "application/json").cookie(myCookie)
				.body(JsonData.createProject()).when().post("rest/api/2/project").then().log().all().statusCode(201)
				.extract().response().asString();
		JsonPath createProjectResBody = commonUtility.jasonParser(createProjectRes);
		int projectId = createProjectResBody.getInt("id");
		System.out.println("Project ID : " + projectId);
		System.out.println("-----------------Project Created Successfully--------------");
		deleteProject(projectId);
	}

	public void deleteProject(int projectId) {
		Cookie myCookie = createSession();
		RestAssured.baseURI = "http://localhost:8080/";
		given().log().all().header("Content-Type", "application/json").cookie(myCookie).when()
				.delete("rest/api/2/project/" + "" + projectId).then().log().all().statusCode(204).extract().response()
				.asString();
		System.out.println("-----------------Project Deleted Successfully--------------");
	}

	@Test
	public void getAllStatusesForProject() {
		Cookie myCookie = createSession();
		given().log().all().pathParam("id", "10300").header("Content-Type", "application/json").cookie(myCookie).when()
				.get("rest/api/2/project/{id}/statuses").then().log().all().statusCode(200).extract().response()
				.asString();
	}

	/*
	 * @Test public void getAllProject() { Cookie myCookie = createSession();
	 * given().log().all().header("Content-Type",
	 * "application/json").cookie(myCookie).when().get("rest/api/2/project")
	 * .then().log().all().statusCode(200).extract().response().asString(); }
	 */
	/*
	 * @Test public void getProject() { Cookie myCookie = createSession();
	 * given().log().all().header("Content-Type",
	 * "application/json").cookie(myCookie).when()
	 * .get("rest/api/2/project/10206").then().log().all().statusCode(200); }
	 */
	/*
	 * @Test public void updateProject() { Cookie myCookie = createSession();
	 * given().log().all().header("Content-Type",
	 * "application/json").cookie(myCookie).body(JsonData.updateProject())
	 * .when().put("rest/api/2/project/DEMO").then().log().all().statusCode(200); }
	 */

}
