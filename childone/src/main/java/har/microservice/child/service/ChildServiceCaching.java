package har.microservice.child.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import har.microservice.child.model.UserDetails;


public class ChildServiceCaching {
	
	private static ConcurrentHashMap<String, UserDetails> dataMap = new ConcurrentHashMap();
	private static int keyPointer = 1;
	
	public static int getNewKey() {
		return ++keyPointer;
	}
	
	public static void saveData(String key,UserDetails user) {
		dataMap.put(key, user);
		
	}
	
	public static UserDetails getUserDetails(String key) {
		return dataMap.get(key);
	}
	
	public static List<UserDetails> getUserList(){
		return new ArrayList(dataMap.values());
	}
	
	public UserDetails getUser(String key) {
		return dataMap.get(key);
	}
	
	public static void addUser(String key, UserDetails user) {
		dataMap.put(key, user);
	}

	public static UserDetails deleteUser(String key) {
		return dataMap.remove(key);
	}
	
	static {
		for(int i=0; i<20; i++) {
			UserDetails user = new UserDetails();
			user.setName("name_"+i);
			user.setUserId(i);
			user.setSecretAnswer("Secret answer :"+i);
			user.setPassword("my_password_"+i);
			dataMap.put("key_"+i, user);
			++ keyPointer;
		}
	}
	
}
