package az.ingress.model.request;

import az.ingress.dao.entiity.PassportEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GuideRequest {
    private String name;
    private String email;
    private String phoneNumber;
    private PassportRequest passport;
}
