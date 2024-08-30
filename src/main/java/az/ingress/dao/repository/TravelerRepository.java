package az.ingress.dao.repository;

import az.ingress.dao.entiity.TravelerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TravelerRepository extends JpaRepository<TravelerEntity,Long> {
    @Query("SELECT t.travelerEntities FROM TourEntity t WHERE t.id = : tourId")
    List<TravelerEntity> findAllByTourId(Long tourId);
}
