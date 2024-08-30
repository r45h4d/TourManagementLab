package az.ingress.model.mapper;

import az.ingress.dao.entiity.TourEntity;
import az.ingress.model.request.TourRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TourMapper {
    public static TourEntity buildTourEntity(TourRequest tourRequest){
        return TourEntity.builder().
                name(tourRequest.getName()).
                description(tourRequest.getDescription()).
                price(tourRequest.getPrice()).
                startDate(tourRequest.getStartDate()).
                endDate(tourRequest.getEndDate()).
                build();
    }
}
