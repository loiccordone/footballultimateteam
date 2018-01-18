package fr.n7.fut.service;

import fr.n7.fut.model.players.Player;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlayerService {
	Player getById(int idPlayer);
	List<Player> getAll();
}
