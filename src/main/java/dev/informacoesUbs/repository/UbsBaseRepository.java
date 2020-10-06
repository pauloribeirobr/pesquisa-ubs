package dev.informacoesUbs.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.informacoesUbs.model.UbsBase;

@Repository
public interface UbsBaseRepository extends CrudRepository<UbsBase, Integer> {

	public List<UbsBase> findAll();
}
