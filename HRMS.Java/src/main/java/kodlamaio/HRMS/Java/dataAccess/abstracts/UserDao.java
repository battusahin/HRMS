package kodlamaio.HRMS.Java.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HRMS.Java.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer>{

}
