package fr.n7.fut.model.games;

import fr.n7.fut.model.users.User;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

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
}
