package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.JobExperience;
import java.util.List;

public interface JobExperienceService {

	Result add(JobExperience jobExpeerience);
	DataResult<List<JobExperience>> getAll();
	
}
