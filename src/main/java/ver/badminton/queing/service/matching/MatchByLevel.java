package ver.badminton.queing.service.matching;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import ver.badminton.queing.helper.PlayerLevel;
import ver.badminton.queing.model.Match;
import ver.badminton.queing.model.Player;
import ver.badminton.queing.service.matching.helper.MatchingUtil;

public class MatchByLevel implements Matching{


	@Override
	public Match getMatch(List<Player> quePlayers) {
		List<Player> players = new ArrayList<>();

		Map<PlayerLevel, Integer> levelToPlay = new EnumMap<>(PlayerLevel.class);
		int[] playerCountPerLevel = MatchingUtil.getPlayerCountPerLevel(quePlayers);

		for (int i = 0; i < playerCountPerLevel.length; i++) {
			if (playerCountPerLevel[i] > 3) {// When it has four player with the same level.
				levelToPlay.put(PlayerLevel.values()[i], playerCountPerLevel[i]);
				break;
			}
			if (playerCountPerLevel[i] > 1) { // When Level has 2 or more player available.
				levelToPlay.put(PlayerLevel.values()[i], playerCountPerLevel[i]);
			}
		}

		boolean endCondition = false;

		for (Entry<PlayerLevel, Integer> entry : levelToPlay.entrySet()) {
			if (!endCondition) {// To avoid adding player morethan four.
				if (entry.getValue() > 3) {
					players.addAll(getPlayerByLevel(quePlayers, entry.getKey()));
					break;
				} else {
					players.addAll(getPlayerByLevel(quePlayers, entry.getKey()));
					endCondition = players.size() > 3;
				}
			}
		}

		Match match = new Match();
		match.setPlayers(players);
		match = players.size() == 4 ? match : null;
		return match;
	}
	
	private List<Player> getPlayerByLevel(List<Player> availablePlayers, PlayerLevel pLevel){
		List<Player> playerToPlay =  new ArrayList<>();
		for(Player player : availablePlayers) {
			if(player.getLevel() == pLevel) {
				playerToPlay.add(player);
			}
		}
		if(playerToPlay.size() > 3) {
			return playerToPlay;
		}else {
			List<Player> playerToPlay1  =  new ArrayList<>();
			playerToPlay1.add(playerToPlay.get(0));
			playerToPlay1.add(playerToPlay.get(1));
			return playerToPlay1;
		}
	}
}
