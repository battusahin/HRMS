package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobPosition;

public interface JopPositionDao extends JpaRepository<JobPosition, Integer> {

	boolean findByPositionEquals(String position);
	
}
