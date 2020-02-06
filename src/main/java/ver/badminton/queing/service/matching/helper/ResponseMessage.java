package ver.badminton.queing.service.matching.helper;

public enum ResponseMessage {
	NOT_ENOUGH_PLAYER("Not enough player to create a match"), WAKA("");

	private String message;

	ResponseMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
