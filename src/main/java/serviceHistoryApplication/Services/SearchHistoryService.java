package serviceHistoryApplication.Services;

import org.springframework.stereotype.Service;
import serviceHistoryApplication.Entities.History;

import java.util.List;

@Service
public interface SearchHistoryService {
    List<History> searchHistory(String vin);
}
