package kodlamaio.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.northwind.entities.concretes.School;

public interface SchoolDao extends JpaRepository<School, Integer>{

	School getById(int id);
	List<School> getAllByJobseeker_idOrderByEndAtDesc(int id);
	List<School> getAllByJobseeker_id(int id);
}
