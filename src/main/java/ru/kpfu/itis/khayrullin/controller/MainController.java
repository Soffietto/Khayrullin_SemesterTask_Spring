package ru.kpfu.itis.khayrullin.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kpfu.itis.khayrullin.model.City;
import ru.kpfu.itis.khayrullin.model.User;
import ru.kpfu.itis.khayrullin.service.CityService;

import java.util.List;

@Controller
public class MainController {

    private final CityService cityService;

    public MainController(CityService cityService) {
        this.cityService = cityService;
    }

    @RequestMapping("/home")
    public String getHome(Model model) {
        User user = getCurrentUser(model);
        List<City> cityList = cityService.getAll();
        model.addAttribute("city_list", cityList);
        if(user.getEmail().equals("admin@admin.com"))
            return "redirect:/admin/home";
        return "home";
    }

    private User getCurrentUser(Model model){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        return user;
    }
}
