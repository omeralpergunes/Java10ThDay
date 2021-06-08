package kodlamaio.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.northwind.entities.concretes.Experience;

public interface ExperienceDao extends JpaRepository<Experience, Integer>{

	Experience getById(int id);
	List<Experience> getAllByJobseeker_idOrderByEndAtDesc(int id);
	List<Experience> getAllByJobseeker_id(int id);
}
