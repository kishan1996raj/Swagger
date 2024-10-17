package api.endpoints;

public class routes {
	
	public static String base_url = "https://petstore.swagger.io/v2";
	
	public static String  post_user = base_url + "/user";
	public static String  post_usersList = base_url + "/user/createWithList";
	public static String get_user_by_username = base_url + "/user/{username}"; 
	public static String put_update_by_username = base_url + "/user/{username}"; 
	public static String delete_user_by_username = base_url + "/user/{username}"; 
	public static String get_user_login = base_url + "/user/login"; 
	public static String  get_user_logoutString = base_url + "/user/logout";
	
	public static String  get_inventory = base_url + "/store/inventory";
	public static String  post_order = base_url + "/store/order";
	public static String  get_order = base_url + "/store/order/{orderId}";
	public static String  delete_order = base_url + "/store/order/{orderId}";
	
	public static String  post_uploadImage = base_url + "/pet/{petId}/uploadImage";
	public static String  post_pet = base_url + "/pet";
	public static String  put_pet = base_url + "/pet";
	public static String  get_pet_byStatus = base_url + "/pet/findByStatus";
	public static String  get_pet_byID = base_url + "/pet/{petId}";
	public static String  post_pet_byID = base_url + "/pet/{petId}";
	public static String  delete_byPetID = base_url + "/pet/{petId}";
	
}
