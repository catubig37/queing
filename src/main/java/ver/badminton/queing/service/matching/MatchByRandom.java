package ver.badminton.queing.service.matching;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ver.badminton.queing.model.Match;
import ver.badminton.queing.model.Player;

public class MatchByRandom implements Matching{

	@Override
	public Match getMatch(List<Player> quePlayers) {
		
		System.out.println("player size! "+ quePlayers.size());
			Match match = new Match();
			List<Player> players = new ArrayList<>();
			
			for(int i = 0; i < 4; i++) {
				int randomIndex = new Random().nextInt(quePlayers.size());
				players.add(quePlayers.get(randomIndex));
				quePlayers.remove(randomIndex);
			}
			match.setPlayers(players);
			match = players.size() == 4 ? match : null;
			return match;
		
	}

}
