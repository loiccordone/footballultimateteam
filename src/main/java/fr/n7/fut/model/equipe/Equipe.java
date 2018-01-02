package fr.n7.fut.model.equipe;

import fr.n7.fut.model.joueur.Player;

public class Equipe {
	private int collectif;
	private Composition comp;
	private Player sub1;
	private Player sub2;
	private Player sub3;
	private Player sub4;
	private Player sub5;
	private Player sub6;
	private Player sub7;

	public int getCollectif() {
		return collectif;
	}

	public void setCollectif(int collectif) {
		this.collectif = collectif;
	}

	public Composition getComp() {
		return comp;
	}

	public void setComp(Composition comp) {
		this.comp = comp;
	}

	public Player getSub1() {
		return sub1;
	}

	public void setSub1(Player sub1) {
		this.sub1 = sub1;
	}

	public Player getSub2() {
		return sub2;
	}

	public void setSub2(Player sub2) {
		this.sub2 = sub2;
	}

	public Player getSub3() {
		return sub3;
	}

	public void setSub3(Player sub3) {
		this.sub3 = sub3;
	}

	public Player getSub4() {
		return sub4;
	}

	public void setSub4(Player sub4) {
		this.sub4 = sub4;
	}

	public Player getSub5() {
		return sub5;
	}

	public void setSub5(Player sub5) {
		this.sub5 = sub5;
	}

	public Player getSub6() {
		return sub6;
	}

	public void setSub6(Player sub6) {
		this.sub6 = sub6;
	}

	public Player getSub7() {
		return sub7;
	}

	public void setSub7(Player sub7) {
		this.sub7 = sub7;
	}
	
	public int calculCollectif() {
		//Not Yet Implemented
		return 0;
	}


}
