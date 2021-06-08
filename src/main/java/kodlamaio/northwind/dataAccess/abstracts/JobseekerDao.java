package kodlamaio.northwind.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.northwind.entities.concretes.Jobseeker;

public interface JobseekerDao extends JpaRepository<Jobseeker, Integer>{

	Jobseeker findJobseekerByNationalId(String nationalId);
	Jobseeker getById(int id);
}
