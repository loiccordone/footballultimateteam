package fr.n7.fut.service;

import fr.n7.fut.model.packs.Pack;
import fr.n7.fut.model.packs.PackFormat;
import fr.n7.fut.model.packs.PackType;
import fr.n7.fut.model.teams.Composition;
import fr.n7.fut.model.users.User;

public interface UserService {

    User findUserByEmail(String email);
    void saveUser(User user);
    void buyPack(User user, Pack pack);
    void buyPlayer(User user, int idplayer);
    void sellPlayer(User user, int idplayer);
    void openPack(User user, PackFormat format, PackType type);
    void changeComposition(User user, Composition comp);
    void addPlayer(User user, int idPlayer, int choicePlace, boolean isStarter);
    void replacePlayer(User user, int choiceStarter, int choiceSub);
    void removePlayer(User user, int choicePlace, boolean isStarter);
    void playGame(User user);
}
