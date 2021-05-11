package kodlamaio.HRMS.Java.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.Java.business.abstracts.JobPositionsService;
import kodlamaio.HRMS.Java.dataAccess.abstracts.JobPositionsDao;
import kodlamaio.HRMS.Java.entities.concretes.JobPositions;
@Service
public class JobPositionsManager implements JobPositionsService {
	
	private JobPositionsDao jobPositonsDao;
	@Autowired
	public JobPositionsManager(JobPositionsDao jobPositonsDao) {
		super();
		this.jobPositonsDao = jobPositonsDao;
	}

	@Override
	public List<JobPositions> getAll() {
		
		return this.jobPositonsDao.findAll();
		
	}

}
