package capstone.bfbackend2.repository;

import capstone.bfbackend2.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ColorRepository extends JpaRepository<Color, Long> {
    Optional<Color> findByColorLabelAndColorHex(String colorLabel, String colorHex);
}
