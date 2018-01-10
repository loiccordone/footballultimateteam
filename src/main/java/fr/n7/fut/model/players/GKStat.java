package fr.n7.fut.model.players;

import javax.persistence.*;

@Entity
@Table(name = "gk_stats")
public class GKStat {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_gk_stat")
	private int id;
	private int diving;
	private int handling;
	private int kicking;
	private int reflexes;
	private int speed;
	private int positioning;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
