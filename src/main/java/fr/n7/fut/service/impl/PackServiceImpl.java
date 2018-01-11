package fr.n7.fut.service.impl;

import java.util.List;

import fr.n7.fut.model.packs.Pack;
import fr.n7.fut.model.packs.PackFormat;
import fr.n7.fut.model.packs.PackType;
import fr.n7.fut.model.players.Player;
import fr.n7.fut.repository.PacksRepository;
import fr.n7.fut.service.PackService;

public class PackServiceImpl implements PackService {
	private PacksRepository packrep;

	@Override
	public Pack generatePack(PackType type, PackFormat format) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Player> openPack(PackType type, PackFormat format) {
		// TODO Auto-generated method stub
		return null;
	}
}
