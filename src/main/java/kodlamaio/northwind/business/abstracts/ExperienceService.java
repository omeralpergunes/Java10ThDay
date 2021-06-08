package kodlamaio.northwind.business.abstracts;

import java.util.List;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Experience;

public interface ExperienceService {

	Result add(Experience experience);
	Result update(Experience experience);
	Result delete(int id);
	DataResult<Experience> getById(int id);	
	DataResult<List<Experience>> getAll();
	DataResult<List<Experience>> getAllByJobseekerIdOrderByEndAtDesc(int id);
	DataResult<List<Experience>> getAllByJobseekerId(int id);

}
