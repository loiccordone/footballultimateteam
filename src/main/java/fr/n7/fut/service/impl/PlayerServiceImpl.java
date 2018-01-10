package fr.n7.fut.service.impl;

import fr.n7.fut.model.players.Player;
import fr.n7.fut.repository.PlayerRepository;
import fr.n7.fut.service.PlayerService;

public class PlayerServiceImpl implements PlayerService {
	private PlayerRepository playerRep;

	@Override
	public Player getById(int idPlayer) {
		return playerRep.findPlayerById(idPlayer);
	}
	

}
