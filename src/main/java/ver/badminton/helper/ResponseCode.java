package ver.badminton.helper;

public enum ResponseCode {
	VALIDATED("200", "SUCCESS", "SUCCESS"),
	FIELD_REQUIRED("001", "PAYMENT_VALIDATION", "All Payload Field is required."),
	DUPLICATE_REF_NUMBER("002", "PAYMENT_VALIDATION", "Duplicate payment reference number."),
	PAYMENT_NOT_EXIST("003", "PAYMENT INQUIRY", "A payment transaction number can't be found."),
	INVALID_AMOUNT("004", "PAYMENT VALIDATION", "Payment amount should be greater than zero."),
	DISCLAIMER_IS_FALSE("005", "PAYMENT VALIDATION", "Disclaimer must be set true to be valid payment."),
	PAYMENT_ALREADY_EXIST("006", "PAYMENT VALIDATION", "A payment transaction number already exist"),
	INTERNAL_SQL_EXCEPTION("007", "PAYMENT VALIDATION", "Got SQL exception upon payment validation"),
	ACCOUNT_ACTIVE("008", "ACCOUNT INQUIRY", "ACTIVE"),
	ACCOUNT_NOT_EXIST("009", "ACCOUNT INQUIRY", "Account number specified does not exist."),
	ACCT_PENDING_OR_DISCON("010", "ACCOUNT INQUIRY", "Account number specified is pending/already disconnected."),
	PAYMENT_METHOD_NOT_EXIST("011", "PAYMENT VALIDATION", "Payment method not exist"),
	PAYMENT_CHANNEL_NOT_EXIST("012", "PAYMENT VALIDATION", "Payment channel not exist");

	ResponseCode(String code, String title, String message) {
		this.code = code;
		this.status = title;
		this.message = message;
	}

	private final String code;
	private final String status;
	private final String message;

	public String getCode() {
		return code;
	}

	public String getTitle() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public String getJson() {
		return "{\"code\":\"" + code + "\",\"message\":\"" + message + "\"}";
	}
}
