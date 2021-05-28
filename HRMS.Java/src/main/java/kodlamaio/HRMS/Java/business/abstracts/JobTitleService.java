package kodlamaio.HRMS.Java.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.Java.core.utilities.results.DataResult;
import kodlamaio.HRMS.Java.core.utilities.results.Result;
import kodlamaio.HRMS.Java.entities.concretes.JobTitle;

public interface JobTitleService {
    DataResult<List<JobTitle>> getAll();
    Result add(JobTitle jobPositions);



}
