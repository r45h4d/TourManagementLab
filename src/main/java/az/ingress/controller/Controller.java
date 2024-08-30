package az.ingress.controller;

import az.ingress.dao.entiity.DestinationEntity;
import az.ingress.dao.entiity.TourEntity;
import az.ingress.dao.entiity.TravelerEntity;
import az.ingress.model.mapper.DestinationMapper;
import az.ingress.model.mapper.GuideMapper;
import az.ingress.model.mapper.TourMapper;
import az.ingress.model.mapper.TravelerMapper;
import az.ingress.model.request.DestinationRequest;
import az.ingress.model.request.GuideRequest;
import az.ingress.model.request.TourRequest;
import az.ingress.model.request.TravelerRequest;
import az.ingress.service.concrete.TourService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1")
public class Controller {
    private final TourService tourService;

    @PostMapping("/tour")
    @ResponseStatus(CREATED)
    public void addTour(@RequestBody TourRequest tourRequest){
        tourService.addTour(TourMapper.buildTourEntity(tourRequest));
    }

    @PostMapping("/destination")
    @ResponseStatus(CREATED)
    public void addDestination(@RequestBody DestinationRequest destinationRequest){
        tourService.addDestination(DestinationMapper.buildDestinationEntity(destinationRequest));
    }

    @PostMapping("/guide")
    @ResponseStatus(CREATED)
    public void addGuides(@RequestBody GuideRequest guideRequest){
        tourService.addGuide(GuideMapper.buildGuideEntity(guideRequest));
    }

    @PostMapping("/traveler")
    @ResponseStatus(CREATED)
    public void addTraveler(@RequestBody TravelerRequest travelerRequest){
        TravelerEntity travelerEntity = TravelerMapper.buildTravelerEntity(travelerRequest);
        tourService.addTraveler(travelerEntity);
    }

    @GetMapping("/tours/{tourId}/destinations")
    @ResponseStatus(OK)
    public List<DestinationEntity> getDestinationsByTour(@PathVariable Long tourId){
        return tourService.getDestinationsByTour(tourId);
    }

    @GetMapping("/tours/{tourId}/travelers")
    @ResponseStatus(OK)
    public List<TravelerEntity> getTravelersByTour(@PathVariable Long tourId){
        return tourService.getTravelersByTour(tourId);
    }

    @PatchMapping("/tours/{tourId}/guides/{guideId}")
    @ResponseStatus(NO_CONTENT)
    public void assignGuide(@PathVariable Long tourId, @PathVariable Long guideId){
        tourService.assignGuide(tourId,guideId);
    }

    @PatchMapping("/tours/{tourId}/travelers/{travelerId}")
    @ResponseStatus(NO_CONTENT)
    public void assignTraveler(@PathVariable Long tourId, @PathVariable Long travelerId){
        tourService.assignTraveler(tourId, travelerId);
    }

    @PatchMapping("/tours/{tourId}/destinations/{destinationId}")
    @ResponseStatus(NO_CONTENT)
    public void assignDestination(@PathVariable Long tourId, @PathVariable Long destinationId){
        tourService.assignDestination(tourId, destinationId);
    }
}
