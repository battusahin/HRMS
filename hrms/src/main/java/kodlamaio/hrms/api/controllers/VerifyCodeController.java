package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.VerifyCodeService;
import kodlamaio.hrms.core.utilities.result.Result;

@CrossOrigin
@RestController
@RequestMapping("/valid")
public class VerifyCodeController {

	private VerifyCodeService verificationService;
	
	@Autowired
	public VerifyCodeController(VerifyCodeService verificationService) {
		super();
		this.verificationService = verificationService;
	}


	@PutMapping("/{verifyCode}")
	public Result update(@PathVariable("verifyCode") String verifyCode) {
		return verificationService.verifyUser(verifyCode);
	}
	
	
}