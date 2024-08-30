package az.ingress.dao.entiity;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="travelers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TravelerEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id;
    @Column(name = "first_name")
    String firstName;
    @Column(name = "last_name")
    String lastName;
    String email;
}
