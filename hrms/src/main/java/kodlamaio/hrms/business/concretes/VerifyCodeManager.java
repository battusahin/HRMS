package kodlamaio.hrms.business.concretes;

import java.sql.Date;
import java.time.LocalDate;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.VerifyCodeService;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.dataAccess.abstracts.UserVerifyDao;
import kodlamaio.hrms.entities.concretes.User;
import kodlamaio.hrms.entities.concretes.UserVerify;

@Service
public class VerifyCodeManager implements VerifyCodeService {

	private UserVerifyDao userVerifyDao;
	private UserDao userDao;
	
	@Autowired
	public VerifyCodeManager(UserVerifyDao userVerifyDao, UserDao userDao) {
		super();
		this.userVerifyDao = userVerifyDao;
		this.userDao = userDao;
	}

	@Override
	public String createVerifyCode(User user) {
		String vCode = UUID.randomUUID().toString();
		UserVerify Code = new UserVerify();
		LocalDate e = (LocalDate.now());
		Code.setUserId(user);
		Code.setCreatedDate(Date.valueOf(e));
		Code.setVerifyCode(UUID.randomUUID().toString());
		this.userVerifyDao.save(Code);
		return vCode;
	}

	@Override
	public void sendMail(String mail) {
		
		System.out.println("Doğrulama Maili Gönderildi : " + mail);
	}

	@Override
    public Result verifyUser(String code) {

        if (!this.userVerifyDao.findByVerifyCode(code)) {
            return new ErrorResult("Hatalı Doğrulama İşlemi");
        }
        UserVerify newVerifyCode = userVerifyDao.findByVerifyCodeEquals(code);
        if (this.userVerifyDao.getOne(newVerifyCode.getId()).isConfirmed()) {
            return new ErrorResult("Doğrulama işlemi daha önce yapıldı");
        }
        LocalDate e = (LocalDate.now());
        newVerifyCode.setConfirmed(true);
        newVerifyCode.setConfirmedDate(Date.valueOf(e));
        userVerifyDao.save(newVerifyCode);
        User verifyUser = new User();
        verifyUser = userDao.getOne(newVerifyCode.getUserId().getId());
        verifyUser.setVerify(true);
        userDao.save(verifyUser);
        return new SuccessResult("Doğrulama Başarılı");


    }

	
		

}
