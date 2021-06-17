package kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Resume;
import kodlamaio.hrms.entities.dtos.ResumeAddDto;
import kodlamaio.hrms.entities.dtos.ResumeDto;

public interface ResumeService {

	Result add(ResumeAddDto resumeAddDto);

	DataResult<List<ResumeDto>> getAll();

	DataResult<List<ResumeDto>> findAllByCandidateId(int candidateId);

	Result saveImage(MultipartFile file, int resumeId);

	DataResult<Resume> getByCandidateId(int candidateId);
}
