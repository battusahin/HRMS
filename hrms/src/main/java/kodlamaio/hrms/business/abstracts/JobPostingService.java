package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.JobPosting;
import kodlamaio.hrms.entities.dtos.JobPostingAddDto;
import kodlamaio.hrms.entities.dtos.JobPostingDto;

public interface JobPostingService {
	
	
	Result add(JobPostingAddDto jobPostingAddDto);
	Result delete(JobPosting jobPosting);
	DataResult<List<JobPostingDto>> findByIsActive();
	DataResult<List<JobPostingDto>> findByIsActiveOrderByClosedDate();
	DataResult<List<JobPostingDto>> findByIsActiveAndEmployer_CompanyName(String companyName);
	DataResult<List<JobPostingDto>> findByCity_Name(String name);
	DataResult<JobPosting> getById(int id);
	
	
}
