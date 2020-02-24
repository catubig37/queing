package ver.badminton.queing.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import ver.badminton.queing.helper.PlayerLevel;
import ver.badminton.queing.helper.PriorityLevel;
import ver.badminton.queing.model.Player;
import ver.postgres.PG;

@Service
public class PlayerService {
	public String createPlayer(Player p) {
		JSONObject pgResponse = null;
		String playerId = "-1";
		try {
			pgResponse = PG.Query(String.format(
					"INSERT INTO bad.\"Player\" (alias, first_name, last_name, gender, player_level, priority_level)"
							+ "values(?, ?, ?, ?, ?, ?) RETURNING player_id"),
					new Object[] { p.getAlias(), p.getFirstName(), p.getLastName(), p.getGender(),
							"MASTER", "HIGH" })
					.getJSONObject(0);
			playerId = pgResponse.getString("player_id");
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		p.setPlayerId(null);
		return playerId;
	}
	
	public String addPlayer(String gameId, String playerId) {
		JSONObject pgResponse = null;
		try {
			pgResponse = PG.Query(
					String.format("INSERT INTO bad.\"Match\" (game_id, player_id, "
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
			return "Player Added";
		
		return "Invalid Player Possible its already Exist.";
	}
	
	public List<Player> getPlayers(String gameId) {
		List<Player> players = new ArrayList<Player>();
		JSONArray transactions = null;
		try {
			transactions = PG.Query(
					String.format(
							"SELECT * FROM bad.\"Player\" WHERE player_id "
							+ "IN (SELECT player_id FROM bad.\"Game_Player\" where game_id = ?)"),
					new Object[] { gameId});
			
			for (int i = 0; transactions != null && i < transactions.length(); i++) {
				JSONObject obj = transactions.getJSONObject(i);
				
				Player player = new Player();
				player.setAlias(obj.get("alias").toString());
				player.setFirstName(obj.get("first_name").toString());
				player.setLastName(obj.get("last_name").toString());
				player.setPriorityLevel(PriorityLevel.getPrioEnum(obj.get("priority_level").toString()));
				player.setLevel(PlayerLevel.getLevelEnum(obj.get("player_level").toString()));
				player.setGender(obj.get("gender").toString());
				player.setCreatedAt(obj.get("created_at").toString());
				player.setUpdatedAt(obj.get("updated_at").toString());
				players.add(player);
				
			}
		} catch (JSONException | SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return players;
	}
}
