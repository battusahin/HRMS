package kodlamaio.HRMS.Java.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HRMS.Java.entities.concretes.Employees;


public interface EmployeesDao extends JpaRepository<Employees, Integer> {


}
