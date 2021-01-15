package serviceHistoryApplication.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {


	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/searchHistory")
	public String searchHistory() {
		return "searchHistory";
	}


}
