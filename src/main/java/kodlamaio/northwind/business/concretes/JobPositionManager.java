package kodlamaio.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.northwind.business.abstracts.JobPositionService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.ErrorResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import kodlamaio.northwind.dataAccess.abstracts.JobPositionDao;
import kodlamaio.northwind.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {

	private JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public Result add(JobPosition jobPosition) {
		if(getJobByTitle(jobPosition.getJobTitle()).getData() != null){
			return new ErrorResult( jobPosition.getJobTitle() + " already exists");
		}
		this.jobPositionDao.save(jobPosition);
	    return new SuccessResult("Job position has been added.");
	}
	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll());
	}

	@Override
	public DataResult<JobPosition> getJobByTitle(String title) {
		
		return new SuccessDataResult<JobPosition>(this.jobPositionDao.findByJobTitle(title));
	}

}
