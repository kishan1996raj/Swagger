package api.endpoints;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.*;

import io.restassured.response.Response;



import api.payloads.userPayload;

public class user {
	
	public static Response createUser(String userPayload) {
	
		Response response = given().accept(ContentType.JSON).
				            contentType(ContentType.JSON).
				            when().
				            body(userPayload).post(routes.post_user);
		return response;
    }
	
	
	
	public static Response createMultipleUser(String usersList) {
		
		Response response = given().accept(ContentType.JSON).
				            contentType(ContentType.JSON).
				            when().body(usersList).post(routes.post_usersList);
		return response;
		
		
	}
	
	
	public static Response getUserByUsername(String username) {
		
		Response response = given().accept(ContentType.JSON).
				            pathParam("username", username).
				            when().get(routes.get_user_by_username);
		return response;
	}
	
	public static Response putUpdateByUsername(String username, userPayload userPayload) {
		
		Response response = given().accept(ContentType.JSON).
				            contentType(ContentType.JSON).
				            pathParam("username", username).when().body(userPayload).
				            put(routes.put_update_by_username);
		return response;
			
	}
	
	public static Response deleteUserByUsername(String username) {
		
		Response response = given().accept(ContentType.JSON).
				            contentType(ContentType.JSON).
				            pathParam("username", username).when().
				            delete(routes.delete_user_by_username);
		return response;
		
	}
	
	public static Response getUserLogin(String username, String password) {
		
		Response response = given().accept(ContentType.JSON).
				            queryParam("username", username).
				            queryParam("password", password).when().get(routes.get_user_login);
		
		return response;
	}
	
	public static Response getUserLogout() {
		
		Response response = when().get(routes.get_user_logoutString);
		
		return response;
	}
}