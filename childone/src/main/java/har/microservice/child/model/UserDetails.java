package har.microservice.child.model;

public class UserDetails {

	private String name;
	private int userId;
	private String password;
	private String secretQuestion;
	private String secretAnswer;
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the secretQuestion
	 */
	public String getSecretQuestion() {
		return secretQuestion;
	}
	/**
	 * @param secretQuestion the secretQuestion to set
	 */
	public void setSecretQuestion(String secretQuestion) {
		this.secretQuestion = secretQuestion;
	}
	/**
	 * @return the secretAnswer
	 */
	public String getSecretAnswer() {
		return secretAnswer;
	}
	/**
	 * @param secretAnswer the secretAnswer to set
	 */
	public void setSecretAnswer(String secretAnswer) {
		this.secretAnswer = secretAnswer;
	}
	
	
}
