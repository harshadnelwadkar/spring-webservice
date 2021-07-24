/**
 * 
 */
package har.microservice.master.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import har.microservice.master.model.UserDetails;
import har.microservice.master.service.MyCaching;

/**
 * @author harshadnelwadkar
 *
 */
@RestController
public class RestServiceExamples {
	
	@GetMapping("/simple-get")
	public String simpleGetRequest() {
		return "Hi Simple get response !!!";
	}
	
	@GetMapping("/get/{user}/{number}")
	public String getWithVariable(@PathVariable String user, @PathVariable int number) {
		return "Hi "+user+" get response with number "+number+" !!!";
	}
	
	@GetMapping("/get/param/{parameter}")
	public String getWithParameter(@PathParam(value = "parameter") String param) {
		return "Hi Harshad get response with parameter "+param+" !!!";
	}
	
	@GetMapping("/user-list")
	public List<UserDetails> getUserList() {
		return MyCaching.getUserList();
		
	}
	
	@RequestMapping(path = "/put-user" , produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public String putUserInData(@RequestBody UserDetails user) {
		System.out.println("user =>"+user);
		
		return "success !!";
	}
	
	@RequestMapping(path = "/put-user/test", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public String putUserInData(@RequestParam String name, @RequestParam String userId) {
		System.out.println("name =>"+name+"  -- userId"+userId);
		
		return "success !!";
	}
	
	@DeleteMapping("/delete-user/{id}")
	public UserDetails deleteUser(@PathVariable String id) {
		UserDetails user = MyCaching.deleteUser(id);
		System.out.println("Deleted user =>"+user);
		System.out.println("deleted:"+MyCaching.getUserDetails(id));
		return user;
		
	}

}
