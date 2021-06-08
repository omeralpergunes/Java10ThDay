package kodlamaio.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.northwind.business.abstracts.CoverLetterService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import kodlamaio.northwind.dataAccess.abstracts.CoverLetterDao;
import kodlamaio.northwind.entities.concretes.CoverLetter;

@Service
public class CoverLetterManager implements CoverLetterService{

private CoverLetterDao coverLetterDao;
	
	@Autowired
	public CoverLetterManager(CoverLetterDao coverLetterDao) {
		super();
		this.coverLetterDao = coverLetterDao;
	}

	@Override
	public Result add(CoverLetter coverLetter) {
		this.coverLetterDao.save(coverLetter);
		return new SuccessResult("Cover Letter Added.");
	}

	@Override
	public Result update(CoverLetter coverLetter) {
		this.coverLetterDao.save(coverLetter);
		return new SuccessResult("Cover Letter Updated.");
	}

	@Override
	public Result delete(int id) {
		this.coverLetterDao.deleteById(id);
        return new SuccessResult("Cover Letter Deleted.");
	}

	@Override
	public DataResult<CoverLetter> getById(int id) {
		return new SuccessDataResult<CoverLetter>(this.coverLetterDao.getById(id));
	}

	@Override
	public DataResult<List<CoverLetter>> getAll() {
		return new SuccessDataResult<List<CoverLetter>>(this.coverLetterDao.findAll());
	}
	
}
