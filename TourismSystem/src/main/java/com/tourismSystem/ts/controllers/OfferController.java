package com.tourismSystem.ts.controllers;

import com.tourismSystem.ts.entities.Offer;
import com.tourismSystem.ts.services.OfferService;
import org.springframework.stereotype.Controller;

@Controller
public class OfferController {
    private OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    public String createNewOffer(Offer offer){
        return "create_offer";
    }
}
