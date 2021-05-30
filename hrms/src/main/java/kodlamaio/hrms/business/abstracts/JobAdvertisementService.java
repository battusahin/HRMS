package kodlamaio.hrms.business.abstracts;
import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {
	Result add(JobAdvertisement jobAdvertisement);
	Result delete(int id);
	Result update(JobAdvertisement jobAdvertisement);
	DataResult<List<JobAdvertisement>> getByJobTitle_Title(String title);
	DataResult<List<JobAdvertisement>> getByIsEnableTrue();
	DataResult<List<JobAdvertisement>> getByIsEnableTrueOrderByCreatedDesc();
	DataResult<List<JobAdvertisement>> getByIsEnableTrueAndCompany_CompanyName(String companyName);
	DataResult<JobAdvertisement> getById(int id);
}
