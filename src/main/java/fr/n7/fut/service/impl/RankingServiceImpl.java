package fr.n7.fut.service.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import fr.n7.fut.model.users.Record;
import fr.n7.fut.model.users.User;
import fr.n7.fut.repository.UserRepository;
import fr.n7.fut.service.RankingService;

public class RankingServiceImpl implements RankingService {
	UserRepository userRep;

	@Override
	public Map<Integer, List<User>> computeRanking() {
		Map<Integer, List<User>> res = new HashMap<>();
		/* Get all users */
		List<User> listUser = userRep.findAll();
		/* Compute score using record */
		Map<Integer,List<User>> scores = new HashMap<>();
		for (User us : listUser) {
			Record rec = us.getRecord();
			int score = rec.getWins()*10+rec.getDraws()*3-rec.getLosses()*2;
			if (scores.containsKey(score)) {
				scores.get(score).add(us);
			} else {
				List<User> users = new LinkedList<>();
				users.add(us);
				scores.put(score,users);
			}
		}
		/*order by score*/
		int actualRank = 1;
		while (!scores.isEmpty()) {
			int maxScore = Collections.max(scores.keySet());
			res.put(actualRank, scores.get(maxScore));
			actualRank = actualRank + scores.get(maxScore).size();
			scores.remove(maxScore);
		}
		return res;
	}

}
