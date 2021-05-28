package kodlamaio.HRMS.Java.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.Java.core.utilities.results.DataResult;
import kodlamaio.HRMS.Java.entities.concretes.User;

public interface UserService {
    DataResult<List<User>> getAll();
    User add(User user);
}