package capstone.bfbackend2.repository;

import capstone.bfbackend2.WidgetMetrics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WidgetMetricsRepository extends JpaRepository<WidgetMetrics, Long> {
}
