package fr.n7.fut.service.impl;

import fr.n7.fut.model.players.Player;
import fr.n7.fut.model.teams.Composition;
import fr.n7.fut.model.teams.Starter;
import fr.n7.fut.service.CompositionService;
import fr.n7.fut.service.StarterService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class StarterServiceImpl implements StarterService {

    @Autowired
    private CompositionService compositionService;

    public void computeChemistry (Map<Integer,Starter> starters, Composition comp, int position) {
        int chemistry = computeChemistryPosition();
        List<Integer> neighbors = compositionService.getNeighbors(comp,position);
        for (Integer i : neighbors) {
            chemistry = chemistry - computeChemistryNeighbor(starters.get(i).getJoueur());
        }
        this.setCollectif(Math.max(0,Math.min(10,chemistry)));
    }

    public int computeChemistryPosition () {
        int res = 0;
        if ((this.getJoueur().getFieldRole()).equals(this.getFieldRole())) {
            res = 1;
        }
        if ((this.getJoueur().getPosition().equals(this.getPosition()))) {
            res = 3;
        }
        return res;
    }

    public int computeChemistryNeighbor(Player neighbor)  {
        int res = 0;
        if (this.getJoueur().getFootballTeam().getChampionnat().equals(neighbor.getFootballTeam().getChampionnat())) {
            res++;
            if (this.getJoueur().getFootballTeam().equals(neighbor.getFootballTeam())) {
                res = res + 2;
            }
        }
        if (this.getJoueur().getNation().equals(neighbor.getNation())) {
            res = res + 2;
        }
        if (res == 0) {
            res = -2;
        }
        return res;
    }
}
