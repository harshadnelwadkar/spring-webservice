/**
 * 
 */
package har.microservice.child.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;

import har.microservice.child.model.FinanceDetails;
import har.microservice.child.model.UserDetails;
import har.microservice.child.service.ChildServiceCaching;
import har.microservice.child.service.ChildTwoFeignProxy;

/**
 * @author harshadnelwadkar
 *
 */
@org.springframework.web.bind.annotation.RestController
public class ChildFeignLoadbalancerController {
	
	@Autowired
	private ChildTwoFeignProxy childTwoFeignProxy;
	
	@GetMapping(path="/two-welcome")
	public String getWelcomeMessage() {
		return childTwoFeignProxy.getWelcomeMessage();
	}
	
	@GetMapping(path="/two-code")
	public String getCode() {
		return childTwoFeignProxy.getCode();
	}

	@GetMapping(path="/two-finance")
	public FinanceDetails getFinance() {
		return childTwoFeignProxy.getFinance();
	}

	
			
}
