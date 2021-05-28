package kodlamaio.HRMS.Java.business.abstracts;

import kodlamaio.HRMS.Java.core.utilities.results.Result;
import kodlamaio.HRMS.Java.entities.concretes.EmailVerification;

public interface EmailVerificationService {
    void generateCode(EmailVerification code, Integer id);
    Result verify(String verificationCode, Integer id);
}
