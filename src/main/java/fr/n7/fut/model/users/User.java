package fr.n7.fut.model.users;

import javax.persistence.*;

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
    @Column(name = "club_players")
    private List<Player> players;

    @OneToOne
    @Column(name = "active_team")
    private Team activeTeam;

    @OneToOne
    private Record record;

    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
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
}