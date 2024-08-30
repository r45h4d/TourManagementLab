package az.ingress.dao.repository;

import az.ingress.dao.entiity.TourGuideEntity;
import az.ingress.dao.entiity.TourGuideId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourGuideRepository extends JpaRepository<TourGuideEntity, TourGuideId> {
}
