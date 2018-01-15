package fr.n7.fut.service;

import fr.n7.fut.model.packs.PackFormat;
import fr.n7.fut.model.packs.PackType;
import fr.n7.fut.model.teams.Composition;
import fr.n7.fut.model.users.User;

public interface UserService {

    User findUserByEmail(String email);
    void saveUser(User user);
    void buyPlayer(int idGamer, int idplayer);
    void sellPlayer(int idGamer, int idplayer);
    void openPack(int idGamer, PackFormat format, PackType type);
    void changeComposition(int idGamer, Composition comp);
    void addPlayer(int idGamer, int idPlayer, int choicePlace, boolean isStarter);
    void replacePlayer(int idGamer, int choiceStarter, int choiceSub);
    void removePlayer(int idGamer, int choicePlace, boolean isStarter);
    void playGame(int idGamer);
}
