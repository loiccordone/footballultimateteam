package fr.n7.fut.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.n7.fut.model.games.Game;
import fr.n7.fut.model.users.User;

public interface GamesRepository extends CrudRepository<Game,Long>{
	/*
	Game getGameById(int id);
	List<Game> findGameByDate(Date date);
	List<Game> findGameByAwayPlayer(User awayuser );
	List<Game> findGameByHomePlayer(User homeuser);
	*/
}
