package ver.badminton.queing.model;

import java.util.List;

public class Match {
	int matchId;
	int courtNumber;
	List<Player> players;
	public int getMatchId() {
		return matchId;
	}
	public void setMatchId(int matchId) {
		this.matchId = matchId;
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
