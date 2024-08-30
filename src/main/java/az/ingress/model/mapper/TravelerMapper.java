package az.ingress.model.mapper;

import az.ingress.dao.entiity.DestinationEntity;
import az.ingress.dao.entiity.TravelerEntity;
import az.ingress.model.request.DestinationRequest;
import az.ingress.model.request.TravelerRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TravelerMapper {
    public static TravelerEntity buildTravelerEntity(TravelerRequest travelerRequest){
        return TravelerEntity.builder().
                firstName(travelerRequest.getFirstName()).
                lastName(travelerRequest.getLastName()).
                email(travelerRequest.getEmail()).
                build();
    }
}
