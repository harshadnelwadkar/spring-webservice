/**
 * 
 */
package har.microservice.master.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import har.microservice.master.model.FinanceDetails;
import har.microservice.master.model.UserDetails;
import har.microservice.master.service.ChildOneFeignProxy;
import har.microservice.master.service.ChildTwoFeignProxy;


/**
 * @author harshadnelwadkar
 *
 */
@RestController 
public class MasterOpenFeignController {
	
	@Autowired
	//@LoadBalanced
	ChildOneFeignProxy childOneFeignProxy;
	
	@Autowired
	//@LoadBalanced
	ChildTwoFeignProxy childTwoFeignProxy;
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	
	@RequestMapping(path="/feign/hello" ,method = RequestMethod.GET)
	public String helloWorld() {
		List<ServiceInstance> serviceList = discoveryClient.getInstances("child-service");
		ServiceInstance service = serviceList.get(0);
		return "Hi from Harshad !! =>"+service.toString()+"--"+service.getScheme()+"-2-";
	}
	
	@GetMapping(path="/child-one/welcome")
	public String getWelcomeMessage() {
		return childOneFeignProxy.getWelcomeMessage();
	}
	
	@GetMapping(path="/child-one/code")
	public String getCode() {
		return childOneFeignProxy.getCode();
	}

	@GetMapping(path="/child-one/user-one")
	public UserDetails getUser() {
		return childOneFeignProxy.getUser();
	}
	
	//Child-two
	@GetMapping(path="/child-two/welcome")
	public String getWelcomeMessageChildTwo() {
		return childTwoFeignProxy.getWelcomeMessage();
	}
	
	@GetMapping(path="/child-two/code")
	public String getCodeChildTwo() {
		return childTwoFeignProxy.getCode();
	}

	@GetMapping(path="/child-two/finance-two")
	public FinanceDetails getFinanceChildTwo() {
		return childTwoFeignProxy.getFinance();
	}
}
