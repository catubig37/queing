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
	
	static {
		//DATABASE RELATED
		TARGET_RTP_SCHEMA = System.getenv("PG_RTP_SCHEMA") == null ? "rtp" : System.getenv("PG_RTP_SCHEMA");
		TARGET_CXE_SCHEMA = System.getenv("PG_CXE_SCHEMA") == null ? "uat" : System.getenv("PG_CXE_SCHEMA");
	
		//SPRING SECURITY
		SPRING_USER = System.getenv("SPRING_USER") == null ? "MERALCOBRPT" : System.getenv("SPRING_USER");
		SPRING_PASS = System.getenv("SPRING_PASS") == null ? "112BB791304791DDCF692E29FD5CF149B35FEA37" : System.getenv("SPRING_PASS");

		//SPRING SECURITY
		MECOM_AUTH = System.getenv("MECOM_AUTH") == null ? "Basic YjdkOTNhNTEtNDM1OS00MDNjLWE2NGMtZjQxYTgyYzM5MTBmOnNlY3JldA==" : System.getenv("MECOM_AUTH");
		MECOM_CALLBACK_URL = System.getenv("MECOM_CALLBACK_URL") == null ? "https://meralco-rtp.multidemos.com/api/v1/transactions/" : System.getenv("MECOM_CALLBACK_URL");
		
		CONSOLE_LOG_LEVEL = System.getenv("CONSOLE_LOG_LEVEL") == null ? 0 : Integer.parseInt(System.getenv("CONSOLE_LOG_LEVEL"));
		DB_LOG_LEVEL = System.getenv("DB_LOG_LEVEL") == null ? 0 : Integer.parseInt(System.getenv("DB_LOG_LEVEL"));
	}
}
