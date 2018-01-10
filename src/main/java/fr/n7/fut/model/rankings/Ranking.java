package fr.n7.fut.model.rankings;

import java.util.Date;
import java.util.List;
import java.util.Map;
import fr.n7.fut.model.players.Player;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;

@Entity
@Table(name = "rankings")
public class Ranking {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name = "id_ranking")
	private int id;

	@Enumerated(EnumType.STRING)
	private TypeRanking typeRanking;

	@OneToMany
	private List<Player> players;

	@CreatedDate
	private Date date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TypeRanking getTypeRanking() {
		return typeRanking;
	}

	public void setTypeRanking(TypeRanking typeRanking) {
		this.typeRanking = typeRanking;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
