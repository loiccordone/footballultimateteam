package fr.n7.fut.model.players;

import javax.persistence.*;

@Entity
@Table(name = "football_teams")
public class FootballTeam {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_football_team")
	private int id;
	private String nom;

	@Enumerated(EnumType.STRING)
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
