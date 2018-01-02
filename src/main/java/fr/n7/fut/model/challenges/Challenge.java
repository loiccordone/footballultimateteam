package fr.n7.fut.model.challenges;

import java.util.Iterator;
import java.util.List;

import fr.n7.fut.model.teams.Composition;

public class Challenge {
	private Composition comp;
	private List<Condition> conditions;
	
	public Composition getComp() {
		return comp;
	}
	public void setComp(Composition comp) {
		this.comp = comp;
	}
	public List<Condition> getConditions() {
		return conditions;
	}
	public void setConditions(List<Condition> conditions) {
		this.conditions = conditions;
	}
	
	public boolean verifierChallenge() {
		boolean res = true;
		Iterator<Condition> icond = this.conditions.iterator();
		Condition condactu;
		while (icond.hasNext()) {
			condactu = icond.next();
			res = res && condactu.verifierCondition(this.comp);
		}
		return res;
	}
}
