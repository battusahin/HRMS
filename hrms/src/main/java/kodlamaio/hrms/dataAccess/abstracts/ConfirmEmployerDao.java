package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.ConfirmEmployerByStuffUser;

public interface ConfirmEmployerDao extends JpaRepository<ConfirmEmployerByStuffUser, Integer> {

	ConfirmEmployerByStuffUser findByEmployer_UserId(int id);
	
	boolean findByEmployer_UserIdEquals(int id);
	
}
