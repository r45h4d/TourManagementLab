package az.ingress.dao.repository;

import az.ingress.dao.entiity.PassportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassportRepository extends JpaRepository<PassportEntity,Long> {
}
