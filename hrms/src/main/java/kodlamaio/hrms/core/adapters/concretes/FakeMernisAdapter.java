package kodlamaio.hrms.core.adapters.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.adapters.abstracts.FakeMernisService;

@Service
public class FakeMernisAdapter implements FakeMernisService {

	@Override
	public boolean checkMernis(String nationalityId, String firstName, String lastName, String dayOfBirth) {

		String regex = "^[0-9]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(nationalityId);

		if (nationalityId.length() != 11) {
			System.out.println("Warning: TC kimlik numarasi 11 haneden olusmalidir.");
			return false;
		}else if(!matcher.matches() && nationalityId.startsWith("0")) {
			System.out.println("Warning: Tc kimlik numarasi rakamlardan olusmalidir ve sifir ile baslayamaz.");
			return false;
		}else if(firstName.length() < 2 || lastName.length() < 2) {
			System.out.println("Warning: İsim ve Soyisim 2 karakterden küçük olamaz.");
			return false;
		}else if(dayOfBirth.length() != 4) {
			System.out.println("Dogum yiliniz 4 haneden olusmalidir.");
			return false;
		} else{
			System.out.println("Mernis dogrulamasi gerceklesmistir.");
			return true;
		}
	}

}
