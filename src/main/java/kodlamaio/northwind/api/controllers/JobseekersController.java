package kodlamaio.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.abstracts.JobseekerService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Jobseeker;
import kodlamaio.northwind.entities.dtos.JobSeekerCVDto;

@RestController
@RequestMapping("/api/jobseekers")
public class JobseekersController {


	private JobseekerService jobseekerService;

	@Autowired
	public JobseekersController(JobseekerService jobseekerService) {
		super();
		this.jobseekerService = jobseekerService;
	}
		
	@PostMapping("/add")
	public Result add(@RequestBody Jobseeker jobseeker){
		return this.jobseekerService.add(jobseeker);
	}
	@GetMapping("/getall")
	public DataResult<List<Jobseeker>> getAll(){
		return this.jobseekerService.getAll();
	}
	
	@GetMapping("/getJobseekerCVById")
	public DataResult<JobSeekerCVDto> getJobseekerCVById(@RequestParam int id){
		return this.jobseekerService.getJobseekerCVById(id);
	}
}
