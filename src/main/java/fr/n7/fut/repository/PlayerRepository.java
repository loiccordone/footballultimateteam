package fr.n7.fut.repository;

import org.springframework.data.repository.CrudRepository;

import fr.n7.fut.model.players.Player;
import fr.n7.fut.model.users.User;

public interface PlayerRepository extends CrudRepository<Player, Long> {
	Player findPlayerById(int id);
}
