package fr.n7.fut.model.games;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import fr.n7.fut.model.players.FieldRole;
import fr.n7.fut.model.teams.Starter;
import fr.n7.fut.model.teams.Team;
import fr.n7.fut.model.users.User;

@Entity
@Table(name = "games")
public class Game {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_game")
	private int id;

	@OneToOne
	private User homePlayer;

	@OneToOne
	private User awayPlayer;

	@Column(name = "score_home_player")
	private int scoreHomePlayer;

	@Column(name = "score_away_player")
	private int scoreAwayPlayer;

 User getHomePlayer() {
		return homePlayer;
	}

	public void setHomePlayer(User homePlayer) {
		this.homePlayer = homePlayer;
	}

	public User getAwayPlayer() {
		return awayPlayer;
	}

	public void setAwayPlayer(User awayPlayer) {
		this.awayPlayer = awayPlayer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getScoreHomePlayer() {
		return scoreHomePlayer;
	}

	public void setScoreHomePlayer(int scoreHomePlayer) {
		this.scoreHomePlayer = scoreHomePlayer;
	}

	public int getScoreAwayPlayer() {
		return scoreAwayPlayer;
	}

	public void setScoreAwayPlayer(int scoreAwayPlayer) {
		this.scoreAwayPlayer = scoreAwayPlayer;
	}

	public void computeScore() {
		Team hometeam = homePlayer.getActiveTeam();
		Team awayteam = awayPlayer.getActiveTeam();

		for (int i = 0; i < 5; i++) {
			this.scoreHomePlayer = this.scoreHomePlayer + computeAttack(hometeam, awayteam);
			this.scoreAwayPlayer = this.scoreAwayPlayer + computeAttack(awayteam, hometeam);
		}
	}

	public int computeAttack(Team attacking, Team defending) {
		int res = 0;
		int attChemistry = attacking.getCollectif();
		int defChemistry = defending.getCollectif();

		Map<Integer, Starter> attackingStarter = attacking.getStarters();
		Map<Integer, Starter> defendingStarter = defending.getStarters();

		/* Compute the avg rating of the attack and the defense */
		int attRating = 0;
		int nbAtt = 0;
		int defRating = 0;
		int nbDef = 0;
		for (Starter st : attackingStarter.values()) {
			if (st.getFieldRole().equals(FieldRole.MIL) || st.getFieldRole().equals(FieldRole.ATT)) {
				attRating = attRating + st.getJoueur().getGlobalNote();
				nbAtt++;
			}
		}

		for (Starter st : defendingStarter.values()) {
			if (st.getFieldRole().equals(FieldRole.DEF) || st.getFieldRole().equals(FieldRole.GK)) {
				defRating = defRating + st.getJoueur().getGlobalNote();
				nbDef++;
			}
		}

		attRating = attRating / nbAtt * attChemistry / 100;
		defRating = defRating / nbDef * defChemistry / 100;

		if (attRating > defRating) {
			res = 1;
		}

		return res;
	}

	public Game(User homePlayer, User awayPlayer) {
		super();
		this.homePlayer = homePlayer;
		this.awayPlayer = awayPlayer;
	}
	
}
