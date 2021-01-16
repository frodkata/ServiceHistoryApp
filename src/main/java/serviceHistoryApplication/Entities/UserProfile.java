package serviceHistoryApplication.Entities;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name =  "user_profile", uniqueConstraints = @UniqueConstraint(columnNames = "vin"), schema = "service_history")
public class UserProfile {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;

	@Column(name = "vin")
	@Size(min = 4, max = 35, message = "VIN трябва да е между 4 и 35 символа")
	private String vin;

	@Column(name = "password")
	@Size(min = 4, message = "Паролата трябва да е над 4 символа")
	private String password;
	



	public UserProfile() {
		
	}
	
	public UserProfile(String vin, String password) {
		super();

		this.vin = vin;
		this.password = password;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
