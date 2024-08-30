package az.ingress.model.mapper;

import az.ingress.dao.entiity.GuideEntity;
import az.ingress.model.request.GuideRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GuideMapper {
    public static GuideEntity buildGuideEntity(GuideRequest guideRequest){
        return GuideEntity.builder().
                name(guideRequest.getName()).
                email(guideRequest.getEmail()).
                phoneNumber(guideRequest.getPhoneNumber()).
                passportEntity(PassportMapper.buildPassportEntity(guideRequest.getPassport())).
                build();
    }
}
