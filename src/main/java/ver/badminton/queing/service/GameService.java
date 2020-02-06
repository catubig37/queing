package ver.badminton.queing.service;

import java.sql.SQLException;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ver.badminton.queing.model.Game;
import ver.badminton.queing.model.Match;
import ver.badminton.queing.model.Player;
import ver.badminton.queing.service.matching.Matching;
import ver.postgres.PG;

@Service
public class GameService {

	@Autowired
	PlayerService playerService;
	
	public Game createGame(Game game) {
		JSONObject pgResponse = null;
		try {
			pgResponse = PG.Query(
					String.format("INSERT INTO bad.\"Game\" (is_active, que_master, "
							+ "created_at, updated_at)"
							+ "values("+ game.isActive() + ", '" + game.getQueMaster()+"', NOW(), NOW()) RETURNING *"),
					new Object[] {})
					.getJSONObject(0);
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (pgResponse != null)
			game.setGameId(pgResponse.getString("game_id"));
		
		return game;
	}
	
	public String addGamePlayer(String gameId, String playerId) {
		JSONObject pgResponse = null;
		try {
			pgResponse = PG.Query(
					String.format("INSERT INTO bad.\"Game_Player\" (game_id, player_id, "
							+ "created_at, updated_at)"
							+ "values(?, ?, NOW(), NOW()) RETURNING *"),
					new Object[] {gameId, playerId})
					.getJSONObject(0);
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (pgResponse != null)
			return "Player Added To Game: " + gameId;
		
		return "Invalid Player Possible its already Existin Game:" + gameId;
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
//	public static void main(String[] args) {
//		QueService s = new QueService();
//
//		List<Player> benchPlayers = new ArrayList<Player>();
//		benchPlayers.add(new Player("Ver", PlayerLevel.MYTHIC, SEX.MALE));
//		benchPlayers.add(new Player("Paul", PlayerLevel.EPIC, SEX.MALE));
//		benchPlayers.add(new Player("Arvin", PlayerLevel.MYTHIC, SEX.MALE));
//		benchPlayers.add(new Player("Giron", PlayerLevel.MASTER, SEX.MALE));
//		benchPlayers.add(new Player("Gil", PlayerLevel.EPIC, SEX.MALE));
//		benchPlayers.add(new Player("Cath", PlayerLevel.ELITE, SEX.FEMALE));
////		benchPlayers.add(new Player("Aims", PlayerLevel.ELITE, SEX.FEMALE));
//		benchPlayers.add(new Player("Vince", PlayerLevel.MASTER, SEX.FEMALE));
////		System.out.println(Util.objToJson(s.getmatch(benchPlayers)));
//		
//		
//		Game game = new Game();
//		game.setActive(true);
//		game.setDate("09062019");
//		game.setQueMaster("P32132132");
//		System.out.println(Util.objToJson(game));
//	}
//	public Match getmatch(List<Player> benchPlayers) {
//		if (benchPlayers.size() > 2) {
//			for (Matching matching : Matching.getMatching()) {
//				Match match = matching.getMatch(benchPlayers);
//				if (match != null) {
//					return match;
//				}
//			}
//		}
//		return null;
//	}
}