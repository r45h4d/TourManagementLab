package az.ingress.dao.entiity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="guides")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GuideEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id;
    String name;
    String email;
    @Column(name = "phone_number")
    String phoneNumber;

    @OneToMany(
            mappedBy = "guideEntity"
//            cascade = ALL,
//            orphanRemoval = true
    )
    @ToString.Exclude
    private List<TourGuideEntity> tourGuideEntities;

    @OneToOne(
            mappedBy = "guideEntity",
           cascade = ALL,
            fetch = LAZY
    )
    @ToString.Exclude
    @JsonIgnore
    @PrimaryKeyJoinColumn
    private PassportEntity passportEntity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GuideEntity that = (GuideEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
