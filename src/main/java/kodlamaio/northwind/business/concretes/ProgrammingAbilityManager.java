package kodlamaio.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.northwind.business.abstracts.ProgrammingAbilityService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import kodlamaio.northwind.dataAccess.abstracts.ProgrammingAbilityDao;
import kodlamaio.northwind.entities.concretes.ProgrammingAbility;

@Service
public class ProgrammingAbilityManager implements ProgrammingAbilityService{

private ProgrammingAbilityDao programmingAbilityDao;
	
	
	@Autowired
	public ProgrammingAbilityManager(ProgrammingAbilityDao programmingAbilityDao) {
		super();
		this.programmingAbilityDao = programmingAbilityDao;
	}

	@Override
	public Result add(ProgrammingAbility programmingAbility) {
		this.programmingAbilityDao.save(programmingAbility);
		return new SuccessResult("Programming ability Added.");
	}

	@Override
	public Result update(ProgrammingAbility programmingAbility) {
		this.programmingAbilityDao.save(programmingAbility);
		return new SuccessResult("Programming ability updated.");
	}

	@Override
	public Result delete(int id) {
		this.programmingAbilityDao.deleteById(id);
		return new SuccessResult("Programming ability deleted.");
	}

	@Override
	public DataResult<ProgrammingAbility> getById(int id) {
		return new SuccessDataResult<ProgrammingAbility>(this.programmingAbilityDao.getById(id));
	}

	@Override
	public DataResult<List<ProgrammingAbility>> getAll() {
		return new SuccessDataResult<List<ProgrammingAbility>>(this.programmingAbilityDao.findAll());
	}

	@Override
	public DataResult<List<ProgrammingAbility>> getAllByJobseekerId(int id) {
		return new SuccessDataResult<List<ProgrammingAbility>>(this.programmingAbilityDao.getAllByJobseeker_id(id));
	}
}
