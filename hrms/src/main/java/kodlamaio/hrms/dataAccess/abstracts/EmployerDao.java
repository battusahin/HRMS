package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobPosting;
@Repository
public interface EmployerDao extends JpaRepository<Employer, Integer> {

	Employer getByCompanyName(String companyName);
	boolean existsByCompanyName(String companyName);
	Employer getById(int id);
	
}
