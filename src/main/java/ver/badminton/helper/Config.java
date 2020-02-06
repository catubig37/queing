package ver.badminton.helper;

/**
 * @author vcatubig
 */
public class Config {
	/**
	 * DATABASE RELATED
	 */
	public static final String TARGET_RTP_SCHEMA;
	public static final String TARGET_CXE_SCHEMA;
	
	/**
	 * IIB CALL RELATED
	 */
	public static final String GRANT_TYPE;
	public static final String SCOPE;
	public static final String CLIENT_ID;
	public static final String CLIENT_SECRET;
	public static final String GET_TOKEN_DOMAIN;
	public static final String PAYMENT_DOMAIN;
	public static final String BC_USER_ID;
	public static final String ACCOUNT_INQUIRY;
	/**
	 * SPRING SECURITY
	 */
	public static final String SPRING_USER;
	public static final String SPRING_PASS;

	public static final String MECOM_AUTH;
	public static final String MECOM_CALLBACK_URL;
	/**
	 * LOGGING
	 */
	public static final int CONSOLE_LOG_LEVEL;
	public static final int DB_LOG_LEVEL;
	public static final int POSTING_RETRY_COUNT;
	/**
	 * PAYMENT POSTING RETRY COUNT
	 */
	public static final int PENDING_RETRY_COUNT;
	public static final int FAILED_RETRY_COUNT;
	public static final String PENDING_RETRY_INTERVAL;
	public static final String FAILED_RETRY_INTERVAL;
	
	static {
		//DATABASE RELATED
		TARGET_RTP_SCHEMA = System.getenv("PG_RTP_SCHEMA") == null ? "rtp" : System.getenv("PG_RTP_SCHEMA");
		TARGET_CXE_SCHEMA = System.getenv("PG_CXE_SCHEMA") == null ? "uat" : System.getenv("PG_CXE_SCHEMA");
		
		//IIB CALL RELATED
		//Get Token Related
		GRANT_TYPE = System.getenv("IIB_GRANT_TYPE") == null ? "client_credentials" : System.getenv("IIB_GRANT_TYPE");
		SCOPE = System.getenv("IIB_SCOPE") == null ? "/env/acceptance/customer/paymentPosting" : System.getenv("IIB_SCOPE");
		CLIENT_ID = System.getenv("IIB_CLIENT_ID") == null ? "heroku-cxe-oauth-client" : System.getenv("IIB_CLIENT_ID");
		CLIENT_SECRET = System.getenv("IIB_CLIENT_SECRET") == null ? "01bf46f783b94467a7b84fd1fc42a5c9" : System.getenv("IIB_CLIENT_SECRET");
		//Posting and Inquiry, Related
		GET_TOKEN_DOMAIN = System.getenv("IIB_DOMAIN") == null ? "https://api-dev.meralco.com.ph/v1/auth/PaymentPosting" : System.getenv("IIB_DOMAIN");
		PAYMENT_DOMAIN = System.getenv("IIB_PAYMENT_DOMAIN") == null ? "https://api-dev.meralco.com.ph/env/acceptance/customer/paymentPosting" : System.getenv("IIB_PAYMENT_DOMAIN");
		BC_USER_ID = System.getenv("BC_USER_ID") == null ? "7777" : System.getenv("BC_USER_ID");
		ACCOUNT_INQUIRY =  System.getenv("ACCOUNT_INQUIRY") == null ? "/accountInquiry" : System.getenv("ACCOUNT_INQUIRY"); 

		//SPRING SECURITY
		SPRING_USER = System.getenv("SPRING_USER") == null ? "MERALCOBRPT" : System.getenv("SPRING_USER");
		SPRING_PASS = System.getenv("SPRING_PASS") == null ? "112BB791304791DDCF692E29FD5CF149B35FEA37" : System.getenv("SPRING_PASS");

		//SPRING SECURITY
		MECOM_AUTH = System.getenv("MECOM_AUTH") == null ? "Basic YjdkOTNhNTEtNDM1OS00MDNjLWE2NGMtZjQxYTgyYzM5MTBmOnNlY3JldA==" : System.getenv("MECOM_AUTH");
		MECOM_CALLBACK_URL = System.getenv("MECOM_CALLBACK_URL") == null ? "https://meralco-rtp.multidemos.com/api/v1/transactions/" : System.getenv("MECOM_CALLBACK_URL");
		
		CONSOLE_LOG_LEVEL = System.getenv("CONSOLE_LOG_LEVEL") == null ? 0 : Integer.parseInt(System.getenv("CONSOLE_LOG_LEVEL"));
		DB_LOG_LEVEL = System.getenv("DB_LOG_LEVEL") == null ? 0 : Integer.parseInt(System.getenv("DB_LOG_LEVEL"));
		POSTING_RETRY_COUNT = System.getenv("POSTING_RETRY_COUNT") == null ? 3 : Integer.parseInt(System.getenv("POSTING_RETRY_COUNT"));
		
		//PAYMENT POSTING
		PENDING_RETRY_COUNT  = System.getenv("PENDING_RETRY_COUNT") == null ? 3 : Integer.parseInt(System.getenv("PENDING_RETRY_COUNT"));
		FAILED_RETRY_COUNT = System.getenv("FAILED_RETRY_COUNT") == null ? 1 : Integer.parseInt(System.getenv("FAILED_RETRY_COUNT"));
		PENDING_RETRY_INTERVAL = System.getenv("PENDING_RETRY_INTERVAL") == null ? "5 minutes" : System.getenv("PENDING_RETRY_INTERVAL"); 
		FAILED_RETRY_INTERVAL = System.getenv("FAILED_RETRY_INTERVAL") == null ? "30 minutes" : System.getenv("FAILED_RETRY_INTERVAL"); 
	}
}
