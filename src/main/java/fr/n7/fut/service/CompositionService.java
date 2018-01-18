package fr.n7.fut.service;

import fr.n7.fut.model.teams.Composition;
import fr.n7.fut.model.teams.Starter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CompositionService {
    public List<Integer> getNeighbors(Composition comp, int position);
    Starter getInitStarter(Composition comp, int position);
}
