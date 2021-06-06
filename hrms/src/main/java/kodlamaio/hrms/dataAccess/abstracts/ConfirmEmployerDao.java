package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.ConfirmEmployerByStuffUser;
@Repository
public interface ConfirmEmployerDao extends JpaRepository<ConfirmEmployerByStuffUser, Integer> {

	ConfirmEmployerByStuffUser getByEmployer_Id(int id);
	boolean  existsByEmployer_Id(int id);
	
}
