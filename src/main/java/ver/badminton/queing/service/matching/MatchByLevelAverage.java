package ver.badminton.queing.service.matching;

import java.util.ArrayList;
import java.util.List;

import ver.badminton.queing.helper.PlayerLevel;
import ver.badminton.queing.model.Match;
import ver.badminton.queing.model.Player;

public class MatchByLevelAverage implements Matching{


	@Override
	public Match getMatch(List<Player> quePlayers) {
		return null;
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
