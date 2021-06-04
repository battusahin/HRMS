package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.ConfirmEmployerByStuffUser;

public interface ConfirmEmployerDao extends JpaRepository<ConfirmEmployerByStuffUser, Integer> {

	ConfirmEmployerByStuffUser findByEmployerId(int id);
	
	boolean existsByEmployerId(int id);
	
}
