package az.ingress.model.mapper;

import az.ingress.dao.entiity.PassportEntity;
import az.ingress.model.request.PassportRequest;

public class PassportMapper {
    public static PassportEntity buildPassportEntity(PassportRequest passportRequest){
        return PassportEntity.builder().
                passportNumber(passportRequest.getPassportNumber()).
                issueDate(passportRequest.getIssueDate()).
                expiryDate(passportRequest.getExpiryDate()).
                country(passportRequest.getCountry()).
                build();
    }
}
