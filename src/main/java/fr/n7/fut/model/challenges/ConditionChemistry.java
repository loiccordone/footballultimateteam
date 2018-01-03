package fr.n7.fut.model.challenges;

import fr.n7.fut.model.teams.Composition;

public class ConditionChemistry extends Condition {
	private int chemistryNeeded;

	public ConditionChemistry(String description, int chemistryNeeded) {
		super(description);
		this.chemistryNeeded = chemistryNeeded;
	}

	@Override
	public boolean verifierCondition(Composition comp) {
		return (comp.getCollectif() >= this.chemistryNeeded);
	}

}
