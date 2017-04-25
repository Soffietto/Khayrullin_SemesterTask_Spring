package ru.kpfu.itis.khayrullin.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.khayrullin.model.*;
import ru.kpfu.itis.khayrullin.service.CityService;
import ru.kpfu.itis.khayrullin.service.SpecialityService;
import ru.kpfu.itis.khayrullin.service.StudioService;
import ru.kpfu.itis.khayrullin.service.TeacherService;
import ru.kpfu.itis.khayrullin.util.forms.CityForm;
import ru.kpfu.itis.khayrullin.util.forms.SpecialityForm;
import ru.kpfu.itis.khayrullin.util.forms.StudioForm;
import ru.kpfu.itis.khayrullin.util.forms.TeacherForm;
import ru.kpfu.itis.khayrullin.util.transformers.CityFormToCityTransformer;
import ru.kpfu.itis.khayrullin.util.transformers.SpecialityFormToSpecialityTransformer;
import ru.kpfu.itis.khayrullin.util.transformers.StudioFormToStudioTransformer;
import ru.kpfu.itis.khayrullin.util.transformers.TeacherFormToTeahcerTransformer;

import java.util.List;
import java.util.function.Function;

@Controller
public class AdminController {

    private final CityService cityService;
    private final SpecialityService specialityService;
    private final TeacherService teacherService;
    private final StudioService studioService;
    private final Function<CityForm, City> cityTransfromer;
    private final Function<SpecialityForm, Specialty> specialtyTransformer;
    private final Function<TeacherForm, Teacher> teacherTransformer;
    private final Function<StudioForm, Studio> studioTransformer;

    public AdminController(CityService cityService, SpecialityService specialityService,
                           TeacherService teacherService, StudioService studioService) {
        this.cityService = cityService;
        this.specialityService = specialityService;
        this.teacherService = teacherService;
        this.studioService = studioService;
        this.specialtyTransformer = new SpecialityFormToSpecialityTransformer();
        this.teacherTransformer = new TeacherFormToTeahcerTransformer();
        this.studioTransformer = new StudioFormToStudioTransformer();
        this.cityTransfromer = new CityFormToCityTransformer();
    }

    @RequestMapping("/admin/home")
    public String getAdminPage(Model model) {
        User user = getCurrentUser(model);
        List<City> cityList = cityService.getAll();
        model.addAttribute("city_list", cityList);
        model.addAttribute("admin_url", "/admin");
        return "admin";
    }

    @RequestMapping("/admin/new_city")
    public String getNewCityPage(Model model) {
        User user = getCurrentUser(model);
        model.addAttribute("city", new CityForm());
        return "city_form";
    }

    @RequestMapping(value = "/admin/new_city", method = RequestMethod.POST)
    public String getNewCityPage(@ModelAttribute("city") CityForm cityForm) {
        City city = cityTransfromer.apply(cityForm);
        if (!cityService.getAll().contains(city))
            cityService.add(city);
        return "redirect:/admin/home";
    }

    @RequestMapping("/admin/city={city_id}")
    public String getStudioPage(@PathVariable(value = "city_id") Long cityId, Model model) {
        User user = getCurrentUser(model);
        model.addAttribute("city_id", cityId);
        List<Studio> studioList = studioService.findAllByCityId(cityId);
        model.addAttribute("studio_list", studioList);
        return "studio";
    }

    @RequestMapping("admin/city={city_id}/new_studio")
    public String getNewStudioPage(@PathVariable("city_id") Long cityId,  Model model){
        User user = getCurrentUser(model);
        City city = cityService.findOneById(cityId);
        model.addAttribute("city_name", city.getName());
        model.addAttribute("city_id", cityId);
        model.addAttribute("studio", new StudioForm());
        return "studio_form";
    }

    @RequestMapping(value = "admin/city={city_id}/new_studio", method = RequestMethod.POST)
    public String getNewStudioPage(@PathVariable("city_id") Long cityId,
                                   @ModelAttribute("studio") StudioForm studioForm){
        Studio studio = studioTransformer.apply(studioForm);
        City city = cityService.findOneById(cityId);
        studio.setCity(city);
        if(!studioService.getAll().contains(studio))
            studioService.add(studio);
        return "redirect:/admin/city={city_id}";
    }

    private User getCurrentUser(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        return user;
    }

    //TODO add specialty
}
