package fr.n7.fut.model.players;

import javax.persistence.*;

@Entity
@Table(name = "player_stats")
public class PlayerStat {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_player_stat")
	private int id;
	private int pace;
	private int shooting;
	private int passing;
	private int dribbling;
	private int defending;
	private int physicality;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPace() {
		return pace;
	}
	public void setPace(int pace) {
		this.pace = pace;
	}
	public int getShooting() {
		return shooting;
	}
	public void setShooting(int shooting) {
		this.shooting = shooting;
	}
	public int getPassing() {
		return passing;
	}
	public void setPassing(int passing) {
		this.passing = passing;
	}
	public int getDribbling() {
		return dribbling;
	}
	public void setDribbling(int dribbling) {
		this.dribbling = dribbling;
	}
	public int getDefending() {
		return defending;
	}
	public void setDefending(int defending) {
		this.defending = defending;
	}
	public int getPhysicality() {
		return physicality;
	}
	public void setPhysicality(int physicality) {
		this.physicality = physicality;
	}
}
