package kodlamaio.northwind.business.abstracts;

import java.util.List;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Language;

public interface LanguageService {

	Result add(Language Language);
	Result update(Language Language);
	Result delete(int id);
	DataResult<Language> getById(int id);	
	DataResult<List<Language>> getAll();
	DataResult<List<Language>> getAllByJobseekerId(int id);
}
