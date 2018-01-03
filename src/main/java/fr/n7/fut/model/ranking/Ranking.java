package fr.n7.fut.model.ranking;

import java.util.Map;
import fr.n7.fut.model.players.Player;

public class Ranking {
	private Map<Integer, Player> ranks;

	public Map<Integer, Player> getRanks() {
		return ranks;
	}

	public void setRanks(Map<Integer, Player> ranks) {
		this.ranks = ranks;
	}

	public void updateRanking() {
		/* Not Yet implemented */
	}
}
