package fr.n7.fut.model.games;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

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

	@CreatedDate
	private Date date;

	public User getHomePlayer() {
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public void computeScore() {
		Team hometeam = homePlayer.getActiveTeam();
		Team awayteam = awayPlayer.getActiveTeam();
		
		for (int i = 0; i<5; i++) {
			this.scoreHomePlayer = this.scoreHomePlayer + computeAttack(hometeam,awayteam);
			this.scoreAwayPlayer = this.scoreAwayPlayer + computeAttack(awayteam,hometeam);
		}
	}
	
	public int computeAttack (Team attacking, Team defending) {
		int attChemistry = attacking.getCollectif();
		int defChemistry = defending.getCollectif();
		
		//To do
		return 0;
	}
}
