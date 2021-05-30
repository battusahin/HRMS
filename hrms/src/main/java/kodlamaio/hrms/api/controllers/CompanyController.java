package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import kodlamaio.hrms.business.abstracts.CompanyService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Company;

@RestController
@RequestMapping("/api/company")
public class CompanyController {
	
	private CompanyService companyService;
	@Autowired
	public CompanyController(CompanyService companyService) {
		super();
		this.companyService = companyService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Company>> getAll(){
		
		return this.companyService.getAll();
	}
	@PostMapping("/add")
	public Result add(@RequestBody Company company) {
		return this.companyService.add(company);
	}

}
