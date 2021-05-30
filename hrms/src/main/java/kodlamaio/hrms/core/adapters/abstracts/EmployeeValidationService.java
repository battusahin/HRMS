package kodlamaio.hrms.core.adapters.abstracts;

import kodlamaio.hrms.entities.concretes.Company;

public interface EmployeeValidationService {
	
	boolean isConfirmByEmployee(Company company);
	
}
