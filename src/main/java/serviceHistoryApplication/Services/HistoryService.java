package serviceHistoryApplication.Services;

import org.springframework.stereotype.Service;
import serviceHistoryApplication.Entities.History;

import java.util.List;

@Service
public interface HistoryService {
    List<History> getAllHistory();
    void saveHistory(History history);
    History getHistoryById(long id);
    void deleteHistoryById(long id);
    List<History> getByUserId(Long id);
}
