package fr.n7.fut.model.users;

import javax.persistence.*;

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
}
