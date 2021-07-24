/**
 * 
 */
package har.microservice.child.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import har.microservice.child.model.UserDetails;
import har.microservice.child.service.ChildServiceCaching;



/**
 * @author harshadnelwadkar
 *
 */
@org.springframework.web.bind.annotation.RestController
public class ChildRestController {

	@GetMapping("/user-list")
	public List<UserDetails> getUserList() {
		return ChildServiceCaching.getUserList();
	}
	
	@GetMapping("/get-user/{key}")
	public UserDetails getUser(@PathVariable String key) {
		return ChildServiceCaching.getUserDetails(key);
	}
	
	@RequestMapping(path = "/put-user" , produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public String putUserInData(@RequestBody UserDetails user) {
		System.out.println("user =>"+user);
		ChildServiceCaching.addUser("key_"+ChildServiceCaching.getNewKey(), user);
		return "success !!";
	}
	
	@DeleteMapping("/delete-user/{id}")
	public UserDetails deleteUser(@PathVariable String id) {
		UserDetails user = ChildServiceCaching.deleteUser(id);
		System.out.println("Deleted user =>"+user);
		System.out.println("deleted:"+ChildServiceCaching.getUserDetails(id));
		return user;
		
	}
	
	@GetMapping("/delete-user/{id}")
	public UserDetails deleteUserOnGet(@PathVariable String id) {
		UserDetails user = ChildServiceCaching.deleteUser(id);
		System.out.println("Deleted user =>"+user);
		System.out.println("deleted:"+ChildServiceCaching.getUserDetails(id));
		return user;
		
	}
}
