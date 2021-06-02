package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Employer extends JpaRepository<Employer, Integer> {

	Employer findByCompanyNameEquals(String companyName);
    
	boolean findByCompanyName(String companyName);
	
}
