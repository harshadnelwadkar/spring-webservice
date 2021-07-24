/**
 * 
 */
package har.microservice.master.model;

import java.util.Currency;

/**
 * @author harshadnelwadkar
 *
 */
public class FinanceDetails {

	private String userName;
	private String bnkName;
	private float amount;
	private String currencyName;
	
	
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the bnkName
	 */
	public String getBnkName() {
		return bnkName;
	}
	/**
	 * @param bnkName the bnkName to set
	 */
	public void setBnkName(String bnkName) {
		this.bnkName = bnkName;
	}
	/**
	 * @return the amount
	 */
	public float getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(float amount) {
		this.amount = amount;
	}
	/**
	 * @return the currencyName
	 */
	public String getCurrencyName() {
		return currencyName;
	}
	/**
	 * @param currencyName the currencyName to set
	 */
	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}
	
	
}
