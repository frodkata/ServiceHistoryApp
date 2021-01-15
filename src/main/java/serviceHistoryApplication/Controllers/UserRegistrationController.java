package serviceHistoryApplication.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import serviceHistoryApplication.Entities.UserProfile;
import serviceHistoryApplication.Repositories.UserRepository;
import serviceHistoryApplication.Services.UserService;

import javax.validation.Valid;


@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;


	
	@ModelAttribute("userProfile")
    public UserProfile userProfile() {
        return new UserProfile();
    }

	@GetMapping
	public String showRegistrationForm() {
		return "registration";
	}
	
	@PostMapping
	public String registerUserAccount(@Valid @ModelAttribute("userProfile") UserProfile userProfile, BindingResult bindingResult) {

		//check fields for form validation
		if(userRepository.findByVin(userProfile.getVin()) != null){  //first check if user with given VIN exists in repository
			return "redirect:/registration?error";
		}else{
			if(bindingResult.hasErrors() ){  //check if entity constraints are satisfied
				return "/registration";
			}else{
				userService.save(userProfile);	//Save validated user to repository
				return "redirect:/registration?success";
			}
		}








	}
}
