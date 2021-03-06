package kodlamaio.hrms.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPostingService;
import kodlamaio.hrms.core.utilities.dtoConverter.DtoConverterService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPostingDao;
import kodlamaio.hrms.entities.concretes.JobPosting;
import kodlamaio.hrms.entities.dtos.JobPostingAddDto;
import kodlamaio.hrms.entities.dtos.JobPostingDto;

@Service
public class JobPostingManager implements JobPostingService {

	private JobPostingDao jobPostingDao;
	private DtoConverterService dtoConverterService;
	private ModelMapper modelMapper;

	@Autowired
	public JobPostingManager(JobPostingDao jobPostingDao, ModelMapper modelMapper,
			DtoConverterService dtoConverterService) {
		super();
		this.jobPostingDao = jobPostingDao;
		this.modelMapper = modelMapper;
		this.dtoConverterService = dtoConverterService;
	}

	private JobPosting dtoConvert(JobPostingAddDto jobPostingAddDto) {
		return modelMapper.map(jobPostingAddDto, JobPosting.class);

	}

	@Override
	public Result add(JobPostingAddDto jobPostingAddDto) {
		this.jobPostingDao.save(dtoConvert(jobPostingAddDto));
		return new SuccessResult("İş İlanı Eklendi");
	}

	@Override
	public Result delete(JobPosting jobPosting) {
		this.jobPostingDao.delete(jobPosting);
		return new SuccessResult("Silme işlemi Tamamlandı");
	}

	@Override
	public DataResult<List<JobPostingDto>> findByIsActive() {
		return new SuccessDataResult<List<JobPostingDto>>(
				dtoConverterService.dtoConverter(jobPostingDao.findByIsActive(true), JobPostingDto.class));

	}

	@Override
	public DataResult<List<JobPostingDto>> findByIsActiveOrderByClosedDate() {
		return new SuccessDataResult<List<JobPostingDto>>(this.dtoConverterService.dtoConverter(
				this.jobPostingDao.findByIsActiveOrderByClosedDate(true), JobPostingDto.class), "Data Listelendi");
	}

	@Override
	public DataResult<List<JobPostingDto>> findByIsActiveAndEmployer_CompanyName(String companyName) {
		return new SuccessDataResult<List<JobPostingDto>>(this.dtoConverterService.dtoConverter(
				this.jobPostingDao.findByIsActiveAndEmployer_CompanyName(true, companyName), JobPostingDto.class),
				"Data Listelendi");
	}

	@Override
	public DataResult<List<JobPostingDto>> findByCity_Name(String name) {
		return new SuccessDataResult<List<JobPostingDto>>(
				this.dtoConverterService.dtoConverter(this.jobPostingDao.findByCity_Name(name), JobPostingDto.class),
				"Data Listelendi");
	}

	@Override
	public DataResult<JobPosting> getById(int id) {
		
		return new SuccessDataResult<JobPosting>(jobPostingDao.getById(id), "Data Listelendi.");
		
	}

}
