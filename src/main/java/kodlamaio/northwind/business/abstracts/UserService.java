package kodlamaio.northwind.business.abstracts;

import java.util.List;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.User;

public interface UserService {

	Result add(User user);
	DataResult<List<User>> getAll();
	DataResult<User> getUserByEmail(String email);
}
