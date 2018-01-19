package fr.n7.fut.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import fr.n7.fut.model.packs.Pack;
import fr.n7.fut.model.packs.PackFormat;
import fr.n7.fut.model.packs.PackType;
import fr.n7.fut.model.players.Player;
import fr.n7.fut.model.players.Quality;
import fr.n7.fut.repository.PackRepository;
import fr.n7.fut.repository.PlayerRepository;
import fr.n7.fut.service.PackService;
import org.springframework.stereotype.Service;

@Service("packService")
public class PackServiceImpl implements PackService {
	private PackRepository packRep;
	private PlayerRepository playerRep;

	@Override
	public Pack generatePack(PackType type, PackFormat format) {
		Pack p = new Pack(type, format);
		packRep.save(p);
		return p;
	}

	@Override
	public List<Player> openPack(PackType type, PackFormat format) {
		List<Player> res;
		Quality qly;
		/* Get the quality of the players */
		switch (type) {
		case BRONZE:
			qly = Quality.Bronze;
			break;
		case SILVER:
			qly = Quality.Silver;
			break;
		case GOLD:
			qly = Quality.Gold;
			break;
		case ONFIRE:
			qly = Quality.OnFire;
			break;
		default:
			qly = null;
			break;
		}
		/* Generate the players */
		List<Player> playerList = playerRep.findPlayersByQuality(qly);

		switch (format) {
		case NORMAL:
			res = generateRandom(playerList, 6);
			break;
		case MEGA:
			res = generateRandom(playerList, 12);
			break;
		default:
			res = null;
			break;
		}
		return res;
	}

	public List<Player> generateRandom(List<Player> playerList, int toGenerate) {
		List<Player> res = new LinkedList<Player>();
		List<Integer> alreadyGenerated = new LinkedList<Integer>();
		Random rd = new Random();
		for (int i = 0; i < toGenerate; i++) {
			int generated = rd.nextInt(playerList.size());
			while (alreadyGenerated.contains(generated)) {
				generated = rd.nextInt(playerList.size());
			}
			alreadyGenerated.add(generated);
			Player generatedPlayer = playerList.get(generated);
			res.add(generatedPlayer);
		}
		return res;
	}
}
