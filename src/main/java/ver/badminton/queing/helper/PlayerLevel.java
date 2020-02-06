package ver.badminton.queing.helper;

public enum PlayerLevel {
	WARRIOR(0, "WARRIOR"), ELITE(1, "ELITE"), MASTER(2, "MASTER"), GRANDMASTER(3, "GRANDMASTER"), EPIC(4, ""),
	LEGEND(5, ""), MYTHIC(6, "");
	private int power;
	private String desc;

	PlayerLevel(int power, String desc) {
		this.power = power;
		this.desc = desc;
	}

	public int getPower() {
		return power;
	}

	public String getDesc() {
		return desc;
	}

	public String getJson() {
		return Util.objToJson("{}");
	}

	public static PlayerLevel getLevelEnum(String value) {
		for (PlayerLevel playerLevel : values()) {
			if (playerLevel.desc.equals(value)) {
				return playerLevel;
			}
		}
		return WARRIOR;
	}
}
