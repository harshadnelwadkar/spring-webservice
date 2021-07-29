/**
 * 
 */
package har.microservice.master.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import har.microservice.master.service.ChildTwoFeignProxy;


/**
 * @author harshadnelwadkar
 *
 */
@RestController 
public class EurekaServerClientController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	DiscoveryClient client;
	
	@Autowired
	ChildTwoFeignProxy childTwoFeignProxy;
	
	@GetMapping(path="/child-one-temp/welcome")
	public String getWelcomeMessage() {
		List<ServiceInstance>list = client.getInstances("child-service");
		String url = "http://"+list.get(0).getHost()+":"+list.get(0).getPort()+"/child-service/welcome";
		System.out.println("url ==>>"+url);
		return restTemplate.getForObject(url, String.class);
	}
	
	@GetMapping(path="/child-two-1/welcome")
	public String welcomeChildTwo() {
		return childTwoFeignProxy.getWelcomeMessage();
	}
	
	@GetMapping(path="/child-two-1/code")
	public String getChildTwoCode() {
		return restTemplate.getForObject("http://CHILD-TWO-SERVICE/code", String.class);
	}

	@GetMapping(path="/child-two-1/code-2")
	public String getChildTwoCode2() {
		return childTwoFeignProxy.getCode();
	}
}
