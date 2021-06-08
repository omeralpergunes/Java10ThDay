package kodlamaio.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.northwind.entities.concretes.Link;

public interface LinkDao extends JpaRepository<Link, Integer>{

	Link getById(int id);
	List<Link> getAllByJobseeker_id(int id);
}
