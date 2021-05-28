package kodlamaio.HRMS.Java.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.Java.business.abstracts.EmailVerificationService;
import kodlamaio.HRMS.Java.core.GenerateRandomCode;
import kodlamaio.HRMS.Java.core.utilities.results.ErrorDataResult;
import kodlamaio.HRMS.Java.core.utilities.results.Result;
import kodlamaio.HRMS.Java.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.Java.dataAccess.abstracts.EmailVerificationDao;
import kodlamaio.HRMS.Java.entities.concretes.EmailVerification;

@Service
public class EmailVerificationManager  implements EmailVerificationService{
    private EmailVerificationDao emailVerificationDao;

    @Autowired
    public EmailVerificationManager(EmailVerificationDao emailVerificationDao) {
        super();
        this.emailVerificationDao = emailVerificationDao;
    }

    @Override
    public void generateCode(EmailVerification code,Integer id) {
                //EmailVerification code1 = code;
                code.setCode(null);
                code.setVerified(false);
                if(code.isVerified() == false) {
                    GenerateRandomCode generator = new GenerateRandomCode();
                    String code_create = generator.create();
                    code.setCode(code_create);
                    code.setUserId(id);

                    emailVerificationDao.save(code);

                }
                return ;
    }
    @Override
    public Result verify(String verificationCode,Integer id) {
        // TODO Auto-generated method stub
        EmailVerification ref = emailVerificationDao.findByUserId(id).stream().findFirst().get();
        if(ref.getCode().equals(verificationCode) && ref.isVerified() != true) {
            ref.setVerified(true);
            return  new SuccessDataResult<EmailVerification>(this.emailVerificationDao.save(ref),"Başarılı");
        }
        else if(ref.isVerified() == true) {
            return  new ErrorDataResult<EmailVerification>(null,"Zaten Doğrulanmış Hesap");
        }
        return  new ErrorDataResult<EmailVerification>(null,"Doğrulama Kodu Geçersiz");


    }
}