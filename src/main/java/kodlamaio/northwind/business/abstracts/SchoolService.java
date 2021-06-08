package kodlamaio.northwind.business.abstracts;

import java.util.List;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.School;

public interface SchoolService {

	Result add(School school);
	Result update(School school);
	Result delete(int id);
	DataResult<School> getById(int id);	
	DataResult<List<School>> getAll();
	DataResult<List<School>> getAllByJobseekerIdOrderByEndAtDesc(int id);
	DataResult<List<School>> getAllByJobseekerId(int id);
}
