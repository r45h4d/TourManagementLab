package az.ingress.dao.entiity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="tours")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TourEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id;

    String name;

    String description;

    BigDecimal price;

    @Column(name = "start_date")
    Date startDate;

    @Column(name = "end_date")
    Date endDate;

    @OneToMany(
            mappedBy = "tourEntity",
            cascade = ALL)
    @ToString.Exclude
    private List<DestinationEntity> destinationEntities;

    @OneToMany(
            mappedBy = "tourEntity",
            cascade = ALL,
            orphanRemoval = true
    )
    @ToString.Exclude
    private List<TourGuideEntity> tourGuideEntities;

    @ManyToMany(cascade = ALL)
    @JoinTable(
            name="tour_traveler",
            joinColumns = @JoinColumn(name = "tour_id"),
            inverseJoinColumns = @JoinColumn(name = "traveler_id")
    )
    @ToString.Exclude
    private List<TravelerEntity> travelerEntities;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TourEntity that = (TourEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
