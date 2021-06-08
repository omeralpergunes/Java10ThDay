package kodlamaio.northwind.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.abstracts.AuthService;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Employer;
import kodlamaio.northwind.entities.concretes.Jobseeker;

@RestController
@RequestMapping("/api/auth")
public class AuthController {


	private AuthService authService;

	@Autowired
	public AuthController(AuthService authService) {
		this.authService = authService;
	}
	
	@PostMapping("/registerEmployer")
	public Result registerEmpolyer(@RequestBody Employer employer, String confirmPassword)
	{
		return authService.registerEmployer(employer, confirmPassword);
	}
	
	@PostMapping("/registerJobseeker")
	public Result registerJobseeker(@RequestBody Jobseeker jobseeker, String confirmPassword)
	{
		return authService.registerJobseeker(jobseeker, confirmPassword);
	}
}
