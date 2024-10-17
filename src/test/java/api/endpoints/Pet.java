package api.endpoints;

import java.io.File;

import api.payloads.Category;
import api.payloads.PetPayload;
import api.payloads.Tag;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class Pet {
        
	public static Response postPetUploadImage(int petId, String additionalMetadata, File fileToUpload) {
		
		Response response = given()
				.accept(ContentType.JSON)
	            .pathParam("petid", petId)  // Setting path parameter for petId
	            .multiPart("file", fileToUpload)  // Uploading file as form data
	            .multiPart("additionalMetadata", additionalMetadata)  // Sending additional metadata
	            .when()
	            .post(routes.post_uploadImage);
		
		return response;
		
	}
	
	public static Response postCreatePet(PetPayload pp) {
		
		Response response = given()
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.body(pp)
				.when().post(routes.post_pet);
		
		return response;
		
		
	}
	
	public static Response putUpdatePet(PetPayload pp) {
		
		Response response = given()
				            .accept(ContentType.JSON)
				            .contentType(ContentType.JSON)
				            .body(pp)
				            .when()
				            .put(routes.put_pet);
		
		return response;
	}
	
	public static Response getPetByStatus(String [] statuses) {
		  RequestSpecification requestSpec = given().baseUri(routes.base_url).accept(ContentType.JSON);

	        // Add each status as a query parameter
	        for (String status : statuses) {
	            requestSpec.queryParam("status", status);
	        }

	        // Send the GET request
	        return requestSpec.when().get("/pet/findByStatus");
	}
	
	public static Response getPetByID(int petID) {
		
		Response response = given()
                            .accept(ContentType.JSON)
                            .pathParam("petid",petID)
                            .when().get(routes.get_pet_byID);
	
		return response;
	
	}
	
	public static Response postPetByPetID(int petID, String name, String status) {
		
		Response response = given().accept(ContentType.JSON)
				            .pathParam("petid",petID)
				            .multiPart("name", name)
				            .multiPart("status",status)
				            .when().post(routes.post_pet_byID);
		
		return response;
	}
	
	public static Response deletePetBuID(long petID, String apiKey) {
		
		Response response = given()
				            .header("api_key",apiKey)
				            .pathParam("petid",petID)
				            .accept(ContentType.JSON)
				            .when().delete(routes.delete_byPetID);
		
		return response;
	}
}
