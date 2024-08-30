package az.ingress.dao.entiity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "destinations")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DestinationEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id;

    String location;

    String description;

    @Column(name = "visit_date")
    Date visitDate;

    @JsonIgnore
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "tour_id")
    @ToString.Exclude
    private TourEntity tourEntity;
}
