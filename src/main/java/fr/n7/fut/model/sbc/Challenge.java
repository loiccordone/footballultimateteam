package fr.n7.fut.model.sbc;

import java.util.Iterator;
import java.util.List;

import fr.n7.fut.model.equipe.Composition;

public class Challenge {
	private Composition comp;
	private List<Condition> condition;
	
	public Composition getComp() {
		return comp;
	}
	public void setComp(Composition comp) {
		this.comp = comp;
	}
	public List<Condition> getCondition() {
		return condition;
	}
	public void setCondition(List<Condition> condition) {
		this.condition = condition;
	}
	
	public boolean verifierChallenge() {
		boolean res = true;
		Iterator<Condition> icond = this.condition.iterator();
		Condition condactu;
		while (icond.hasNext()) {
			condactu = icond.next();
			res = res && condactu.verifierCondition(this.comp);
		}
		return res;
	}
}
