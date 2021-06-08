package kodlamaio.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.northwind.entities.concretes.ProgrammingAbility;

public interface ProgrammingAbilityDao extends JpaRepository<ProgrammingAbility, Integer>{

	ProgrammingAbility getById(int id);
	List<ProgrammingAbility> getAllByJobseeker_id(int id);
}
