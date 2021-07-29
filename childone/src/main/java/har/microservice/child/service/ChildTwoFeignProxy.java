/**
 * 
 */
package har.microservice.child.service;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import har.microservice.child.model.FinanceDetails;

/**
 * @author harshadnelwadkar
 *
 */
@FeignClient("child-two-service")
@LoadBalancerClient(name = "child-two-service",
configuration=LoadBalancerConfiguration.class)
public interface ChildTwoFeignProxy {
	
	@GetMapping(path="/welcome")
	public String getWelcomeMessage(); 
	
	@GetMapping(path="/code")
	public String getCode();

	@GetMapping(path="/finance-two")
	public FinanceDetails getFinance(); 
}
