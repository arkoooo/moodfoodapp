package com.example.demo.controllers;

import com.example.demo.model.Users;
import com.example.demo.repositories.RestaurantsRepository;
import com.example.demo.repositories.ReviewsRepository;
import com.example.demo.repositories.UsersRepository;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;


@Controller
    public class MainController {
    private RestaurantsRepository restaurantsRepository;
    private ReviewsRepository reviewsRepository;
    private UsersRepository usersRepository;


    public MainController(RestaurantsRepository restaurantsRepository, ReviewsRepository reviewsRepository, UsersRepository usersRepository) {
        this.restaurantsRepository = restaurantsRepository;
        this.reviewsRepository = reviewsRepository;
        this.usersRepository = usersRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String homePage(){return "index";}

    @RequestMapping("/search")
    public String searchPage(Model model){
        model.addAttribute("restaurant", restaurantsRepository.findAll());
        return "search"; }

    @RequestMapping(value = "/locals", method = RequestMethod.GET)
    public String restaurantPage(Model model, @RequestParam(value = "localId") int localId) {
            model.addAttribute("reviews", reviewsRepository.findAll());
            model.addAttribute("restaurant", restaurantsRepository.findAll());
            model.addAttribute("users", usersRepository.findAll());
            return "locals";
        }

    @RequestMapping("/register")
    public String newUser(Model model){
        model.addAttribute("users", new Users());
        return "register";
        }
    @RequestMapping(value="/new", method = RequestMethod.GET)
    public String addUser(Model model, @Valid Users users, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            model.addAttribute("users", users);
            return "/register";
        } else {
            usersRepository.save(users);
            return "redirect:/index";
        }
        }
}

