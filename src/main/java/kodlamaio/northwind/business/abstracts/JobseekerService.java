package kodlamaio.northwind.business.abstracts;

import java.util.List;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Jobseeker;
import kodlamaio.northwind.entities.dtos.JobSeekerCVDto;

public interface JobseekerService {

	Result add(Jobseeker jobseeker);
	Result update(Jobseeker jobseeker);
	Result delete(int id);
	DataResult<Jobseeker> getById(int id);
	
	DataResult<List<Jobseeker>> getAll();
	DataResult<Jobseeker> getJobseekerByNationalId(String nationalId);
	DataResult<JobSeekerCVDto> getJobseekerCVById(int id);
}
