package ver.badminton.queing.helper;

public enum PlayerStatus {
	PENDING("Pending"), QUEUED("Queued"), IN_GAME("In-game");
	
	String description;
	
	PlayerStatus(String description){
		this.description = description;
	}
	public String getDesc() {
		return description;
	}
	
	public static PlayerStatus getStatus(String value) {
		  for (PlayerStatus status : values()) {
				if (status.description.equals(value)) {
					return status;
				}
			}
		return PENDING;
	}
}
