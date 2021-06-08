package kodlamaio.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.abstracts.ProgrammingAbilityService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.ProgrammingAbility;

@RestController
@RequestMapping("/api/programmingAbilitys")
public class ProgrammingAbilitysController {

	private ProgrammingAbilityService programmingAbilityService;

	@Autowired
	public ProgrammingAbilitysController(ProgrammingAbilityService programmingAbilityService) {
		super();
		this.programmingAbilityService = programmingAbilityService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody ProgrammingAbility programmingAbility){
		return this.programmingAbilityService.add(programmingAbility);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody ProgrammingAbility programmingAbility){
		return this.programmingAbilityService.update(programmingAbility);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam("id") int id){
		return this.programmingAbilityService.delete(id);
	}
	
	@GetMapping("/getbyid")
	public DataResult<ProgrammingAbility> getById(@RequestParam("id") int id){
		return this.programmingAbilityService.getById(id);
	}
	
	@GetMapping("/getall")
	public DataResult<List<ProgrammingAbility>> getAll(){
		return this.programmingAbilityService.getAll();
	}
	
	@GetMapping("/getAllByJobseekerId")
	public DataResult<List<ProgrammingAbility>> getAllByJobseekerId(@RequestParam int id){
		return this.programmingAbilityService.getAllByJobseekerId(id);
	}

}
