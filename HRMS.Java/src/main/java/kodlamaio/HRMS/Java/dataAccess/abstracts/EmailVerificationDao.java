package kodlamaio.HRMS.Java.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HRMS.Java.entities.concretes.EmailVerification;

public interface EmailVerificationDao extends JpaRepository<EmailVerification, Integer>{
    List<EmailVerification> findByUserId(Integer userId);
}
