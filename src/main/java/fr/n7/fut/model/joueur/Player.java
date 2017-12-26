package fr.n7.fut.model.joueur;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Player {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String nom;
	private String prenom;
	@ManyToOne
	private Team equipe;
	@OneToOne
	private PlayerStat pstat;
	@OneToOne
	private GKStat gstat;
	private Position poste;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Team getEquipe() {
		return equipe;
	}
	public void setEquipe(Team equipe) {
		this.equipe = equipe;
	}
	public PlayerStat getPstat() {
		return pstat;
	}
	public void setPstat(PlayerStat pstat) {
		this.pstat = pstat;
	}
	public GKStat getGstat() {
		return gstat;
	}
	public void setGstat(GKStat gstat) {
		this.gstat = gstat;
	}
	public Position getPoste() {
		return poste;
	}
	public void setPoste(Position poste) {
		this.poste = poste;
	}
	
}
