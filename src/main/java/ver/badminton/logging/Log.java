/**
 * @author vcatubig
 * Jul 29, 2019
 * Meralco Real Time Payment
 * Capgemini
 */
package ver.badminton.logging;

/**
 * Abstract class that can be inherit in different logging
 * mechanism that might introduce in this application
 */
public abstract class Log {
	private String transactionNumber;
	private String accountNumber;
	private String className;
	private String methodName;
	private LogLevel level = LogLevel.DETAIL;
	private String title;
	private String createdTime;
	private String message;
	private String jsonStr;
	
	public String getTransactionNumber() {
		return transactionNumber;
	}

	public void setTransactionNumber(String transactionNumber) {
		this.transactionNumber = transactionNumber;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public LogLevel getLevel() {
		return level;
	}

	public void setLevel(LogLevel level) {
		this.level = level;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getJsonStr() {
		return jsonStr;
	}

	public void setJsonStr(String jsonStr) {
		this.jsonStr = jsonStr;
	}

	/*
	 * By calling this it required you to filled all parameter that will assign to
	 * Log Instance Variable but before assigning it will validate first if it's
	 * should be log or not base on Config Vars in Heroku Setting.
	 */
	public void log(String transactionNumber, String accountNumber, String className, String methodName, LogLevel level,
			String title,  String message, String jsonStr) {
			this.transactionNumber = transactionNumber;
			this.accountNumber = accountNumber;
			this.className = className;
			this.methodName = methodName;
			this.level = level;
			this.title = title;
			this.message = message;
			this.jsonStr = jsonStr;
			_log(this.message);
	}
	public void reset() {
		this.transactionNumber = "";
		this.accountNumber = "";
		this.className = "";
		this.methodName = "";
		this.level = null;
		this.title = "";
		this.message = "";
		this.jsonStr = "";
		
	}

	public abstract void _log(String message);
	public abstract boolean isShouldLog(LogLevel level);
	
}
