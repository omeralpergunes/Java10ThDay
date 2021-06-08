package kodlamaio.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.northwind.entities.concretes.Language;

public interface LanguageDao extends JpaRepository<Language, Integer>{

	Language getById(int id);
	List<Language> getAllByJobseeker_id(int id);
}

