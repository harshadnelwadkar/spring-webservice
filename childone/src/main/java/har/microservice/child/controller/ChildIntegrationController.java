/**
 * 
 */
package har.microservice.child.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;

import har.microservice.child.model.UserDetails;
import har.microservice.child.service.ChildServiceCaching;

/**
 * @author harshadnelwadkar
 *
 */
@org.springframework.web.bind.annotation.RestController
public class ChildIntegrationController {
	
	@Value("${welcome.message}")
	private String welcomeMessage;
	
	@Value("${child.one.code}")
	private String childOneCode;
	
	@Value("${child.one.use.key}")
	private String childOneUserkey;
	
	@GetMapping(path="/welcome")
	public String getWelcomeMessage() {
		return welcomeMessage;
	}
	
	@GetMapping(path="/code")
	public String getCode() {
		return childOneCode;
	}

	@GetMapping(path="/user-one")
	public UserDetails getUser() {
		return ChildServiceCaching.getUserDetails(childOneUserkey);
	}

	
			
}
