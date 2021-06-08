package kodlamaio.northwind.core.utilities.adapters;

public interface ValidationService {
	boolean validateByMernis(long nationalId, String firstName, String lastName, int yearOfBirth);
}
