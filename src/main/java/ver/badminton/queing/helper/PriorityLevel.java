package ver.badminton.queing.helper;

public enum PriorityLevel {
	LOW("LOW"), MEDIUM("MEDIUM"), HIGH("HIGH");
	
	String description;
	
	PriorityLevel(String description){
		this.description = description;
	}
	public String getDesc() {
		return description;
	}
	
	public static PriorityLevel getPrioEnum(String value) {
		  for (PriorityLevel priorityLevel : values()) {
				if (priorityLevel.description.equals(value)) {
					return priorityLevel;
				}
			}
			return LOW;
	}
}
