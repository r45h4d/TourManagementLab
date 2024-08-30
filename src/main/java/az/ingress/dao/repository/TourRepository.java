package az.ingress.dao.repository;

import az.ingress.dao.entiity.GuideEntity;
import az.ingress.dao.entiity.TourEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface TourRepository extends JpaRepository<TourEntity,Long> {
    @Override
    @EntityGraph(attributePaths = {"travelerEntities"})
    Optional<TourEntity> findById(Long aLong);

    @Query("SELECT t FROM TourEntity t JOIN FETCH t.travelerEntities tr WHERE tr.id = : travelerId")
    List<TourEntity> findToursByTravelerId(@Param("travelerId") Long travelerId);

    @EntityGraph(attributePaths = {"guideEntity.passportEntity"})
    @Query("SELECT tg.guideEntity FROM TourGuideEntity tg JOIN FETCH TourEntity t WHERE t.id = : tourId")
    List<GuideEntity> findGuideWithPassportByTourId(@Param("tourId") Long tourId);

    @Query("SELECT g FROM GuideEntity g LEFT JOIN FETCH TourGuideEntity tg WHERE tg.tourEntity is NULL OR tg.tourEntity.startDate > : endDate OR tg.tourEntity.endDate < : startDate")
    List<GuideEntity> findGuidesAvailable(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
