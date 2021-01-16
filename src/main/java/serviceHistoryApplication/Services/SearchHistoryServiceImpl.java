package serviceHistoryApplication.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import serviceHistoryApplication.Entities.History;
import serviceHistoryApplication.Entities.UserProfile;
import serviceHistoryApplication.Repositories.HistoryRepository;
import serviceHistoryApplication.Repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchHistoryServiceImpl implements SearchHistoryService {

    @Autowired
    private HistoryRepository historyRepository;

    @Autowired
    private UserRepository userRepository;



    @Override
    //search entries by vin number
    public List<History> searchHistory(String vin)   {
        List<History> searchResult = new ArrayList<>();
        List<UserProfile> userProfiles = userRepository.findAll(); //fetch all entries


        if(userRepository.findByVin(vin) != null){ //Check if user with VIN exists
            UserProfile userProfile = userRepository.findByVin(vin); //instance of exiting user
            for (History h: historyRepository.findAll()) {
                if(h.getUserID().equals(userProfile.getId())){ //if ID of existing user with given VIN == user ID of history entry
                    searchResult.add(h);
                }
            }
        }else {
          //  throw new RuntimeException(" History not found for vin:: " + vin);
                return null;
        }







        return searchResult;
    }
}
