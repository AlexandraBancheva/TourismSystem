package com.tourismSystem.ts.services;

import com.tourismSystem.ts.entities.Offer;
import com.tourismSystem.ts.repositories.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {
    @Autowired
    private OfferRepository offerRepository;

    @Override
    public Offer saveOffer(Offer offer) {
        return null;
    }

    @Override
    public List<Offer> getAllOffers() {
        return offerRepository.findAll();
    }
}
