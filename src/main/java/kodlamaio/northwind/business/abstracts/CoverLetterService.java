package kodlamaio.northwind.business.abstracts;

import java.util.List;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.CoverLetter;

public interface CoverLetterService {

	Result add(CoverLetter coverLetter);
	Result update(CoverLetter coverLetter);
	Result delete(int id);
	DataResult<CoverLetter> getById(int id);	
	DataResult<List<CoverLetter>> getAll();
}
