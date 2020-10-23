package api.test;

public class JsonData {
	public static String createSessionData() {
		return "{ \r\n" + 
				"    \"username\": \"katkadesumedha\", \r\n" + 
				"    \"password\": \"Sk@jira123\" \r\n" + 
				"}";
	}
	
	public  static  String createProject() {
		return "{\r\n" + 
				"  \"description\": \"Example Project description\",\r\n" + 
				"  \"lead\": \"katkadesumedha\",\r\n" + 
				"  \"url\": \"http://atlassian.com\",\r\n" + 
				"     \"projectTemplateKey\": \"com.atlassian.jira-core-project-templates:jira-core-project-management\",\r\n" + 
				"  \"avatarId\": 10200,\r\n" + 
				"  \r\n" + 
				"  \"name\": \"Amol Deole\",\r\n" + 
				"  \"assigneeType\": \"UNASSIGNED\",\r\n" + 
				"  \"projectTypeKey\": \"business\",\r\n" + 
				"  \"key\": \"ANGULAR\"\r\n" + 
				"\r\n" + 
				"}";
	}
	
	public static String updateProject() {
		return "{\r\n" + 
				"  \"description\": \"Example Project description\",\r\n" + 
				"  \"lead\": \"katkadesumedha\",\r\n" + 
				"  \"url\": \"http://atlassian.com\",\r\n" + 
				"     \"projectTemplateKey\": \"com.atlassian.jira-core-project-templates:jira-core-project-management\",\r\n" + 
				"  \"avatarId\": 10200,\r\n" + 
				"  \r\n" + 
				"  \"name\": \"HOMEAWAYSAURU\",\r\n" + 
				"  \"assigneeType\": \"UNASSIGNED\",\r\n" + 
				"  \"projectTypeKey\": \"business\",\r\n" + 
				"  \"key\": \"SAURABH123\"\r\n" + 
				"\r\n" + 
				"}";
	}
}
