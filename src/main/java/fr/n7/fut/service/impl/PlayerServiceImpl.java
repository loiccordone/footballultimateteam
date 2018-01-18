package fr.n7.fut.service.impl;

import fr.n7.fut.model.players.Player;
import fr.n7.fut.repository.PlayerRepository;
import fr.n7.fut.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("playerService")
public class PlayerServiceImpl implements PlayerService {
	@Autowired
	private PlayerRepository playerRep;

	@Override
	public Player getById(int idPlayer) {
		return playerRep.findPlayerById(idPlayer);
	}

	@Override
	public Iterable<Player> getAll() {
		return this.playerRep.findAll();
	}

}
