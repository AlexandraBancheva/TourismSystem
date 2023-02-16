package com.tourismSystem.ts.controllers;

import com.tourismSystem.ts.entities.Category;
import com.tourismSystem.ts.entities.Offer;
import com.tourismSystem.ts.entities.Transport;
import com.tourismSystem.ts.services.CategoryService;
import com.tourismSystem.ts.services.ImageService;
import com.tourismSystem.ts.services.OfferService;
import com.tourismSystem.ts.services.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class OfferController {
    private OfferService offerService;
    private CategoryService categoryService;
    private TransportService transportService;
    private ImageService imageService;

    public OfferController(OfferService offerService,
                           CategoryService categoryService,
                           TransportService transportService,
                           ImageService imageService) {
        this.offerService = offerService;
        this.categoryService = categoryService;
        this.transportService = transportService;
        this.imageService = imageService;
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

    @GetMapping({"/offers", "/"})
    public ModelAndView listOffers(Model model){
        ModelAndView mav = new ModelAndView("list-offers");
        mav.addObject("offers", offerService.getAllOffers());
        return mav;
    }

    @GetMapping("/addOfferForm")
    public ModelAndView addOfferForm(){
        ModelAndView mav = new ModelAndView("add-offer-form");
        Offer newOffer = new Offer();
        mav.addObject("offer", newOffer);
        return mav;
    }

    @PostMapping("/saveOffer")
    public String saveOffer(@ModelAttribute Offer offer){
        offerService.saveOffer(offer);
        return "redirect:/offers";
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadImageToFileSystem(@RequestParam("image")MultipartFile file) throws IOException {
        String uploadImage = imageService.uploadImageToFileSystem(file);
        return ResponseEntity.status(HttpStatus.OK).body(uploadImage);
    }
}
