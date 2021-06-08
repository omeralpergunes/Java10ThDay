package kodlamaio.northwind.business.abstracts;

import java.util.List;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.entities.concretes.Employee;

public interface EmployeeService {

	DataResult<List<Employee>> getAll();
}
