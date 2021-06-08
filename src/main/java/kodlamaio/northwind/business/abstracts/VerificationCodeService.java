package kodlamaio.northwind.business.abstracts;

import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.VerificationCode;

public interface VerificationCodeService {

	Result add(VerificationCode code);
}
