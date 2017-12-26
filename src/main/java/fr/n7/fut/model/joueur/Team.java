package fr.n7.fut.model.joueur;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Team {
	@Id
	private int id;
	private String nom;
	@ManyToOne
	private League championnat;
	
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
	public League getChampionnat() {
		return championnat;
	}
	public void setChampionnat(League championnat) {
		this.championnat = championnat;
	}
	
}
