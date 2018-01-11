package fr.n7.fut.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.n7.fut.model.players.FieldRole;
import fr.n7.fut.model.players.FootballTeam;
import fr.n7.fut.model.players.League;
import fr.n7.fut.model.players.Nation;
import fr.n7.fut.model.players.Player;
import fr.n7.fut.model.players.Position;
import fr.n7.fut.model.players.Quality;

public interface PlayerRepository extends CrudRepository<Player, Long> {
	Player findPlayerById(int id);
	List<Player> findPlayerByFieldRole(FieldRole role);
	List<Player> findPlayerByPosition(Position position);
	List<Player> findPlayerByFootballTeam(FootballTeam team);
	List<Player> findPlayerByNation(Nation nation);
	List<Player> findPlayerByLeague(League league);
	List<Player> findPlayerByQuality(Quality quality);
	
}
