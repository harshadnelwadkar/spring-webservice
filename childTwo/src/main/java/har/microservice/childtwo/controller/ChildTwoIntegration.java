/**
 * 
 */
package har.microservice.childtwo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;

import har.microservice.childtwo.model.FinanceDetails;
import har.microservice.childtwo.service.ChildServiceCaching;


/**
 * @author harshadnelwadkar
 *
 */
@org.springframework.web.bind.annotation.RestController
public class ChildTwoIntegration {

	@Value("${welcome.message}")
	private String welcomeMessage;
	
	@Value("${child.two.code}")
	private String childTwoCode;
	
	@Value("${child.two.finance.key}")
	private String childTwoFinancekey;
	
	@GetMapping(path="/welcome")
	public String getWelcomeMessage() {
		return welcomeMessage;
	}
	
	@GetMapping(path="/code")
	public String getCode() {
		return childTwoCode;
	}

	@GetMapping(path="/finance-two")
	public FinanceDetails getFinance() {
		return ChildServiceCaching.getFinance(childTwoFinancekey);
	}
}
