package fr.n7.fut.model.equipe;

import fr.n7.fut.model.joueur.Player;
import fr.n7.fut.model.joueur.Position;
import fr.n7.fut.model.joueur.Role;

public class Titulaire {
	private int collectif;
	private Role role;
	private Position poste;
	private Player joueur;
	
	public int getCollectif() {
		return collectif;
	}
	public void setCollectif(int collectif) {
		this.collectif = collectif;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Position getPoste() {
		return poste;
	}
	public void setPoste(Position poste) {
		this.poste = poste;
	}
	public Player getJoueur() {
		return joueur;
	}
	public void setJoueur(Player joueur) {
		this.joueur = joueur;
	}
	
	public int calculCollectif (Composition comp) {
		//Not Yet Implemented
		return 0;
	}
	
}
