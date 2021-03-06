package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Resume;
import kodlamaio.hrms.entities.dtos.ResumeAddDto;
import kodlamaio.hrms.entities.dtos.ResumeDto;

@CrossOrigin
@RestController
@RequestMapping("api/resumes")
public class ResumeController {
	
	private ResumeService resumeService;

	@Autowired
	public ResumeController(ResumeService resumeService) {
		super();
		this.resumeService = resumeService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<ResumeDto>> getAll(){
		return this.resumeService.getAll();
	}
	
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody ResumeAddDto resumeAddDto) {
		return ResponseEntity.ok(resumeService.add(resumeAddDto));
	  }
	
	
	@PutMapping("/uploadImage") //güncelleme işlemi olduğunu belirttik.
	//resim yüklemiceksek @RequestBody 
	public Result saveImage(@RequestBody MultipartFile file,@RequestParam int resumeId) {
		return this.resumeService.saveImage(file, resumeId);
		
	}
	
	@GetMapping("/getByCandidateIdList")
	public DataResult<List<ResumeDto>> findAllByCandidateId(@RequestParam("user_id") int candidateId) {
		return this.resumeService.findAllByCandidateId(candidateId);
	}
	
	@GetMapping("/getByCandidateId")
	public DataResult<Resume> getByCandidateId(int candidateId) {
		return this.resumeService.getByCandidateId(candidateId);
	}
	
}