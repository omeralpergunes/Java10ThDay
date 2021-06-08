package kodlamaio.northwind.entities.concretes;

import java.time.LocalDate;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "jobseekers")
@Data
@PrimaryKeyJoinColumn(name = "user_id")
@AllArgsConstructor
@NoArgsConstructor
public class Jobseeker extends User{


	public Jobseeker(String email, String password) {
		super(email, password);
		// TODO Auto-generated constructor stub
	}

	@Column(name= "first_name")
	private String firstName;
	
	@Column(name= "last_name")
	private String lastName;
	
	@Column(name= "national_id")
	private String nationalId;
	
	@Column(name= "date_of_birth")
	private LocalDate dateOfBirth;
	
	@Column(name = "is_verified", columnDefinition = "boolean default false")
	private boolean isVerified = false;

	@JsonIgnore
	@OneToMany(mappedBy = "jobseeker")
	private List<School> schools;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobseeker")
	private List<ProgrammingAbility> programingAbility;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobseeker")
	private List<Link> links;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobseeker")
	private List<Language> languages;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobseeker")
	private List<Experience> experiences;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobseeker")
	private List<CoverLetter> coverLetters;	

	@JsonIgnore
	@OneToOne(mappedBy = "jobseeker", optional=false, fetch=FetchType.LAZY)
	private ImageForCV image;

	public Object setId(int jobseekerId) {
		return null;
		
	}

	public String getNationalId() {
		return this.getNationalId();
	}

	public String getFirstName() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getDateOfBirth() {
		return this.getDateOfBirth();
	}

	public String getEmail() {
		return this.getEmail();
	}

	public int getId() {
		return this.getId();
	}

	public int getYear() {
		return this.getYear();
	}

	public List<Experience> getExperiences() {
		return this.getExperiences();
	}

	public List<Language> getLanguages() {
		return this.getLanguages();
	}

	public ImageForCV getImage() {
		return this.getImage();
	}

	public List<Link> getLinks() {
		return this.getLinks();
	}

	public List<ProgrammingAbility> getProgramingAbilities() {
		return this.getProgramingAbilities();
	}

	public List<School> getSchools() {
		return this.getSchools();
	}

	public Object getPassword() {
		return this.getPassword();
	}
}