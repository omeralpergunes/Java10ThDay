package kodlamaio.northwind.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.northwind.business.abstracts.VerificationCodeService;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import kodlamaio.northwind.dataAccess.abstracts.VerificationCodeDao;
import kodlamaio.northwind.entities.concretes.VerificationCode;

@Service
public class VerificationCodeManager implements VerificationCodeService {


	private VerificationCodeDao verificationCodeDao;
	
	@Autowired
	public VerificationCodeManager(VerificationCodeDao verificationCodeDao) {
		super();
		this.verificationCodeDao = verificationCodeDao;
	}

	@Override
	public Result add(VerificationCode code) {
		this.verificationCodeDao.save(code);
		return new SuccessResult("Code has been saved.");
	}
	

}
