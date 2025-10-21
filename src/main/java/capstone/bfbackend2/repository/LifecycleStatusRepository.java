package capstone.bfbackend2.repository;

import capstone.bfbackend2.LifecycleStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LifecycleStatusRepository extends JpaRepository<LifecycleStatus, Long> {
}
