package fr.n7.fut.model.joueur;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class PlayerStat {
	@Id
	private int id_player;
	private int pace;
	private int shooting;
	private int passing;
	private int dribbling;
	private int defending;
	private int physicality;
	
	public int getId_player() {
		return id_player;
	}
	public void setId_player(int id_player) {
		this.id_player = id_player;
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
