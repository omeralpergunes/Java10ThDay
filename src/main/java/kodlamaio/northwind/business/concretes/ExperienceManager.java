package kodlamaio.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.northwind.business.abstracts.ExperienceService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import kodlamaio.northwind.dataAccess.abstracts.ExperienceDao;
import kodlamaio.northwind.entities.concretes.Experience;

@Service
public class ExperienceManager implements ExperienceService {


	private ExperienceDao experienceDao;
	
	@Autowired
	public ExperienceManager(ExperienceDao experienceDao) {
		super();
		this.experienceDao = experienceDao;
	}

	@Override
	public Result add(Experience experience) {
		this.experienceDao.save(experience);
		return new SuccessResult("Experience added.");
	}

	@Override
	public Result update(Experience experience) {
		this.experienceDao.save(experience);
		return new SuccessResult("Experience updated.");
	}

	@Override
	public Result delete(int id) {
		this.experienceDao.deleteById(id);
		return new SuccessResult("Experience deleted.");
	}

	@Override
	public DataResult<Experience> getById(int id) {
		return new SuccessDataResult<Experience>(this.experienceDao.getById(id));
	}

	@Override
	public DataResult<List<Experience>> getAll() {
		return new SuccessDataResult<List<Experience>>(this.experienceDao.findAll());
	}

	@Override
	public DataResult<List<Experience>> getAllByJobseekerIdOrderByEndAtDesc(int id) {
		return new SuccessDataResult<List<Experience>>(this.experienceDao.getAllByJobseeker_idOrderByEndAtDesc(id));
	}

	@Override
	public DataResult<List<Experience>> getAllByJobseekerId(int id) {
		return new SuccessDataResult<List<Experience>>(this.experienceDao.getAllByJobseeker_id(id));
	}
}

