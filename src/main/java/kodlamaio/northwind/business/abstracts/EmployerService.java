package kodlamaio.northwind.business.abstracts;

import java.util.List;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Employer;

public interface EmployerService {

	Result add(Employer employer);
	DataResult<List<Employer>> getAll();
}
