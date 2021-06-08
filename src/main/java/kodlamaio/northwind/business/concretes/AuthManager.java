package kodlamaio.northwind.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.northwind.business.abstracts.AuthService;
import kodlamaio.northwind.business.abstracts.EmployerService;
import kodlamaio.northwind.business.abstracts.JobseekerService;
import kodlamaio.northwind.business.abstracts.UserService;
import kodlamaio.northwind.business.abstracts.VerificationCodeService;
import kodlamaio.northwind.core.utilities.adapters.ValidationService;
import kodlamaio.northwind.core.utilities.results.ErrorResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import kodlamaio.northwind.core.verification.VerificationService;
import kodlamaio.northwind.entities.concretes.Employer;
import kodlamaio.northwind.entities.concretes.Jobseeker;
import kodlamaio.northwind.entities.concretes.VerificationCode;

@Service
public class AuthManager implements AuthService {

	private UserService userService;
	private EmployerService employerService;
	private JobseekerService jobseekerService;
	private VerificationService verificationService;
	private ValidationService validationService;
	private VerificationCodeService verificationCodeService;

	
	@Autowired
	public AuthManager(UserService userService, EmployerService employerService, JobseekerService jobseekerService,
			VerificationService verificationService, ValidationService validationService,
			VerificationCodeService verificationCodeService) {
		super();
		this.userService = userService;
		this.employerService = employerService;
		this.jobseekerService = jobseekerService;
		this.verificationService = verificationService;
		this.validationService = validationService;
		this.verificationCodeService = verificationCodeService;
	}

	@Override
	public Result registerEmployer(Employer employer, String confirmPassword) {

		if (!checkIfNullInfoForEmployer(employer)) {

			return new ErrorResult("You have entered missing information. Please fill in all fields.");
		}

		if (!checkIfEqualEmailAndDomain(employer.getEmail(), employer.getWebsite())) {

			return new ErrorResult("Invalid email address.");
		}

		if (!checkIfEmailExists(employer.getEmail())) {

			return new ErrorResult(employer.getEmail() + " already exists.");
		}

		if (!checkIfEqualPasswordAndConfirmPassword(employer.getPassword(), confirmPassword)) {

			return new ErrorResult("Passwords do not match.");
		}

		employerService.add(employer);
		String code = verificationService.sendCode();
		verificationCodeRecord(code, employer.getId(), employer.getEmail());
		return new SuccessResult("Registration has been successfully completed");

	}

	@Override
	public Result registerJobseeker(Jobseeker jobseeker, String confirmPassword) {

		if (checkIfRealPerson(Long.parseLong(jobseeker.getNationalId()), jobseeker.getFirstName(),
				jobseeker.getFirstName(), ((Jobseeker) jobseeker.getDateOfBirth()).getYear()) == false) {
			return new ErrorResult("TCKN could not be verified.");
		}

		if (!checkIfNullInfoForJobseeker(jobseeker, confirmPassword)) {

			return new ErrorResult("You have entered missing information. Please fill in all fields.");
		}

		if (!checkIfExistsTcNo(jobseeker.getNationalId())) {

			return new ErrorResult(jobseeker.getNationalId() + " already exists.");
		}

		if (!checkIfEmailExists(jobseeker.getEmail())) {

			return new ErrorResult(jobseeker.getEmail() + " already exists.");
		}

		
		jobseekerService.add(jobseeker);
		String code = verificationService.sendCode();
		verificationCodeRecord(code, jobseeker.getId(), jobseeker.getEmail());
		return new SuccessResult("Registration has been successfully completed");
	}

	// Validation for employer register ---START---

	private boolean checkIfNullInfoForEmployer(Employer employer) {

		if (employer.getCompanyName() != null && employer.getWebsite() != null && employer.getEmail() != null
				&& employer.getPhoneNumber() != null && employer.getPassword() != null) {

			return true;

		}

		return false;
	}

	private boolean checkIfEqualEmailAndDomain(String email, String website) {
		String[] emailArr = email.split("@", 2);
		String domain = website.substring(4, website.length());

		if (emailArr[1].equals(domain)) {

			return true;
		}

		return false;
	}


	private boolean checkIfNullInfoForJobseeker(Jobseeker jobseeker, String confirmPassword) {

		if (jobseeker.getFirstName() != null && jobseeker.getFirstName() != null && jobseeker.getNationalId() != null
				&& jobseeker.getDateOfBirth() != null && jobseeker.getPassword() != null && jobseeker.getEmail() != null
				&& confirmPassword != null) {

			return true;

		}

		return false;
	}

	private boolean checkIfExistsTcNo(String nationalId) {

		if (this.jobseekerService.getJobseekerByNationalId(nationalId).getData() == null) {
			return true;
		}
		return false;
	}

	private boolean checkIfRealPerson(long nationalId, String firstName, String lastName, int yearOfBirth) {

		if (validationService.validateByMernis(nationalId, firstName, lastName, yearOfBirth)) {
			return true;
		}
		return false;
	}


	private boolean checkIfEmailExists(String email) {

		if (this.userService.getUserByEmail(email).getData() == null) {

			return true;
		}

		return false;
	}

	private boolean checkIfEqualPasswordAndConfirmPassword(String password, String confirmPassword) {

		if (!password.equals(confirmPassword)) {
			return false;
		}

		return true;
	}
	
	private void verificationCodeRecord(String code, int id, String email) {
		
		VerificationCode verificationCode = new VerificationCode(id, code, false);
		this.verificationCodeService.add(verificationCode);
		System.out.println("Verification code has been sent to " + email );
	
	}
}
