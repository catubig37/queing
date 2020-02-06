package ver.badminton.queing.model;

import java.util.List;

public class Game {
	
	String gameId;
	boolean isActive;
	String date;
	String queMaster;
	
	List<Match> matches;
	List<Player> players;

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public String getGameId() {
		return gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getQueMaster() {
		return queMaster;
	}

	public void setQueMaster(String queMaster) {
		this.queMaster = queMaster;
	}

	public List<Match> getMatches() {
		return matches;
	}

	public void setMatches(List<Match> matches) {
		this.matches = matches;
	}
}
