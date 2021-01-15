package serviceHistoryApplication.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import serviceHistoryApplication.Entities.History;

@Repository
public interface HistoryRepository extends JpaRepository<History,Long> {
}
