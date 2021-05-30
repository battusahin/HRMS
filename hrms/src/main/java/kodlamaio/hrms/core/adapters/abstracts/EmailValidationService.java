package kodlamaio.hrms.core.adapters.abstracts;

public interface EmailValidationService {

	boolean emailValidation(String email);
	
	boolean emailButtonClick(String email);
}
