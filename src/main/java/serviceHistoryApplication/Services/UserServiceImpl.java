package serviceHistoryApplication.Services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import serviceHistoryApplication.Entities.UserProfile;
import serviceHistoryApplication.Repositories.UserRepository;


@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	

	@Override
	public UserProfile save(UserProfile userProfile) {
		String password = passwordEncoder.encode(userProfile.getPassword());
		userProfile.setPassword(password);
		return userRepository.save(userProfile);
	}




	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserProfile userProfile = userRepository.findByVin(username);
		if(userProfile == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}


		//https://stackoverflow.com/questions/37615034/spring-security-spring-boot-how-to-set-roles-for-users
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

		return new org.springframework.security.core.userdetails.User(userProfile.getVin(), userProfile.getPassword(), grantedAuthorities);
	}
	


	/*
	 * https://docs.spring.io/spring-security/site/docs/4.0.2.RELEASE/reference/htmlsingle/#obtaining-information-about-the-current-user
	 * Get current logged user object
	 * */
	@Override
	public UserProfile getCurrentUser() {
		String username;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			username = ((UserDetails)principal).getUsername();
		} else {
			username = principal.toString();
		}

		return userRepository.findByVin(username);
	}



}
