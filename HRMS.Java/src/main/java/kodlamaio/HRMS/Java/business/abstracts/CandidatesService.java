package kodlamaio.HRMS.Java.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.Java.core.utilities.results.DataResult;
import kodlamaio.HRMS.Java.core.utilities.results.Result;
import kodlamaio.HRMS.Java.entities.concretes.Candidate;

public interface CandidatesService {

    DataResult<List<Candidate>> getAll();
    Result add(Candidate candidate);

}