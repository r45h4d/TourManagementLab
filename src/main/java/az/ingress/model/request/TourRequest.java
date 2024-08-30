package az.ingress.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TourRequest {
    private String name;
    private String description;
    private BigDecimal price;
    private Date startDate;
    private Date endDate;
}

