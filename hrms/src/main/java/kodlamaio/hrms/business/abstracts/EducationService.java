package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Education;
import kodlamaio.hrms.entities.dtos.EducationDto;

public interface EducationService {

	Result add(EducationDto educationDto);

	DataResult<List<EducationDto>> getAll();

	DataResult<List<EducationDto>> findAllByResumeIdOrderByStartedDateDesc(int id);

}
