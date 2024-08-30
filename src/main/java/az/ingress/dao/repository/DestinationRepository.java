package az.ingress.dao.repository;

import az.ingress.dao.entiity.DestinationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DestinationRepository extends JpaRepository<DestinationEntity,Long> {
    @Query("SELECT d FROM DestinationEntity d JOIN FETCH d.tourEntity t WHERE t.id = :tourId")
    List<DestinationEntity> findAllByTourId(@Param("tourId") Long tourId);
}
