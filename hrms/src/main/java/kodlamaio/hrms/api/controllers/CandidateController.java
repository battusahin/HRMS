package kodlamaio.hrms.api.controllers;

import javax.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Candidate;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {

	
	private CandidateService candidatesService;
	
	
	@Autowired
	public CandidateController(CandidateService candidatesService) {
		super();
		this.candidatesService = candidatesService;
		
	}
	
	@GetMapping("/getall")
	public DataResult<List<Candidate>> getAll(){
		return this.candidatesService.getAll();
	}
	
	@PostMapping("/add")
	public Result newCandidate(@Valid @RequestBody Candidate newCandidate){
		return candidatesService.add(newCandidate);
	}
	
		
}
