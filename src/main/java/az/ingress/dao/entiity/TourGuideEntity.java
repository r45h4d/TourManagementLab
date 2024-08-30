package az.ingress.dao.entiity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "tour_guide",
uniqueConstraints = @UniqueConstraint(columnNames = {"guide_id", "start_date"}))
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TourGuideEntity {
    @EmbeddedId
    private TourGuideId id;

    @ManyToOne(fetch = LAZY)
    @MapsId("tourId")
    @JoinColumn(name = "tour_id")
    @ToString.Exclude
    private TourEntity tourEntity;

    @ManyToOne(fetch = LAZY)
    @MapsId("guideId")
    @JoinColumn(name = "guide_id")
    @ToString.Exclude
    private GuideEntity guideEntity;

    @Column(name = "start_date")
    private Date startDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TourGuideEntity that = (TourGuideEntity) o;
        return Objects.equals(tourEntity, that.tourEntity) && Objects.equals(guideEntity, that.guideEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tourEntity, guideEntity);
    }
}
