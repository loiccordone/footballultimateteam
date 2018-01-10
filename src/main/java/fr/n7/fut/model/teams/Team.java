package fr.n7.fut.model.teams;

import fr.n7.fut.model.players.Player;
import javax.persistence.*;

@Entity
@Table(name = "teams")
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_team")
	private int id;

	private int collectif = 0;

	@Enumerated(EnumType.STRING)
	private Composition comp;

	@OneToOne
	private Starter titu1;
	@OneToOne
	private Starter titu2;
	@OneToOne
	private Starter titu3;
	@OneToOne
	private Starter titu4;
	@OneToOne
	private Starter titu5;
	@OneToOne
	private Starter titu6;
	@OneToOne
	private Starter titu7;
	@OneToOne
	private Starter titu8;
	@OneToOne
	private Starter titu9;
	@OneToOne
	private Starter titu10;
	@OneToOne
	private Starter titu11;
	@OneToOne
	private Player sub1;
	@OneToOne
	private Player sub2;
	@OneToOne
	private Player sub3;
	@OneToOne
	private Player sub4;
	@OneToOne
	private Player sub5;
	@OneToOne
	private Player sub6;
	@OneToOne
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

	public Starter getTitu1() {
		return titu1;
	}

	public void setTitu1(Starter titu1) {
		this.titu1 = titu1;
	}

	public Starter getTitu2() {
		return titu2;
	}

	public void setTitu2(Starter titu2) {
		this.titu2 = titu2;
	}

	public Starter getTitu3() {
		return titu3;
	}

	public void setTitu3(Starter titu3) {
		this.titu3 = titu3;
	}

	public Starter getTitu4() {
		return titu4;
	}

	public void setTitu4(Starter titu4) {
		this.titu4 = titu4;
	}

	public Starter getTitu5() {
		return titu5;
	}

	public void setTitu5(Starter titu5) {
		this.titu5 = titu5;
	}

	public Starter getTitu6() {
		return titu6;
	}

	public void setTitu6(Starter titu6) {
		this.titu6 = titu6;
	}

	public Starter getTitu7() {
		return titu7;
	}

	public void setTitu7(Starter titu7) {
		this.titu7 = titu7;
	}

	public Starter getTitu8() {
		return titu8;
	}

	public void setTitu8(Starter titu8) {
		this.titu8 = titu8;
	}

	public Starter getTitu9() {
		return titu9;
	}

	public void setTitu9(Starter titu9) {
		this.titu9 = titu9;
	}

	public Starter getTitu10() {
		return titu10;
	}

	public void setTitu10(Starter titu10) {
		this.titu10 = titu10;
	}

	public Starter getTitu11() {
		return titu11;
	}

	public void setTitu11(Starter titu11) {
		this.titu11 = titu11;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
