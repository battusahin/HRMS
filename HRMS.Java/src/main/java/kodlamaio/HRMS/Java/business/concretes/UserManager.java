package kodlamaio.HRMS.Java.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.Java.business.abstracts.UserService;
import kodlamaio.HRMS.Java.core.utilities.results.DataResult;
import kodlamaio.HRMS.Java.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.Java.dataAccess.abstracts.UserDao;
import kodlamaio.HRMS.Java.entities.concretes.User;

@Service
public class UserManager implements UserService{


    private UserDao userDao;
    public UserManager() {

    }
    @Autowired
    public UserManager(UserDao userDao) {
        this.userDao=userDao;
    }

    @Override
    public DataResult<List<User>> getAll() {
        // TODO Auto-generated method stub
        return new SuccessDataResult<List<User>>(userDao.findAll(),"Başarılı Şekilde Kullanıcılar Listelendi");
    }

    @Override
    public User add(User user) {
        return userDao.save(user);
    }

}
