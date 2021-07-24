package har.microservice.child.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	private RestTemplate restTemplate;
	
	
	@GetMapping(path = "/hello")
	public String helloWorld() {
		return "Hello Harshad from Child 1 !!";
	}
}
