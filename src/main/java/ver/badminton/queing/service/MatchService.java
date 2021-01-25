package ver.badminton.queing.service;

import java.sql.SQLException;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ver.badminton.queing.model.Match;
import ver.badminton.queing.model.Player;
import ver.badminton.queing.service.matching.Matching;
import ver.postgres.PG;

@Service
public class MatchService {
	
	@Autowired
	PlayerService playerService;
	
	public String queMatch(String gameID, Match match) {
		JSONObject pgResponse = null;
		String matchId = null;
		try {
			pgResponse = PG.Query(
					String.format("INSERT INTO bad.\"Match\" (match_id, game_id, is_active, court_number"
							+ "created_at, updated_at)"
							+ "values(?, ?, ?, ?, NOW(), NOW()) match_id"),
					new Object[] {gameID, match.getMatchId(), match.isActive()})
					.getJSONObject(0);
			
			matchId = pgResponse.getString("match_id");
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return  matchId;
	}
	public Match getMatch(String gameId) {
		Match match = null;
		List<Player> players = playerService.getPlayers(gameId);
		if (players != null && players.size() > 3) {
			for (Matching matching : Matching.getMatching()) {
				match = matching.getMatch(players);
				if (match != null)
					return match;
			}
		}
		return match;
	}
}
