package fr.n7.fut.model.users;

import javax.persistence.*;

import fr.n7.fut.model.games.Game;
import fr.n7.fut.model.packs.Pack;
import fr.n7.fut.model.players.Player;
import fr.n7.fut.model.teams.Team;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_user")
    private int id;

    @Column(name="pseudo")
    @Length(min = 4, message="Le pseudo doit faire au moins 4 caractères")
    @NotEmpty(message = "Le pseudo ne doit être pas vide")
    private String pseudo;

    @Column(name = "email")
    @Email(message = "L'email n'est pas de forme valide")
    @NotEmpty(message = "L'email ne doit pas être vide")
    private String email;

    @Column(name = "password")
    @Length(min = 5, message = "Le mot de passe doit faire au moins 5 caractères")
    @NotEmpty(message = "Le mot de passe ne doit pas être vide")
    private String password;

    @Column(name = "active")
    private boolean active;

    @Enumerated(EnumType.STRING)
    private Role role = Role.USER;

    @OneToMany
    @Column(name = "user_players")
    private List<Player> players;

    @OneToOne
    private Team activeTeam;

    @OneToMany
    @Column(name = "user_packs")
    private List<Pack> packs;

    private int matchsJoues;
    private int matchsGagnes;
    private int butMarques;
    private int butEncaisses;
    private int coins;

    public int getCoins() {
		return coins;
	}

	public void setCoins(int coins) {
		this.coins = coins;
	}

    public int getMatchsJoues() {
        return matchsJoues;
    }

    public void setMatchsJoues(int matchsJoues) {
        this.matchsJoues = matchsJoues;
    }

    public int getMatchsGagnes() {
        return matchsGagnes;
    }

    public void setMatchsGagnes(int matchsGagnes) {
        this.matchsGagnes = matchsGagnes;
    }

    public int getButMarques() {
        return butMarques;
    }

    public void setButMarques(int butMarques) {
        this.butMarques = butMarques;
    }

    public int getButEncaisses() {
        return butEncaisses;
    }

    public void setButEncaisses(int butEncaisses) {
        this.butEncaisses = butEncaisses;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Team getActiveTeam() {
        return activeTeam;
    }

    public void setActiveTeam(Team activeTeam) {
        this.activeTeam = activeTeam;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public List<Pack> getPacks() {
        return packs;
    }

    public void setPacks(List<Pack> packs) {
        this.packs = packs;
    }
}