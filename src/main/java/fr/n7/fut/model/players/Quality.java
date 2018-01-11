package fr.n7.fut.model.players;

public enum Quality {
	Bronze { @Override public String toString() { return "Bronze"; } },
	Silver { @Override public String toString() { return "Silver"; } },
	Gold { @Override public String toString() { return "Gold"; } },
	OnFire { @Override public String toString() { return "OnFire"; } }
}
