package fr.n7.fut.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.n7.fut.model.packs.Pack;
import fr.n7.fut.model.packs.PackFormat;
import fr.n7.fut.model.packs.PackType;

public interface PacksRepository extends CrudRepository<Pack,Long>  {
	List<Pack> findPackByPackType(PackType type);
	List<Pack> findPackByPackFormat(PackFormat format);
}
