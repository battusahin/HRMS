package kodlamaio.HRMS.Java.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import kodlamaio.HRMS.Java.entities.concretes.User;
import kodlamaio.HRMS.Java.business.abstracts.UserService;
import kodlamaio.HRMS.Java.core.utilities.results.DataResult;
@RestController
@RequestMapping("/api/users")
public class UsersController {
	private UserService userService;

	
	@Autowired
	public UsersController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping("/getall")
	@ResponseBody
	public DataResult<List<User>>  getAll(){
		return this.userService.getAll();
	}
}