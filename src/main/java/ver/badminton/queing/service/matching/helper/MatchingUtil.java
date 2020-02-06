package ver.badminton.queing.service.matching.helper;

import java.util.List;

import ver.badminton.queing.model.Player;

public class MatchingUtil {
	private MatchingUtil() {
		throw new IllegalStateException("Utility class");
	}

	public static int[] getPlayerCountPerLevel(List<Player> availablePlayers) {

		int[] playerCountPerLevel = { 0, 0, 0, 0, 0, 0, 0 };
		for (Player player : availablePlayers) {
			switch (player.getLevel()) {
			case WARRIOR:
				playerCountPerLevel[0] += 1;
				break;
			case ELITE:
				playerCountPerLevel[1] += 1;
				break;
			case MASTER:
				playerCountPerLevel[2] += 1;
				break;
			case GRANDMASTER:
				playerCountPerLevel[3] += 1;
				break;
			case EPIC:
				playerCountPerLevel[4] += 1;
				break;
			case LEGEND:
				playerCountPerLevel[5] += 1;
				break;
			case MYTHIC:
				playerCountPerLevel[6] += 1;
				break;
			}
		}

		return playerCountPerLevel;
	}
}
