package kodlamaio.northwind.api.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import kodlamaio.northwind.business.abstracts.ExperienceService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Experience;


@RestController
@RequestMapping("/api/experiences")
public class ExperiencesController {

	private ExperienceService experienceService;

	@Autowired
	public ExperiencesController(ExperienceService experienceService) {
		super();
		this.experienceService = experienceService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Experience experience){
		return this.experienceService.add(experience);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody Experience experience){
		return this.experienceService.update(experience);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam("id") int id){
		return this.experienceService.delete(id);
	}
	
	@GetMapping("/getbyid")
	public DataResult<Experience> getById(@RequestParam int id){
		return this.experienceService.getById(id);
	}
	
	@GetMapping("/getall")
	public DataResult<List<Experience>> getAll(){
		return this.experienceService.getAll();
	}
	
	@GetMapping("/getAllByJobseekerIdOrderByEndAtDesc")
	public DataResult<List<Experience>> getAllByJobseekerIdOrderByEndAtDesc(@RequestParam("id") int id){
		return this.experienceService.getAllByJobseekerIdOrderByEndAtDesc(id);
	}
	
	@GetMapping("/getAllByJobseekerId")
	public DataResult<List<Experience>> getAllByJobseekerId(@RequestParam int id){
		return this.experienceService.getAllByJobseekerId(id);
	}
}
