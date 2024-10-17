package api.testcases;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;

import api.endpoints.user;
import api.payloads.userPayload;
import io.restassured.response.Response;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserTest {

	Faker faker;
	userPayload userPayload;
	public static Logger logger;
	 int id;
	 String username;
	 String firstName;
     String lastName;
     String email;
	 String password;
	 String phone;
	 int userStatus;
	 String jsonUserPayloadString;
	 @BeforeClass
	public void setUpTestData() throws JsonProcessingException {
		
		faker = new Faker();
		
		id = faker.idNumber().hashCode();
		username = faker.name().username();
		firstName = faker.name().firstName();
		lastName = faker.name().lastName();
		email = faker.internet().safeEmailAddress();
		password = faker.internet().password(5,10);
		phone = faker.phoneNumber().cellPhone();
		userStatus = faker.random().hashCode();
		
		
		this.userPayload = new userPayload(id,username,firstName,lastName,email,password,phone,userStatus);
		
		ObjectMapper objectMapper = new ObjectMapper();
		jsonUserPayloadString = objectMapper.writeValueAsString(userPayload);
		
	}
	
	 @Test(priority = 1)
	public void createUser() {
		
		Response response = user.createUser(jsonUserPayloadString);
		
		//log response
		response.then().log().all();


		//validation
		Assert.assertEquals(response.getStatusCode(),200);
	}
}
