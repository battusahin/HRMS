package kodlamaio.hrms.core.adapters.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.adapters.abstracts.EmployeeValidationService;
import kodlamaio.hrms.entities.concretes.Company;

@Service
public class EmployeeValidationManager implements EmployeeValidationService {

	@Override
    public boolean isConfirmByEmployee(Company company) {
        System.out.println("Sistem calisani "+company.getCompanyName()+" sirketinin kayit onayini gerceklestirdi.");
        
        return true;
    }

}
