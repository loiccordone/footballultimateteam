package fr.n7.fut.model.users;

import javax.persistence.*;

import fr.n7.fut.model.games.Game;

@Entity
@Table(name = "records")
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_record")
    private int id;
	private int wins;
	private int draws;
	private int losses;
	@Column(name = "goals_scored")
	private int goalsScored;
	@Column(name = "goals_taken")
	private int goalsTaken;
	
	public int getWins() {
		return wins;
	}
	public void setWins(int wins) {
		this.wins = wins;
	}
	public int getDraws() {
		return draws;
	}
	public void setDraws(int draws) {
		this.draws = draws;
	}
	public int getLosses() {
		return losses;
	}
	public void setLosses(int losses) {
		this.losses = losses;
	}
	public int getGoalsScored() {
		return goalsScored;
	}
	public void setGoalsScored(int goalsScored) {
		this.goalsScored = goalsScored;
	}
	public int getGoalsTaken() {
		return goalsTaken;
	}
	public void setGoalsTaken(int goalsTaken) {
		this.goalsTaken = goalsTaken;
	}
	public void majRecord(Game game) {
		this.setGoalsScored(this.getGoalsScored()+game.getScoreHomePlayer());
		this.setGoalsTaken(this.getGoalsTaken()+game.getScoreAwayPlayer());
		if (game.getScoreAwayPlayer() < game.getScoreHomePlayer()) {
			this.setWins(this.getWins()+1);
		} else if (game.getScoreAwayPlayer() > game.getScoreHomePlayer()) {
			this.setLosses(this.getLosses()+1);
		} else {
			this.setDraws(this.getDraws()+1);
		}
		
	}
}
