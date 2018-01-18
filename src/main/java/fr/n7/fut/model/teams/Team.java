package fr.n7.fut.model.teams;

import java.util.Map;

import javax.persistence.*;

import fr.n7.fut.model.players.Player;
import fr.n7.fut.model.users.User;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "teams")
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_team")
	private int id;

	private int collectif = 0;

	@OneToOne(cascade = CascadeType.ALL)
	private User user;

	@Enumerated(EnumType.STRING)
	private Composition comp = Composition._433;

	@ElementCollection
	@CollectionTable(name="team_starters")
	@MapKeyColumn(name="team_starters_position")
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private Map<Integer,Starter> starters;

	@ElementCollection
	@CollectionTable(name="team_subs")
	@MapKeyColumn(name="team_subs_position")
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private Map<Integer,Player> subs;

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

	
	public Map<Integer, Starter> getStarters() {
		return starters;
	}

	public void setStarters(Map<Integer, Starter> starters) {
		this.starters = starters;
	}

	public Map<Integer, Player> getSubs() {
		return subs;
	}

	public void setSubs(Map<Integer, Player> subs) {
		this.subs = subs;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void addPlayer(Player newPlayer, int choicePlace, boolean isStarter) {
		if (isStarter) {
			this.getStarters().get(choicePlace).setJoueur(newPlayer);
		} else {
			this.getSubs().put(choicePlace,newPlayer);
		}
	}
	
	public void replacePlayer (int choiceStarter, int choiceSub) {
		Player switcher = this.getSubs().get(choiceSub);
		this.getSubs().put(choiceSub, this.getStarters().get(choiceStarter).getJoueur());
		this.getStarters().get(choiceStarter).setJoueur(switcher);
	}
	
	public void removePlayer ( int choicePlace, boolean isStarter) {
		if (isStarter) {
			this.getStarters().get(choicePlace).setJoueur(null);
		} else {
			this.getSubs().remove(choicePlace);
		}
	}
	
	public void computeChemistry() {
		int chemistry = 0;
		for (int i = 1; i <= 11; i++)  {
			this.getStarters().get(i).computeChemistry(starters, comp,i);
			chemistry = chemistry + this.getStarters().get(i).getCollectif();
		}
		this.setCollectif(Math.min(chemistry, 100));
	}
	public boolean isPlayable () {
		boolean completeStarters = this.getStarters().size()== 11;
		boolean completeSub = this.getSubs().size() == 7;
		boolean everyoneReady = true;
		for (Starter st : this.getStarters().values()) {
			everyoneReady = everyoneReady && st.isReady();
		}
		return completeStarters && completeSub && everyoneReady;
	}
	public void initTeam() {
		for (int i = 1; i <= 11 ; i++ ) {
			starters.put(i,Composition.getInitStarter(this.getComp(), i));
		}
	}

}
