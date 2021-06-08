package kodlamaio.northwind.business.abstracts;

import java.util.List;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.ProgrammingAbility;

public interface ProgrammingAbilityService {

	Result add(ProgrammingAbility programmingAbility);
	Result update(ProgrammingAbility programmingAbility);
	Result delete(int id);
	DataResult<ProgrammingAbility> getById(int id);	
	DataResult<List<ProgrammingAbility>> getAll();
	DataResult<List<ProgrammingAbility>> getAllByJobseekerId(int id);
}
