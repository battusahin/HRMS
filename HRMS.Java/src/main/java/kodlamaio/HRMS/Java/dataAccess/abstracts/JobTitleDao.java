package kodlamaio.HRMS.Java.dataAccess.abstracts;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;


import kodlamaio.HRMS.Java.entities.concretes.JobTitle;


public interface JobTitleDao extends JpaRepository<JobTitle, Integer> {

    List<JobTitle> findAllByTitle(String title);
}
