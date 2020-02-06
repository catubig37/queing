package ver.badminton.queing.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import ver.badminton.queing.helper.PlayerLevel;
import ver.badminton.queing.helper.PriorityLevel;
import ver.badminton.queing.service.matching.helper.Util;

public class Player {

	@JsonProperty("player_id")
	private String playerId;

	@JsonProperty("first_name")
	private String firstName;

	@JsonProperty("last_name")
	private String lastName;

	@JsonProperty("priority_level")
	private PriorityLevel priorityLevel;

	@JsonProperty("player_level")
	private PlayerLevel level;

	@JsonProperty("gender")
	private String gender;

	@JsonProperty("alias")
	private String alias;
	
	@JsonProperty("created_at")
	private String createdAt;
	
	@JsonProperty("updated_at")
	private String updatedAt;

	public static void main(String[] args) {
		System.out.println(Util.objToJson(new Player()));
	}

//	public Player(String alias, PlayerLevel level, SEX gender) {
//		super();
//		this.alias = alias;
//		this.level = level;
//		this.gender = gender;
//		this.priorityLevel = PriorityLevel.lOW;
//	}

	public String getPlayerId() {
		return playerId;
	}

	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public PlayerLevel getLevel() {
		return level;
	}

	public void setLevel(PlayerLevel level) {
		this.level = level;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public PriorityLevel getPriorityLevel() {
		return priorityLevel;
	}

	public void setPriorityLevel(PriorityLevel priorityLevel) {
		this.priorityLevel = priorityLevel;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

}
