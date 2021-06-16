package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.WorkPlaceService;
import kodlamaio.hrms.core.utilities.result.DataResult;

import kodlamaio.hrms.entities.concretes.WorkPlace;

@CrossOrigin
@RestController
@RequestMapping("/api/workplace")
public class WorkPlaceController {

	private WorkPlaceService workPlaceService;
	
	@Autowired
	public WorkPlaceController(WorkPlaceService workPlaceService) {
		super();
		this.workPlaceService = workPlaceService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<WorkPlace>> getAll(){
		return this.workPlaceService.getAll();
	}
	
}
