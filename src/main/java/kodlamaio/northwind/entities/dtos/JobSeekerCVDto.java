package kodlamaio.northwind.entities.dtos;

import java.util.List;

import kodlamaio.northwind.entities.concretes.Experience;
import kodlamaio.northwind.entities.concretes.ImageForCV;
import kodlamaio.northwind.entities.concretes.Jobseeker;
import kodlamaio.northwind.entities.concretes.Language;
import kodlamaio.northwind.entities.concretes.Link;
import kodlamaio.northwind.entities.concretes.ProgrammingAbility;
import kodlamaio.northwind.entities.concretes.School;

public class JobSeekerCVDto {

	public Jobseeker jobseeker;
	public List<School> schools;
	public List<ProgrammingAbility> programingAbilities;
	public List<Link> links;
	public List<Language> languages;
	public List<Experience> experiences;
	public ImageForCV image;
}
