package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Company;



public interface CompanyService {
	
	DataResult<List<Company>> getAll();
	Result add(Company company);

}
