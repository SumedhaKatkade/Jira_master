package api.utility;

import io.restassured.path.json.JsonPath;

public class commonUtility {
	public static JsonPath jasonParser(String path) {
		JsonPath jasonPath = new JsonPath(path);
		return jasonPath;
	}
}
