package fr.n7.fut.repository;

import fr.n7.fut.model.players.Player;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<Player, Long> {

}
