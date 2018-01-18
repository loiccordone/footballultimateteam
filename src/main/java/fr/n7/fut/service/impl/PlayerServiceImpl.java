package fr.n7.fut.service.impl;

import fr.n7.fut.model.players.Player;
import fr.n7.fut.repository.PlayerRepository;
import fr.n7.fut.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PlayerServiceImpl implements PlayerService {
	@Autowired
	private PlayerRepository playerRep;

	@Override
	public Player getById(int idPlayer) {
		return playerRep.findPlayerById(idPlayer);
	}

	@Override
	public List<Player> getAll() {
		return this.playerRep.findAll();
	}


}
