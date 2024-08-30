package az.ingress.dao.entiity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="passports")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PassportEntity {
    @Id
    @Column(insertable = false, updatable = false)
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "passport_number")
    String passportNumber;

    @Column(name = "issue_date")
    Date issueDate;

    @Column(name = "expiry_date")
    Date expiryDate;
    String country;

    @OneToOne(fetch = LAZY)
    @MapsId
    @JoinColumn(name = "id")
    @ToString.Exclude
    private GuideEntity guideEntity;
}
