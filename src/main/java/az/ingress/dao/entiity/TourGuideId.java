package az.ingress.dao.entiity;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TourGuideId implements Serializable {
    @Column(name = "tour_id")
    private Long tourId;
    @Column(name = "guide_id")
    private Long guideId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TourGuideId that = (TourGuideId) o;
        return Objects.equals(tourId, that.tourId) && Objects.equals(guideId, that.guideId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tourId, guideId);
    }
}
