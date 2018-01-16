package fr.n7.fut.service;

import java.util.List;
import java.util.Map;

import fr.n7.fut.model.users.User;

public interface RankingService {
	Map<Integer,List<User>> computeRanking();
}
