package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.core.utilities.dtoConverter.DtoConverterService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EducationDao;
import kodlamaio.hrms.entities.concretes.Education;
import kodlamaio.hrms.entities.dtos.EducationDto;

@Service
public class EducationManager implements EducationService{

	private EducationDao educationDao;
	private DtoConverterService dtoConverterService;
	
	@Autowired
	public EducationManager(EducationDao educationDao, DtoConverterService dtoConverterService) {
		super();
		this.educationDao = educationDao;
		this.dtoConverterService = dtoConverterService;
	}

	
	@Override
	public Result add(EducationDto educationDto) {
		educationDao.save((Education) dtoConverterService.dtoClassConverter(educationDto, Education.class));
		return new SuccessResult("Başarıyla Eklendi");
	}

	@Override
	public DataResult<List<EducationDto>> getAll() {
		return new SuccessDataResult<List<EducationDto>>(dtoConverterService.dtoConverter(educationDao.findAll(), EducationDto.class),"eğitimler listelendi.");
		
	}
	
	@Override
	public DataResult<List<EducationDto>> findAllByResumeIdOrderByStartedDateDesc(int id) {
		List<Education> education = educationDao.findAllByResumeIdOrderByEndedDateDesc(id);
		return new SuccessDataResult<List<EducationDto>>(
				dtoConverterService.dtoConverter(education, EducationDto.class), "education tarihe göre sıralandı");
	}

}
