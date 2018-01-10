package fr.n7.fut.model.players;

public enum Position {
	GK { @Override public String toString() { return "Gardien"; } },
	DG { @Override public String toString() { return "Défenseur Gauche"; } },
	DC { @Override public String toString() { return "Défenseur Central"; } },
	DD { @Override public String toString() { return "Défenseur Droite"; } },
	MDC { @Override public String toString() { return "Milieu Défensif"; } },
	MG { @Override public String toString() { return "Milieu Gauche"; } },
	MD { @Override public String toString() { return "Milieu Droit"; } },
	MC { @Override public String toString() { return "Milieu Central"; } },
	MOC { @Override public String toString() { return "Milieu Offensif"; } },
	BU { @Override public String toString() { return "Buteur"; } },
	AG { @Override public String toString() { return "Attaquant Gauche"; } },
	AD { @Override public String toString() { return "Attaquant Droit"; } }
}
