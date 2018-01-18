package fr.n7.fut.model.teams;

import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import fr.n7.fut.model.players.FieldRole;
import fr.n7.fut.model.players.Player;
import fr.n7.fut.model.players.Position;

@Entity
@Table(name = "starters")
public class Starter {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name = "id_starter")
	private int id;

	private int collectif;

	@Enumerated(EnumType.STRING)
	private FieldRole fieldRole;

	@Enumerated(EnumType.STRING)
	private Position position;

	@OneToOne
	private Player joueur;

	public Starter (FieldRole fieldRole, Position position, Player joueur) {
		this.fieldRole = fieldRole;
		this.position = position;
		this.joueur = joueur;
	}
	
	public int getCollectif() {
		return collectif;
	}
	public void setCollectif(int collectif) {
		this.collectif = collectif;
	}
	public FieldRole getFieldRole() {
		return fieldRole;
	}
	public void setFieldRole(FieldRole fieldRole) {
		this.fieldRole = fieldRole;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public Player getJoueur() {
		return joueur;
	}
	public void setJoueur(Player joueur) {
		this.joueur = joueur;
	}

	public boolean isReady () {
		return this.getJoueur() != null;
	}
}
