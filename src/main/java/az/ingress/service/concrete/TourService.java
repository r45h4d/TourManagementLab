package az.ingress.service.concrete;

import az.ingress.dao.entiity.*;
import az.ingress.dao.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TourService {
    private final TourRepository tourRepository;
    private final GuideRepository guideRepository;
    private final TourGuideRepository tourGuideRepository;
    private final DestinationRepository destinationRepository;
    private final TravelerRepository travelerRepository;
    private final PassportRepository passportRepository;
    EntityManager entityManager;

    public void addTour(TourEntity tourEntity){tourRepository.save(tourEntity);}

    public void addDestination(DestinationEntity destinationEntity){
        destinationRepository.save(destinationEntity);
    }

    @Transactional
    public void assignDestination(Long tourId, Long destinationId){
        TourEntity tour = tourRepository.findById(tourId).orElseThrow();
        DestinationEntity destination = destinationRepository.findById(destinationId).orElseThrow();
        tour.getDestinationEntities().add(destination);
        destination.setTourEntity(tour);
        tourRepository.save(tour);
        destinationRepository.save(destination);
    }

    @Transactional
    public void addGuide(GuideEntity guideEntity) {
        PassportEntity passportEntity = guideEntity.getPassportEntity();
        passportEntity.setGuideEntity(guideEntity);
        guideRepository.save(guideEntity);
        //passportRepository.save(passportEntity);
    }


    public void addTraveler(TravelerEntity travelerEntity){
        travelerRepository.save(travelerEntity);
    }

    public void assignTraveler(Long tourId, Long travelerId){
        TourEntity tour = tourRepository.findById(tourId).orElseThrow();
        TravelerEntity traveler = travelerRepository.findById(travelerId).orElseThrow();
        tour.getTravelerEntities().add(traveler);
        tourRepository.save(tour);
    }

    public void assignGuide(Long tourId, Long guideId){
        TourEntity tour = tourRepository.findById(tourId).orElseThrow();
        GuideEntity guide = guideRepository.findById(guideId).orElseThrow();

        PassportEntity passport = guide.getPassportEntity();

        TourGuideEntity tourGuide = TourGuideEntity.builder().
                id(TourGuideId.builder().tourId(tourId).guideId(guideId).build()).
                tourEntity(tour).
                guideEntity(guide).
                startDate(tour.getStartDate()).
                build();

        tourGuideRepository.save(tourGuide);
    }

    public List<DestinationEntity> getDestinationsByTour(Long tourId){
        return destinationRepository.findAllByTourId(tourId);
    }

    public List<TravelerEntity> getTravelersByTour(Long tourId){
        return tourRepository.findById(tourId).orElseThrow().getTravelerEntities();
    }
}
