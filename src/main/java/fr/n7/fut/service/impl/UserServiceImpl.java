package fr.n7.fut.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public void buyPlayer(int idGamer, int idplayer) {
		Player tobuy = playerRepository.findPlayerById(idplayer);
		User buyer = userRepository.findById(idGamer);
		/*Add the player to user's club*/
		List<Player> club = buyer.getPlayers();
		club.add(tobuy);
		buyer.setPlayers(club);
		/*Remove the price from user's coins*/
		buyer.setCoins(buyer.getCoins()-tobuy.getPrice());
	}

	@Override
	public void sellPlayer(int idGamer, int idplayer) {
		Player toSell = playerRepository.findPlayerById(idplayer);
		User seller = userRepository.findById(idGamer);
		/*Remove the player from  user's club*/
		List<Player> club = seller.getPlayers();
		club.remove(toSell);
		seller.setPlayers(club);
		/*Add the price to user's coins*/
		seller.setCoins(seller.getCoins()-toSell.getPrice());
		
	}


	@Override
	public void openPack(int idGamer, PackFormat format, PackType type) {
		User user = userRepository.findById(idGamer);
		List<Player> result = packService.openPack(type, format);
		List<Player> club = user.getPlayers();
		for (Player pl : result ) {
			if (club.contains(pl)) {
				sellPlayer(idGamer,pl.getId());
			} else {
				club.add(pl);
			}
		}
		user.setPlayers(club);
	}

	@Override
	public void changeComposition(int idGamer, Composition comp) {
		User user = userRepository.findById(idGamer);
		user.getActiveTeam().setComp(comp);
		user.getActiveTeam().computeChemistry();
	}

	@Override
	public void addPlayer(int idGamer, int idPlayer, int choicePlace, boolean isStarter) {	
		Player newplayer = playerRepository.findPlayerById(idPlayer);
		User user = userRepository.findById(idGamer);
		Team team = user.getActiveTeam();
		team.addPlayer(newplayer,choicePlace,isStarter);
	}

	@Override
	public void removePlayer(int idGamer, int choicePlace, boolean isStarter) {	
		User user = userRepository.findById(idGamer);
		Team team = user.getActiveTeam();
		team.removePlayer(choicePlace,isStarter);
	}

	@Override
	public void playGame(int idGamer) {
		//TO DO
	}

	@Override
	public void replacePlayer(int idGamer, int choiceStarter, int choiceSub) {
		User user = userRepository.findById(idGamer);
		Team team = user.getActiveTeam();
		team.replacePlayer(choiceStarter,choiceSub);
	}


	}

