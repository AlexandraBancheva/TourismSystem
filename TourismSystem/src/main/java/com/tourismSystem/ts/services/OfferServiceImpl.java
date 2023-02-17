package com.tourismSystem.ts.services;

import com.tourismSystem.ts.entities.Image;
import com.tourismSystem.ts.entities.Offer;
import com.tourismSystem.ts.repositories.ImageRepository;
import com.tourismSystem.ts.repositories.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {
    @Autowired
    private OfferRepository offerRepository;
    @Autowired
    private ImageRepository imageRepository;

    @Override
    public Offer saveOffer(Offer model) {
        Offer offer = new Offer();
        offer.setFullName(model.getFullName());
        offer.setCategory(model.getCategory());
        offer.setTransport(model.getTransport());
        offer.setStartDate(model.getStartDate());
        offer.setEndDate(model.getEndDate());
        offer.setPricePerPerson(model.getPricePerPerson());
        offer.setPriceIncludes(model.getPriceIncludes());
        offer.setPriceDoesNotInclude(model.getPriceDoesNotInclude());
        offer.setCreatedApplicationUser(model.getCreatedApplicationUser());


        for (Image image: model.getImages()) {
            imageRepository.save(image);
        }
        offerRepository.save(offer);
        return offer;
    }

    @Override
    public List<Offer> getAllOffers() {
        return offerRepository.findAll();
    }
}
