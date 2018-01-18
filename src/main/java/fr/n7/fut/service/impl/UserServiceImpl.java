package fr.n7.fut.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.n7.fut.model.games.Game;
import fr.n7.fut.model.packs.PackFormat;
import fr.n7.fut.model.packs.PackType;
import fr.n7.fut.model.players.Player;
import fr.n7.fut.model.teams.Composition;
import fr.n7.fut.model.teams.Team;
import fr.n7.fut.model.users.Role;
import fr.n7.fut.model.users.User;
import fr.n7.fut.repository.PlayerRepository;
import fr.n7.fut.repository.UserRepository;
import fr.n7.fut.service.PackService;
import fr.n7.fut.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Autowired
    private PlayerRepository playerRepository;
    
    private PackService packService;

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(true);
        Role userRole = user.getRole();
        user.setRole(userRole);
        userRepository.save(user);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(userName);
        List<GrantedAuthority> authorities = getUserAuthorities(user.getRole());
        return buildUserForAuthentication(user, authorities);
    }

    private List<GrantedAuthority> getUserAuthorities(Role userRole) {
        return Collections.singletonList(new SimpleGrantedAuthority(userRole.toString()));
    }

    private UserDetails buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), user.isActive(), true, true, true, authorities);
    }

	@Override
	public void buyPlayer(User user, int idplayer) {
		Player tobuy = playerRepository.findPlayerById(idplayer);
		User buyer = user;
		/*Add the player to user's club*/
		List<Player> club = buyer.getPlayers();
		club.add(tobuy);
		buyer.setPlayers(club);
		/*Remove the price from user's coins*/
		buyer.setCoins(buyer.getCoins()-tobuy.getPrice());
	}

	@Override
	public void sellPlayer(User user, int idplayer) {
		Player toSell = playerRepository.findPlayerById(idplayer);
		User seller = user;
		/*Remove the player from  user's club*/
		List<Player> club = seller.getPlayers();
		club.remove(toSell);
		seller.setPlayers(club);
		/*Add the price to user's coins*/
		seller.setCoins(seller.getCoins()-toSell.getPrice());
		
	}


	@Override
	public void openPack(User user, PackFormat format, PackType type) {
		List<Player> result = packService.openPack(type, format);
		List<Player> club = user.getPlayers();
		for (Player pl : result ) {
			if (club.contains(pl)) {
				sellPlayer(user,pl.getId());
			} else {
				club.add(pl);
			}
		}
		user.setPlayers(club);
	}

	@Override
	public void changeComposition(User user, Composition comp) {
		user.getActiveTeam().setComp(comp);
		user.getActiveTeam().computeChemistry();
	}

	@Override
	public void addPlayer(User user, int idPlayer, int choicePlace, boolean isStarter) {
		Player newplayer = playerRepository.findPlayerById(idPlayer);
		Team team = user.getActiveTeam();
		team.addPlayer(newplayer,choicePlace,isStarter);
	}

	@Override
	public void removePlayer(User user, int choicePlace, boolean isStarter) {
		Team team = user.getActiveTeam();
		team.removePlayer(choicePlace,isStarter);
	}

	@Override
	public void playGame(User user) {
		User homeplayer = user;
		/*Look for a different  awayplayer with a valid team*/
		User awayplayer = getUserForaGame(user);
		Game game = new Game(homeplayer,awayplayer);
		game.computeScore();
	}
	
	public User getUserForaGame(User user) {
		List<User> us = userRepository.findAll();
		boolean validChoice = false;
		User res = null;
		Random rd = new Random();
		while (!validChoice) {
			res = us.get(rd.nextInt(us.size()));
			if (res != user && res.getActiveTeam().isPlayable()) {
				validChoice = true;
			}
		}
		return res;
	}
	@Override
	public void replacePlayer(User user, int choiceStarter, int choiceSub) {
		Team team = user.getActiveTeam();
		team.replacePlayer(choiceStarter,choiceSub);
	}


	}

