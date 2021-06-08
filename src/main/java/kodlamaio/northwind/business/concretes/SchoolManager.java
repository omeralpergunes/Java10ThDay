package kodlamaio.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.northwind.business.abstracts.SchoolService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import kodlamaio.northwind.dataAccess.abstracts.SchoolDao;
import kodlamaio.northwind.entities.concretes.School;

@Service
public class SchoolManager implements SchoolService {


	private SchoolDao schoolDao;
	
	@Autowired
	public SchoolManager(SchoolDao schoolDao) {
		super();
		this.schoolDao = schoolDao;
	}

	@Override
	public Result add(School school) {
		this.schoolDao.save(school);
		return new SuccessResult("School added.");
	}

	@Override
	public Result update(School school) {
		this.schoolDao.save(school);
		return new SuccessResult("School updated.");
	}

	@Override
	public Result delete(int id) {
		this.schoolDao.deleteById(id);
		return new SuccessResult("School deleted.");
	}

	@Override
	public DataResult<School> getById(int id) {
		return new SuccessDataResult<School>(this.schoolDao.getById(id));
	}

	@Override
	public DataResult<List<School>> getAll() {
		return new SuccessDataResult<List<School>>(this.schoolDao.findAll());
	}

	@Override
	public DataResult<List<School>> getAllByJobseekerIdOrderByEndAtDesc(int id) {
		return new SuccessDataResult<List<School>>(this.schoolDao.getAllByJobseeker_idOrderByEndAtDesc(id));
	}

	@Override
	public DataResult<List<School>> getAllByJobseekerId(int id) {
		return new SuccessDataResult<List<School>>(this.schoolDao.getAllByJobseeker_id(id));
	}
}
