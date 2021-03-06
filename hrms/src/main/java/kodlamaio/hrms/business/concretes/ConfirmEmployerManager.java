package kodlamaio.hrms.business.concretes;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ConfirmEmployerService;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ConfirmEmployerDao;
import kodlamaio.hrms.entities.concretes.ConfirmEmployer;

import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;

@Service
public class ConfirmEmployerManager implements ConfirmEmployerService {

	private ConfirmEmployerDao confirmEmployerDao;
	private EmployerDao employerDao;
	@Autowired
	public ConfirmEmployerManager(ConfirmEmployerDao confirmEmployerDao, EmployerDao employerDao) {
		super();
		this.confirmEmployerDao = confirmEmployerDao;
		this.employerDao = employerDao;
	}

	@Override
	public void createConfirmEmployer(Employer employer) {
		ConfirmEmployer  cUser = new ConfirmEmployer();
		cUser.setEmployer(employer);
		cUser.setStaffUser(1);
		this.confirmEmployerDao.save(cUser);
		
		
	}

	@Override
	public Result confirmUser(String companyName) {
		if (!employerDao.existsByCompanyName(companyName)) {
			return new ErrorResult("Şirket Kaydı Bulunamadı");
		}
		
		if (employerDao.getByCompanyName(companyName).isUserConfirm()) {
			return new ErrorResult("Daha önce onaylanmış Şirket");
		}
		
		Employer employer = new Employer();
		ConfirmEmployer cUser = new ConfirmEmployer();
		employer = employerDao.getByCompanyName(companyName);
		employer.setUserConfirm(true);
		employerDao.save(employer);
		cUser = confirmEmployerDao.getByEmployer_Id(employer.getId());
		cUser.setConfirmed(true);
		LocalDate e = (LocalDate.now());
		cUser.setConfirmedDate(Date.valueOf(e));
		confirmEmployerDao.save(cUser);
		return new SuccessResult("Doğrulama Başarılı");
	}
	
	
	
	
	
	

}