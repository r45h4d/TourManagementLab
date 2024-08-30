package az.ingress.dao.repository;

import az.ingress.dao.entiity.GuideEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuideRepository extends JpaRepository<GuideEntity,Long> {
}
