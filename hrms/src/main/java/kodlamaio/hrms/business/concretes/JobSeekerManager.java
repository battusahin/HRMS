package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.adapters.abstracts.EmailValidationService;
import kodlamaio.hrms.core.adapters.abstracts.FakeMernisService;
import kodlamaio.hrms.core.adapters.abstracts.RegexService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService{
	
	private JobSeekerDao jobSeekerDao;
	private FakeMernisService fakeMernisService;
	private RegexService regexService;
	private EmailValidationService emailValidationService;
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, FakeMernisService fakeMernisService, RegexService regexService) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.fakeMernisService = fakeMernisService;
		this.regexService = regexService;
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(), "Sistemdeki adaylar basarili sekilde listelendi.");
	}

	@Override
	public Result add(JobSeeker jobSeeker) {
		if(jobSeeker.getFirstName().isEmpty() || jobSeeker.getLastName().isEmpty()
				|| jobSeeker.getNationalityId().isEmpty() || jobSeeker.getDayOfBirth().equals(null)
				|| jobSeeker.getEmail().isEmpty() || jobSeeker.getPassword().isEmpty()) {
			return new ErrorResult("Aday ekleme islemi basarisiz, Bos alan birakmamalisin.");
		}
		if(!regexService.isFirstNameFormat(jobSeeker.getFirstName())) {
			return new ErrorResult("Aday ekleme islemi basarisiz, isim alani istenilen formatta degil.");
		}
		if(!regexService.isLastNameFormat(jobSeeker.getLastName())) {
			return new ErrorResult("Aday ekleme islemi basarisiz, soyisim alani istenilen formatta degil.");
		}
		if(!regexService.isBirthYearFormat(jobSeeker.getDayOfBirth())) {
			return new ErrorResult("Aday ekleme islemi basarisiz, dogum yili alani istenilen formatta degil.");
		}

		if(!fakeMernisService.checkMernis(jobSeeker.getNationalityId(), jobSeeker.getFirstName(), jobSeeker.getLastName(), jobSeeker.getDayOfBirth())) {
			return new ErrorResult("Aday ekleme islemi basarisiz, mernis dogrulamasi gerceklestirilemedi.");
		}
		if(jobSeekerDao.findByEmailEquals(jobSeeker.getEmail())!=null) {
			return new ErrorResult("Aday ekleme islemi basarisiz, girilen email adresi sistemde mevcut.");
		}
		if(jobSeekerDao.findByNationalityIdEquals(jobSeeker.getNationalityId())!=null) {
			return new ErrorResult("Aday ekleme islemi basarisiz, girilen Tc no sistemde mevcut.");
		}
		if(emailValidationService.emailValidation(jobSeeker.getEmail())==false) {
			return new ErrorResult("Aday ekleme islemi basarisiz, email alani istenilen formatta degil.");
		}
		if(!emailValidationService.emailButtonClick(jobSeeker.getEmail())) {
			return new ErrorResult("Aday Ekleme islemi basarisiz, dogrulama linkine tiklanmadi.");
		}
		else {
			this.jobSeekerDao.save(jobSeeker);
			return new SuccessResult("Aday ekleme islemi basarili bir sekilde gerceklestirildi.");
		}
	}

}
