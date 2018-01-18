package fr.n7.fut.service;

import java.util.List;

import fr.n7.fut.model.packs.Pack;
import fr.n7.fut.model.packs.PackFormat;
import fr.n7.fut.model.packs.PackType;
import fr.n7.fut.model.players.Player;
import org.springframework.stereotype.Service;

@Service
public interface PackService {
	Pack generatePack(PackType type, PackFormat format );
	List<Player> openPack(PackType type, PackFormat format);
}
