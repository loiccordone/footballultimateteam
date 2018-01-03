package fr.n7.fut.model.games;

import fr.n7.fut.model.gamer.Gamer;

public class Game {
	private Gamer homePlayer;
	private Gamer awayPlayer;

	public Gamer getHomePlayer() {
		return homePlayer;
	}

	public void setHomePlayer(Gamer homePlayer) {
		this.homePlayer = homePlayer;
	}

	public Gamer getAwayPlayer() {
		return awayPlayer;
	}

	public void setAwayPlayer(Gamer awayPlayer) {
		this.awayPlayer = awayPlayer;
	}

	public void computeScore() {
		/*Not Yet Implemented*/
	}

}
