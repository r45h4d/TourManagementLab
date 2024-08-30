package az.ingress.model.mapper;

import az.ingress.dao.entiity.DestinationEntity;
import az.ingress.dao.entiity.TourEntity;
import az.ingress.dao.repository.TourRepository;
import az.ingress.model.request.DestinationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DestinationMapper {
    public static DestinationEntity buildDestinationEntity(DestinationRequest destinationRequest){
        return DestinationEntity.builder().
                location(destinationRequest.getLocation()).
                description(destinationRequest.getDescription()).
                visitDate(destinationRequest.getVisitDate()).
                build();
    }
}
