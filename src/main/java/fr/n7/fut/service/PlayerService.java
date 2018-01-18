package fr.n7.fut.service;

import fr.n7.fut.model.players.Player;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PlayerService {
	Player getById(int idPlayer);
	Iterable<Player> getAll();
}
