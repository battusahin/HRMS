package kodlamaio.HRMS.Java.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import kodlamaio.HRMS.Java.business.abstracts.JobTitleService;
import kodlamaio.HRMS.Java.core.utilities.results.DataResult;
import kodlamaio.HRMS.Java.core.utilities.results.ErrorResult;
import kodlamaio.HRMS.Java.core.utilities.results.Result;
import kodlamaio.HRMS.Java.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.Java.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.Java.dataAccess.abstracts.JobTitleDao;
import kodlamaio.HRMS.Java.entities.concretes.JobTitle;
import kodlamaio.HRMS.Java.core.constants.Messages;

@Service
public class JobTitleManager implements JobTitleService {
    private JobTitleDao jobTitleDao;

    @Autowired
    public JobTitleManager(JobTitleDao jobTitleDao) {
        this.jobTitleDao = jobTitleDao;
    }

    @Override
    public DataResult<List<JobTitle>> getAll() {
        return new SuccessDataResult<>(this.jobTitleDao.findAll(), Messages.JOB_POSITION_SUCCESS_DATA_LISTED);
    }

    @Override
    public Result add(JobTitle jobTitle) {


        if(jobTitleDao.findAllByTitle(jobTitle.getTitle()).stream().count() !=0 ) {
            return new ErrorResult(Messages.JOB_POSITION_ERROR_ALREADY_EXISTS);
       }
        this.jobTitleDao.save(jobTitle);
        return new SuccessResult(Messages.JOB_POSITION_SUCCESS_ADDED);
    }


}
