package kodlamaio.HRMS.Java.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.Java.core.utilities.results.DataResult;
import kodlamaio.HRMS.Java.core.utilities.results.Result;
import kodlamaio.HRMS.Java.entities.concretes.Employer;


public interface EmployersService {
    DataResult<List<Employer>> getAll();
    Result add(Employer employer);
}
