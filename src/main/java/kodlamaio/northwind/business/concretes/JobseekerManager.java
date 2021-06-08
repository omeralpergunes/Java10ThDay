package kodlamaio.northwind.business.concretes;

import java.util.List;


import org.springframework.stereotype.Service;

import kodlamaio.northwind.business.abstracts.ExperienceService;
import kodlamaio.northwind.business.abstracts.ImageForCVService;
import kodlamaio.northwind.business.abstracts.JobseekerService;
import kodlamaio.northwind.business.abstracts.LanguageService;
import kodlamaio.northwind.business.abstracts.LinkService;
import kodlamaio.northwind.business.abstracts.ProgrammingAbilityService;
import kodlamaio.northwind.business.abstracts.SchoolService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import kodlamaio.northwind.dataAccess.abstracts.JobseekerDao;
import kodlamaio.northwind.entities.concretes.Jobseeker;
import kodlamaio.northwind.entities.dtos.JobSeekerCVDto;

@Service
public class JobseekerManager implements JobseekerService{


	private JobseekerDao jobseekerDao;
	
	@SuppressWarnings("unused")
	private ExperienceService experienceService;
	@SuppressWarnings("unused")
	private LanguageService languageService;
	@SuppressWarnings("unused")
	private ImageForCVService imageForCVService;
	@SuppressWarnings("unused")
	private LinkService linkService;
	@SuppressWarnings("unused")
	private ProgrammingAbilityService programmingAbilityService;
	@SuppressWarnings("unused")
	private SchoolService schoolService;

	public JobseekerManager(JobseekerDao jobseekerDao, ExperienceService experienceService,
			LanguageService languageService, ImageForCVService imageForCVService,
			LinkService linkService, ProgrammingAbilityService programmingAbilityService,
			SchoolService schoolService) {
		super();
		this.jobseekerDao = jobseekerDao;
		this.experienceService = experienceService;
		this.languageService = languageService;
		this.imageForCVService = imageForCVService;
		this.linkService = linkService;
		this.programmingAbilityService = programmingAbilityService;
		this.schoolService = schoolService;
	}

	@Override
	public Result add(Jobseeker jobseeker) {
		this.jobseekerDao.save(jobseeker);
		return new SuccessResult("Jobseeker has been added.");
	}

	@Override
	public Result update(Jobseeker jobseeker) {
		this.jobseekerDao.save(jobseeker);
		return new SuccessResult("Jobseeker has been updated.");
	}

	@Override
	public Result delete(int id) {
		this.jobseekerDao.deleteById(id);
		return new SuccessResult("Jobseeker has been deleted.");
	}

	@Override
	public DataResult<Jobseeker> getById(int id) {
		return new SuccessDataResult<Jobseeker>(this.jobseekerDao.getById(id));
	}

	@Override
	public DataResult<List<Jobseeker>> getAll() {
		return new SuccessDataResult<List<Jobseeker>>(this.jobseekerDao.findAll());
	}

	@Override
	public DataResult<Jobseeker> getJobseekerByNationalId(String nationalId) {
		return new SuccessDataResult<Jobseeker>(this.jobseekerDao.findJobseekerByNationalId(nationalId));
	}

	@Override
	public DataResult<JobSeekerCVDto> getJobseekerCVById(int id) {
		Jobseeker jobseeker = this.jobseekerDao.getById(id);
		JobSeekerCVDto cv = new JobSeekerCVDto();
		cv.experiences = jobseeker.getExperiences();
		cv.languages = jobseeker.getLanguages();
		cv.image = jobseeker.getImage();
		cv.links = jobseeker.getLinks();
		cv.programingAbilities = jobseeker.getProgramingAbilities();
		cv.schools = jobseeker.getSchools();
		return new SuccessDataResult<JobSeekerCVDto>(cv);
	}

}
