package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper=false)
@Data
@Entity
@Table(name = "candidate_users")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@PrimaryKeyJoinColumn(name="user_id")
public class Candidate extends User {
	
	@NotBlank(message="İsim Alanı Bos Birakilamaz.")
	@Size(min = 3, message = "İsim alanında en az 3 karakter kullanmaniz gerekiyor.") 
	@Column(name="name")
	private String name;
	
	@NotBlank(message="Soyisim Alanı Boş olamaz")
	@Column(name="surname")
	private String surname;
	
	@NotBlank(message="TC Kimlik Numarası Alanı Boş Olamaz")
	@Size(min = 11, max=11, message = "TCKimlik No 11 hane olmalıdır")
	@Column(name="national_identity")
	private String nationalIdentity;
		
	@NotBlank(message="Doğum Yılı Alanı Boş Olamaz")
	@Column(name="birth_year")
	private String birth_year;
}