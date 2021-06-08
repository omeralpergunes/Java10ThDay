package kodlamaio.northwind.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.northwind.entities.concretes.VerificationCode;

public interface VerificationCodeDao extends JpaRepository<VerificationCode, Integer> {

	VerificationCode getById(int id);
}
