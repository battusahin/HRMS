package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Stuff;

public interface StuffDao extends JpaRepository<Stuff, Integer> {

}
