package kodlamaio.hrms.business.required;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.FieldService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.entities.concretes.JobPosition;

@Service
public class JobTitleFieldManager implements FieldService<JobPosition>{
	
	
	private JobPositionDao jobPositionDao;
	@Autowired
	public JobTitleFieldManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	
	@Override
	public Result verifyData(JobPosition jobPosition) {
		if (jobPositionDao.existsByPosition(jobPosition.getPosition())) {
			return new ErrorResult("Bu Pozisyon Daha Önce Kaydedildi");
		}
		
			this.jobPositionDao.save(jobPosition);
			return new SuccessResult("Kayıt Eklendi");
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(),"Listeleme Başarılı");
	}


}
