package kodlamaio.northwind.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.northwind.entities.concretes.ImageForCV;

public interface ImageForCVDao extends JpaRepository<ImageForCV, Integer> {

	ImageForCV getById(int id);
	ImageForCV getByJobseeker_id(int id);
}
