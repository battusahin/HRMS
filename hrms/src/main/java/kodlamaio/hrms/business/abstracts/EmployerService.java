package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobPosting;

public interface EmployerService {

	DataResult<List<Employer>> getAll();
	Result add(Employer employer);
	DataResult<Employer> getById(int id);
	
}
