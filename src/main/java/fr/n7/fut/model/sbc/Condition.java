package fr.n7.fut.model.sbc;

import fr.n7.fut.model.equipe.Composition;

public abstract class Condition {
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public abstract boolean verifierCondition(Composition comp);
}
