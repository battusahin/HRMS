package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobPostingService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.JobPosting;
import kodlamaio.hrms.entities.dtos.JobPostingAddDto;
import kodlamaio.hrms.entities.dtos.JobPostingDto;

@CrossOrigin
@RestController
@RequestMapping("api/jobPostings")
public class JobPostingController {

	private JobPostingService jobPostingService;

	@Autowired
	public JobPostingController(JobPostingService jobPostingService) {
		super();
		this.jobPostingService = jobPostingService;
	}

	@GetMapping("/getActive")
	DataResult<List<JobPostingDto>> findByIsActive() {
		return this.jobPostingService.findByIsActive();
	}

	@PostMapping("/add")
	Result add(@Valid @RequestBody JobPostingAddDto jobPostingAddDto) {
		return this.jobPostingService.add(jobPostingAddDto);
	}

	@GetMapping("/getActive/OrderByEndDate")
	DataResult<List<JobPostingDto>> findByIsActiveOrderByClosedDate() {
		return this.jobPostingService.findByIsActiveOrderByClosedDate();
	}

	@GetMapping("/get/CompanyName")
	DataResult<List<JobPostingDto>> findByIsActiveAndEmployer_CompanyName(String companyName) {
		return this.jobPostingService.findByIsActiveAndEmployer_CompanyName(companyName);

	}

	@GetMapping("/get/City/jobPosting")
	DataResult<List<JobPostingDto>> findByCity_Name(String name) {
		return this.jobPostingService.findByCity_Name(name);
	}
	
	@GetMapping("/getById")
	DataResult<JobPosting> findById(int id){
		return this.jobPostingService.getById(id);
	}
}
