/**
 * 
 */
package har.microservice.childtwo.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import har.microservice.childtwo.model.FinanceDetails;
import har.microservice.childtwo.model.UserDetails;
import har.microservice.childtwo.service.ChildServiceCaching;



/**
 * @author harshadnelwadkar
 *
 */
@org.springframework.web.bind.annotation.RestController
public class ChildTwoRestController {

	@GetMapping("/finance-list")
	public List<FinanceDetails> getUserList() {
		return ChildServiceCaching.getFinancialList();
	}
	
	@GetMapping("/finance/{key}")
	public FinanceDetails getUser(@PathVariable String key) {
		return ChildServiceCaching.getFinancialDetails(key);
	}
	
	@RequestMapping(path = "/put-finance" , produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public String putUserInData(@RequestBody FinanceDetails user) {
		System.out.println("finance =>"+user);
		ChildServiceCaching.addUser("key_"+ChildServiceCaching.getNewKey(), user);
		return "success !!";
	}
	
	@DeleteMapping("/delete-finance/{id}")
	public FinanceDetails deleteUser(@PathVariable String id) {
		FinanceDetails finance = ChildServiceCaching.deleteRecord(id);
		System.out.println("Deleted finance =>"+finance);
		System.out.println("deleted:"+ChildServiceCaching.getFinancialDetails(id));
		return finance;
		
	}
	
	@GetMapping("/delete-finance/{id}")
	public FinanceDetails deleteUserOnGet(@PathVariable String id) {
		FinanceDetails finance = ChildServiceCaching.deleteRecord(id);
		System.out.println("Deleted finance =>"+finance);
		System.out.println("deleted:"+ChildServiceCaching.getFinancialDetails(id));
		return finance;
		
	}
}
