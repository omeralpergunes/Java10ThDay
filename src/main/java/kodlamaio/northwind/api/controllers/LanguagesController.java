package kodlamaio.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.abstracts.LanguageService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Language;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {

	private LanguageService languageService;

	@Autowired
	public LanguagesController(LanguageService languageService) {
		super();
		this.languageService = languageService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Language language){
		return this.languageService.add(language);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody Language language){
		return this.languageService.update(language);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam("id") int id){
		return this.languageService.delete(id);
	}
	
	@GetMapping("/getbyid")
	public DataResult<Language> getById(@RequestParam("id") int id){
		return this.languageService.getById(id);
	}
	
	@GetMapping("/getall")
	public DataResult<List<Language>> getAll(){
		return this.languageService.getAll();
	}
	
	@GetMapping("/getAllByJobseekerId")
	public DataResult<List<Language	>> getAllByJobseekerId(@RequestParam int id){
		return this.languageService.getAllByJobseekerId(id);
	}
}
