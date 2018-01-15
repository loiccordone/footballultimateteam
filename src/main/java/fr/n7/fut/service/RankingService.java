package fr.n7.fut.service;

import java.util.List;
import java.util.Map;

import fr.n7.fut.model.players.Player;

public interface RankingService {
	Map<Integer,List<Player>> computeRanking();
}
