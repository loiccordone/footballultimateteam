package fr.n7.fut.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.n7.fut.model.packs.Pack;
import fr.n7.fut.model.packs.PackFormat;
import fr.n7.fut.model.packs.PackType;

public interface PackRepository extends CrudRepository<Pack,Long>  {
	List<Pack> findPacksByPackType(PackType type);
	List<Pack> findPacksByPackFormat(PackFormat format);
	Pack findPackByPackFormatAndPackType(PackFormat format, PackType type);
}
