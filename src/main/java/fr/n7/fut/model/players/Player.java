package fr.n7.fut.model.players;

import javax.persistence.*;

@Entity
@Table(name = "players")
public class Player {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_player")
	private int id;

	private String nom;
	private String prenom;

	@ManyToOne
	private FootballTeam footballTeam;

	@Enumerated(EnumType.STRING)
	private Nation nation;
	@OneToOne
	private PlayerStat pstat;

	@OneToOne
	private GKStat gstat;

	@Enumerated(EnumType.STRING)
	private Position position;

	@Enumerated(EnumType.STRING)
	private FieldRole fieldRole;

	private int price;
	private int globalNote;
	private Quality quality;
	private String urlImage;
	
	public String getUrlImage() {
		return urlImage;
	}
	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}
	public Quality getQuality() {
		return quality;
	}
	public void setQuality(Quality quality) {
		this.quality = quality;
	}
	public FieldRole getFieldRole() {
		return fieldRole;
	}
	public void setFieldRole(FieldRole fieldRole) {
		this.fieldRole = fieldRole;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public FootballTeam getFootballTeam() {
		return footballTeam;
	}
	public void setFootballTeam(FootballTeam footballTeam) {
		this.footballTeam = footballTeam;
	}
	public PlayerStat getPstat() {
		return pstat;
	}
	public void setPstat(PlayerStat pstat) {
		this.pstat = pstat;
	}
	public GKStat getGstat() {
		return gstat;
	}
	public void setGstat(GKStat gstat) {
		this.gstat = gstat;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public int getGlobalNote() {
		return globalNote;
	}
	public void setGlobalNote(int globalNote) {
		this.globalNote = globalNote;
	}
	public Nation getNation() {
		return nation;
	}
	public void setNation(Nation nation) {
		this.nation = nation;
	}
	
}
