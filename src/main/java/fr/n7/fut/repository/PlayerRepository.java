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
	List<Player> findPlayersByFieldRole(FieldRole role);
	List<Player> findPlayersByPosition(Position position);
	List<Player> findPlayersByFootballTeam(FootballTeam team);
	List<Player> findPlayersByNation(Nation nation);
	List<Player> findPlayersByLeague(League league);
	List<Player> findPlayersByQuality(Quality quality);
	
}
