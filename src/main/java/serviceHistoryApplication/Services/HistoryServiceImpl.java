package serviceHistoryApplication.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import serviceHistoryApplication.Entities.History;
import serviceHistoryApplication.Repositories.HistoryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HistoryServiceImpl implements HistoryService {
    @Autowired
    private HistoryRepository historyRepository;

    @Autowired
    private UserService userService;




    @Override
    //fetch all history from repository
    public List<History> getAllHistory() {
        return historyRepository.findAll();
    }

    @Override
    //save history to repository
    public void saveHistory(History history) {
        historyRepository.save(history);
    }

    @Override
    //fetch single entry by ID
    public History getHistoryById(long id) {
        Optional<History> optional = historyRepository.findById(id);
        History history = null;
        if (optional.isPresent()) {
            history = optional.get();
        } else {
            throw new RuntimeException(" History not found for id :: " + id);
        }
        return history;
    }

    @Override
    //delete entry by ID
    public void deleteHistoryById(long id) {
        historyRepository.deleteById(id);
    }



    @Override
    //fetch entries by the user who created them
    public List<History> getByUserId(Long id) {
        List<History> withUserId = new ArrayList<>();
        for ( History h: historyRepository.findAll() ) {
            if (h.getUserID().equals(id)) {
                withUserId.add(h);
            }
        }
        return withUserId;
    }




}
