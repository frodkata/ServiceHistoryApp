package serviceHistoryApplication.Services;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import serviceHistoryApplication.Entities.UserProfile;

@Service
public interface UserService extends UserDetailsService{
	UserProfile save(UserProfile userProfile);
	UserProfile getCurrentUser();


}
