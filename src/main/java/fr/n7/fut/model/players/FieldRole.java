package fr.n7.fut.model.players;

public enum FieldRole {
	GK { @Override public String toString() { return "Gardien"; } },
	DEF { @Override public String toString() { return "Défenseur"; } },
	MIL { @Override public String toString() { return "Milieu"; } },
	ATT { @Override public String toString() { return "Attaquant"; } }
}
