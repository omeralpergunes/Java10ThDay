package kodlamaio.northwind.business.abstracts;

import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Employer;
import kodlamaio.northwind.entities.concretes.Jobseeker;

public interface AuthService {

	Result registerEmployer(Employer employer, String confirmPassword);
	Result registerJobseeker(Jobseeker jobseeker, String confirmPassword);
}
