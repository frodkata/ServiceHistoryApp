package serviceHistoryApplication.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import serviceHistoryApplication.Entities.UserProfile;

@Repository
public interface UserRepository extends JpaRepository<UserProfile, Long>{
   UserProfile findByVin(String vin);
}
