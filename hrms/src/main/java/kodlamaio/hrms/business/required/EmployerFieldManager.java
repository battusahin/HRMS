package kodlamaio.hrms.business.required;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ConfirmEmployerService;
import kodlamaio.hrms.business.abstracts.FieldService;
import kodlamaio.hrms.business.abstracts.VerifyCodeService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerFieldManager implements FieldService<Employer> {

	@Autowired
	private EmployerDao employerDao;
	private UserDao userDao;
	private VerifyCodeService verifyCodeService;
	private ConfirmEmployerService confirmEmployerService; 
	
	public EmployerFieldManager(EmployerDao employerDao, UserDao userDao, VerifyCodeService verifyCodeService, ConfirmEmployerService confirmEmployerService) {
		super();
		this.employerDao = employerDao;
		this.userDao = userDao;
		this.verifyCodeService = verifyCodeService;
		this.confirmEmployerService = confirmEmployerService;
	}
	
	
	@Override
	public Result verifyData(Employer employer) {
		String[] splitMail = employer.getEmail().split("@");
		if (!splitMail[1].equals(employer.getWebAddress())) {
			return new ErrorResult("Yalnızca Şirket Web Sitenizin Uzantısına Sahip Bir Mail Adresiyle Kayıt Olabilirsiniz");
		}
		if (this.userDao.findByEmailEquals(employer.getEmail())) {
			return new ErrorResult("Mail Adresi Daha Önce Kullanıldı");
		}
		if (employer.getPassword().equals(employer.getPasswordRepeat()) == false) {
			return new ErrorResult("Şifreler Uyuşmuyor");
		}
		this.employerDao.save(employer);
		this.verifyCodeService.createVerifyCode(userDao.getOne(employer.getId()));
		this.confirmEmployerService.createConfirmEmployer(employer);
		this.verifyCodeService.sendMail(employer.getEmail());
		return new SuccessResult("Kayıt Başarılı");
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"Listeleme Başarılı");
	}
	
	
	
}
