package kodlamaio.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.northwind.business.abstracts.LanguageService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import kodlamaio.northwind.dataAccess.abstracts.LanguageDao;
import kodlamaio.northwind.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService {

private LanguageDao LanguageDao;
	
	@Autowired
	public LanguageManager(LanguageDao LanguageDao) {
		super();
		this.LanguageDao = LanguageDao;
	}

	@Override
	public Result add(Language language) {
		this.LanguageDao.save(language);
		return new SuccessResult("Language Added.");
	}

	@Override
	public Result update(Language language) {
		this.LanguageDao.save(language);
		return new SuccessResult("Language updated.");
	}

	@Override
	public Result delete(int id) {
		this.LanguageDao.deleteById(id);;
		return new SuccessResult("Language  deleted.");
	}

	@Override
	public DataResult<Language> getById(int id) {
		return new SuccessDataResult<Language>(this.LanguageDao.getById(id));
	}

	@Override
	public DataResult<List<Language>> getAll() {
		return new SuccessDataResult<List<Language>>(this.LanguageDao.findAll());
	}

	@Override
	public DataResult<List<Language>> getAllByJobseekerId(int id) {
		return new SuccessDataResult<List<Language>>(this.LanguageDao.getAllByJobseeker_id(id));
	}
}
