package fr.n7.fut.model.challenges;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import fr.n7.fut.model.players.FootballTeam;
import fr.n7.fut.model.players.League;
import fr.n7.fut.model.players.Nation;
import fr.n7.fut.model.teams.Composition;
import javafx.util.Pair;

@Entity
@Table(name = "challenges")
public class Challenge {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_challenge")
	private int id;

	@Enumerated(EnumType.STRING)
	private Composition comp;

	@Column(name = "chemistryNeeded")
	private int chemistryNeeded;

	@Column(name = "nbPlayersSameNation")
	private Pair<Integer,Nation> nbPlayersSameNation;

	@Column(name = "nbPlayersSameLeague")
	private Pair<Integer,League> nbPlayersSameLeague;

	@Column(name = "nbPlayersSameTeam")
	private Pair<Integer,FootballTeam> nbPlayersSameTeam;
	
	public Composition getComp() {
		return comp;
	}

	public void setComp(Composition comp) {
		this.comp = comp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getChemistryNeeded() {
		return chemistryNeeded;
	}

	public void setChemistryNeeded(int chemistryNeeded) {
		this.chemistryNeeded = chemistryNeeded;
	}

	public Pair<Integer, Nation> getNbPlayersSameNation() {
		return nbPlayersSameNation;
	}

	public void setNbPlayersSameNation(Pair<Integer, Nation> nbPlayersSameNation) {
		this.nbPlayersSameNation = nbPlayersSameNation;
	}

	public Pair<Integer, League> getNbPlayersSameLeague() {
		return nbPlayersSameLeague;
	}

	public void setNbPlayersSameLeague(Pair<Integer, League> nbPlayersSameLeague) {
		this.nbPlayersSameLeague = nbPlayersSameLeague;
	}

	public Pair<Integer, FootballTeam> getNbPlayersSameTeam() {
		return nbPlayersSameTeam;
	}

	public void setNbPlayersSameTeam(Pair<Integer, FootballTeam> nbPlayersSameTeam) {
		this.nbPlayersSameTeam = nbPlayersSameTeam;
	}
}
