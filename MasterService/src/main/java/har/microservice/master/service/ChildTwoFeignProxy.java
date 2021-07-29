/**
 * 
 */
package har.microservice.master.service;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import har.microservice.master.model.FinanceDetails;

/**
 * @author harshadnelwadkar
 *
 */
@FeignClient(name= "CHILD-TWO-SERVICE", url="http://localhost:9082/child-two-service")
@EnableDiscoveryClient
public interface ChildTwoFeignProxy {
	
	@GetMapping(path="/welcome")
	public String getWelcomeMessage();
	
	@GetMapping(path="/code")
	public String getCode();

	@GetMapping(path="/finance-two")
	public FinanceDetails getFinance();

}
