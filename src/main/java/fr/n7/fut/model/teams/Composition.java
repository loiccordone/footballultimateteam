package fr.n7.fut.model.teams;

public abstract class Composition {
	private int collectif;
	
	public int getCollectif() {
		return collectif;
	}

	public void setCollectif(int collectif) {
		this.collectif = collectif;
	}

	public abstract int calculCollectif();
}
