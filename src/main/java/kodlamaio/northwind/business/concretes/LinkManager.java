package kodlamaio.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.northwind.business.abstracts.LinkService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import kodlamaio.northwind.dataAccess.abstracts.LinkDao;
import kodlamaio.northwind.entities.concretes.Link;

@Service
public class LinkManager implements LinkService{

private LinkDao linkDao;
	
	@Autowired
	public LinkManager(LinkDao linkDao) {
		super();
		this.linkDao = linkDao;
	}

	@Override
	public Result add(Link link) {
		this.linkDao.save(link);
		return new SuccessResult("Link added.");
	}

	@Override
	public Result update(Link link) {
		this.linkDao.save(link);
		return new SuccessResult("Link updated.");
	}

	@Override
	public Result delete(int id) {
		this.linkDao.deleteById(id);
		return new SuccessResult("Link has been deleted.");
	}

	@Override
	public DataResult<Link> getById(int id) {
		return new SuccessDataResult<Link>(this.linkDao.getById(id));
	}

	@Override
	public DataResult<List<Link>> getAll() {
		return new SuccessDataResult<List<Link>>(this.linkDao.findAll());
	}

	@Override
	public DataResult<List<Link>> getAllByJobseekerId(int id) {
		return new SuccessDataResult<List<Link>>(this.linkDao.getAllByJobseeker_id(id));
	}
}
