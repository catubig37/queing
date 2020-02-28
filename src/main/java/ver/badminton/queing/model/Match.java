package ver.badminton.queing.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Match {
	
	@JsonProperty("match_id")
	private int matchId;
	
	@JsonProperty("is_active")
	private boolean isActive;
	
	@JsonProperty("court_number")
	private int courtNumber;
	
	@JsonProperty("players")
	private List<Player> players;

	public int getMatchId() {
		return matchId;
	}

	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public int getCourtNumber() {
		return courtNumber;
	}

	public void setCourtNumber(int courtNumber) {
		this.courtNumber = courtNumber;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	
}
