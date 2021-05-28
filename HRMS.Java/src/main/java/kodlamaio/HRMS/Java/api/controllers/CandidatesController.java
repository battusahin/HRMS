package kodlamaio.HRMS.Java.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HRMS.Java.business.abstracts.CandidatesService;
import kodlamaio.HRMS.Java.core.utilities.results.Result;
import kodlamaio.HRMS.Java.core.utilities.results.DataResult;
import kodlamaio.HRMS.Java.entities.concretes.Candidate;


import java.util.List;

@RestController
@RequestMapping("/api/candidates")
public class CandidatesController {
    private CandidatesService candidateService;

    @Autowired
    public CandidatesController(CandidatesService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping("/getall")
    public DataResult<List<Candidate>> getAll(){
        return this.candidateService.getAll();
    }
     @PostMapping("/add")
    public Result add(@RequestBody Candidate candidate){
        return this.candidateService.add(candidate);
    }
}
