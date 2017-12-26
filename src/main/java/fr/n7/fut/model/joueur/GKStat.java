package fr.n7.fut.model.joueur;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GKStat {
	@Id
	private int id_player;
	private int diving;
	private int handling;
	private int kicking;
	private int reflexes;
	private int speed;
	private int positioning;
	
	public int getId_player() {
		return id_player;
	}
	public void setId_player(int id_player) {
		this.id_player = id_player;
	}
	public int getDiving() {
		return diving;
	}
	public void setDiving(int diving) {
		this.diving = diving;
	}
	public int getHandling() {
		return handling;
	}
	public void setHandling(int handling) {
		this.handling = handling;
	}
	public int getKicking() {
		return kicking;
	}
	public void setKicking(int kicking) {
		this.kicking = kicking;
	}
	public int getReflexes() {
		return reflexes;
	}
	public void setReflexes(int reflexes) {
		this.reflexes = reflexes;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getPositioning() {
		return positioning;
	}
	public void setPositioning(int positioning) {
		this.positioning = positioning;
	}
	
	
}
