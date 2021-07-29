package har.microservice.childtwo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import har.microservice.childtwo.model.FinanceDetails;
import har.microservice.childtwo.model.UserDetails;


public class ChildServiceCaching {
	
	private static ConcurrentHashMap<String, FinanceDetails> dataMap = new ConcurrentHashMap();
	private static int keyPointer = 1;
	
	public static int getNewKey() {
		return ++keyPointer;
	}
	
	public static void saveData(String key,FinanceDetails record) {
		dataMap.put(key, record);
		
	}
	
	public static FinanceDetails getFinancialDetails(String key) {
		return dataMap.get(key);
	}
	
	public static List<FinanceDetails> getFinancialList(){
		return new ArrayList(dataMap.values());
	}
	
	public static FinanceDetails getFinance(String key) {
		return dataMap.get(key);
	}
	
	public static void addUser(String key, FinanceDetails finance) {
		dataMap.put(key, finance);
	}

	public static FinanceDetails deleteRecord(String key) {
		return dataMap.remove(key);
	}
	
	static {
		for(int i=0; i<20; i++) {
			FinanceDetails finance = new FinanceDetails();
			finance.setUserName("name_"+i);
			finance.setCurrencyName("GBP");
			finance.setBnkName("BARC");
			finance.setAmount((float) 458.10);
			dataMap.put("key_"+i, finance);
			++ keyPointer;
		}
	}
	
}
