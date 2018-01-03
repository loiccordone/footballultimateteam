package fr.n7.fut.model.gamer;

import java.util.List;

import fr.n7.fut.model.players.Player;
import fr.n7.fut.model.teams.Equipe;

public class Gamer {
	private int id;
	private List<Player> effectifClub;
	private Equipe equipeActive;
	private Record record;

	public Record getRecord() {
		return record;
	}

	public void setRecord(Record record) {
		this.record = record;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Player> getEffectifClub() {
		return effectifClub;
	}

	public void setEffectifClub(List<Player> effectifClub) {
		this.effectifClub = effectifClub;
	}

	public Equipe getEquipeActive() {
		return equipeActive;
	}

	public void setEquipeActive(Equipe equipeActive) {
		this.equipeActive = equipeActive;
	}

}
