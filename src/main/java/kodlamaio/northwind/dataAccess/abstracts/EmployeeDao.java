package kodlamaio.northwind.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.northwind.entities.concretes.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {

	Employee getById(int id);
}
