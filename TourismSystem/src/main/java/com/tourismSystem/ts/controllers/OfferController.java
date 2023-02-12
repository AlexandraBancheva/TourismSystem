package com.tourismSystem.ts.controllers;

import com.tourismSystem.ts.entities.Category;
import com.tourismSystem.ts.entities.Offer;
import com.tourismSystem.ts.entities.Transport;
import com.tourismSystem.ts.services.CategoryService;
import com.tourismSystem.ts.services.OfferService;
import com.tourismSystem.ts.services.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;

@Controller
public class OfferController {
    private OfferService offerService;
    private CategoryService categoryService;
    private TransportService transportService;

    public OfferController(OfferService offerService,
                           CategoryService categoryService,
                           TransportService transportService) {
        this.offerService = offerService;
        this.categoryService = categoryService;
        this.transportService = transportService;
    }

    @ModelAttribute("categories")
    public List<Category> getAllCategories(){
        List<Category> listCategories = new ArrayList<>();
        listCategories.addAll(categoryService.getAllCategories());
        return listCategories;
    }

    @ModelAttribute("transports")
    public List<Transport> getAllTransports(){
        List<Transport> listTransports = new ArrayList<>();
        listTransports.addAll(transportService.getAllTransports());
        return listTransports;
    }

    @GetMapping("/offers/new")
    public String createNewOffer(Model model){
        Offer offer = new Offer();
        model.addAttribute("offer", offer);
        return "create_offer";
    }
}
