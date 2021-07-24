/**
 * 
 */
package har.microservice.master.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import har.microservice.master.model.FinanceDetails;
import har.microservice.master.model.UserDetails;


/**
 * @author harshadnelwadkar
 *
 */
@RestController 
public class MasterRestController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${child.one.url}")
	private String childOneServiceUrl;
	
	@Value("${child.two.url}")
	private String childTwoServiceUrl;
	
	@RequestMapping(path="/hello" ,method = RequestMethod.GET)
	public String helloWorld() {
		return "Hi from Harshad !!";
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/child-one-list")
	public ResponseEntity<List> getChildOneUserList() {
		return restTemplate.getForEntity(childOneServiceUrl+"/user-list",List.class);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/child-one-get/{user}")
	public ResponseEntity<UserDetails> getUserlistFromChildOne(@PathVariable String user) {
		return restTemplate.getForEntity(childOneServiceUrl+"/get-user/{key}",UserDetails.class, user);
	}

	//Child two calls
	@RequestMapping(method = RequestMethod.GET, path = "/child-two-list")
	public ResponseEntity<List> getChildTwoFinanceList() {
		return restTemplate.getForEntity(childTwoServiceUrl+"/finance-list",List.class);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/child-two-get/{user}")
	public ResponseEntity<FinanceDetails> getChildTwoFinanceDetails(@PathVariable String user) {
		return restTemplate.getForEntity(childTwoServiceUrl+"/finance/{key}",FinanceDetails.class, user);
	}
	
}
