package ver.badminton.queing.service.matching;

import java.util.ArrayList;
import java.util.List;

import ver.badminton.queing.model.Match;
import ver.badminton.queing.model.Player;

public interface Matching {
	public abstract Match getMatch(List<Player> availablePlayers);
	
	public static List<Matching> getMatching(){
		List<Matching> matchList = new ArrayList<>();
		matchList.add(new MatchByLevel());
		matchList.add(new MatchByRandom());
		return matchList;
	}
}
