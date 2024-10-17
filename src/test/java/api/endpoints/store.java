package api.endpoints;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor.Order;

import api.payloads.OrderPayload;
import io.restassured.response.Response;

public class store {

	public static Response getInventoryRequest() {
		
		Response response = given()
				            .accept(ContentType.JSON)
				            .when().get(routes.get_inventory);
		return response;
	}
	
	public static Response postOrder(OrderPayload orderPayload) {
		
		Response response = given()
                            .accept(ContentType.JSON)
                            .contentType(ContentType.JSON)
                            .body(orderPayload)
                            .when().post(routes.post_order);
		return response;
	}
	
	public static Response getOrderRequest(int orderid) {
		
		Response response = given() 
				            .accept(ContentType.JSON)
                            .pathParam("orderid", orderid)
                            .when().get(routes.get_order);
		return response;
	
	}
	
	public static Response deleteOrder(int orderid) {
		
		Response response = given()
				            .accept(ContentType.JSON)
				            .pathParam("orderid", orderid)
				            .when().delete(routes.delete_order);
		return response;
	}
}
