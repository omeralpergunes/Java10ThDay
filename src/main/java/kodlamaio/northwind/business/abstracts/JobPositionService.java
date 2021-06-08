package kodlamaio.northwind.business.abstracts;

import java.util.List;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.JobPosition;

public interface JobPositionService {

	Result add(JobPosition jobPosition);
	DataResult<List<JobPosition>> getAll();
	DataResult<JobPosition> getJobByTitle(String title);
}
