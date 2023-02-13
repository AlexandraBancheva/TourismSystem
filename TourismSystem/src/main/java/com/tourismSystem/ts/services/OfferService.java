package com.tourismSystem.ts.services;

import com.tourismSystem.ts.entities.Offer;

import java.util.List;

public interface OfferService {
    Offer saveOffer(Offer offer);

    List<Offer> getAllOffers();
}
