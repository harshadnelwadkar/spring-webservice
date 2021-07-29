/**
 * 
 */
package har.microservice.master.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import har.microservice.master.model.UserDetails;


/**
 * @author harshadnelwadkar
 *
 */
@FeignClient("child-service")
public interface ChildOneFeignProxy {

	@GetMapping(path="/welcome")
	public String getWelcomeMessage();
	
	@GetMapping(path="/code")
	public String getCode();

	@GetMapping(path="/user-one")
	public UserDetails getUser();
}
