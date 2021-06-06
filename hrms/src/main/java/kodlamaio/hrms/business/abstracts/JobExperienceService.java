package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.JobExperience;
import kodlamaio.hrms.entities.dtos.JobExperienceDto;

import java.util.List;

public interface JobExperienceService {

	Result add(JobExperienceDto jobExpeerienceDto);
	DataResult<List<JobExperienceDto>> getAll();
	DataResult<List<JobExperienceDto>> findAllByResumeIdOrderByEndedDateDesc(int id);
	
}
