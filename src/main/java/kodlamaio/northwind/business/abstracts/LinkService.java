package kodlamaio.northwind.business.abstracts;

import java.util.List;


import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Link;

public interface LinkService {

	Result add(Link link);
	Result update(Link link);
	Result delete(int id);
	DataResult<Link> getById(int id);	
	DataResult<List<Link>> getAll();
	DataResult<List<Link>> getAllByJobseekerId(int id);
}
