package ru.kpfu.itis.khayrullin.controller;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.khayrullin.model.*;
import ru.kpfu.itis.khayrullin.service.*;

import java.util.List;

@Controller
public class MainController {

    private final CityService cityService;
    private final SpecialtyService specialtyService;
    private final TeacherService teacherService;
    private final StudioService studioService;
    private final ScheduleService scheduleService;

    public MainController(CityService cityService, SpecialtyService specialtyService,
                          TeacherService teacherService, StudioService studioService,
                          ScheduleService scheduleService) {
        this.cityService = cityService;
        this.specialtyService = specialtyService;
        this.teacherService = teacherService;
        this.studioService = studioService;
        this.scheduleService = scheduleService;
    }

    @RequestMapping("/home")
    public String getHomePage(Model model) {
        User user = getCurrentUser(model);
        List<City> cityList = cityService.getAll();
        model.addAttribute("city_list", cityList);
        return "home";
    }

    @RequestMapping(value = "/city_search", method = RequestMethod.POST)
    public String getCitySearchPage(@RequestParam("search") String cityName){
        City city = cityService.findOneByName(cityName);
        if(city == null)
            return "redirect:/home";
        return "redirect:/city=" + city.getId();
    }

    @RequestMapping("/city={city_id}")
    public String getStudioPage(@PathVariable(value = "city_id") Long cityId, Model model) {
        User user = getCurrentUser(model);
        City city = cityService.findOneById(cityId);
        model.addAttribute("city_id", cityId);
        model.addAttribute("city_name", city.getName());
        List<Studio> studioList = studioService.findAllByCityId(cityId);
        model.addAttribute("studio_list", studioList);
        return "studio";
    }

    @RequestMapping(value = "/city={city_id}/studio_search", method = RequestMethod.POST)
    public String getStudioSearchPage(@RequestParam("search") String studioName,
                                      @PathVariable("city_id") Long cityId){
        Studio studio = studioService.findOneByNameAndCityId(studioName, cityId);
        if(studio == null)
            return "redirect:/city={city_id}";
        return "redirect:/city={city_id}/studio=" + studio.getId();
    }

    @RequestMapping("/city={city_id}/studio={studio_id}")
    public String getSpecialtyPage(@PathVariable(value = "city_id") Long cityId,
                                   @PathVariable(value = "studio_id") Long studioId,
                                   Model model) {
        User user = getCurrentUser(model);
        City city = cityService.findOneById(cityId);
        Studio studio = studioService.findOneById(studioId);
        model.addAttribute("city_id", cityId);
        model.addAttribute("city_name", city.getName());
        model.addAttribute("studio_id", studioId);
        model.addAttribute("studio_name", studio.getName());
        List<Specialty> specialties = specialtyService.findAllByCityId(cityId);
        model.addAttribute("specialty_list", specialties);
        return "specialty";
    }

    @RequestMapping(value = "/city={city_id}/studio={studio_id}/specialty_search")
    public String getSpecialtySearchPage(@RequestParam("search") String specialtyName,
                                         @PathVariable("city_id") Long cityId){
        Specialty specialty = specialtyService.findOneByNameAndCityId(specialtyName, cityId);
        if(specialty == null)
            return "redirect:/city={city_id}/studio={studio_id}";
        return "redirect:/city={city_id}/studio={studio_id}/specialty=" + specialty.getId();
    }

    @RequestMapping("/city={city_id}/studio={studio_id}/specialty={specialty_id}")
    public String getTeacherPage(@PathVariable(value = "city_id") Long cityId,
                                 @PathVariable(value = "studio_id") Long studioId,
                                 @PathVariable(value = "specialty_id") Long specialtyId,
                                 Model model) {
        User user = getCurrentUser(model);
        City city = cityService.findOneById(cityId);
        Studio studio = studioService.findOneById(studioId);
        Specialty specialty = specialtyService.findOneById(specialtyId);
        model.addAttribute("city_id", cityId);
        model.addAttribute("city_name", city.getName());
        model.addAttribute("studio_id", studioId);
        model.addAttribute("studio_name", studio.getName());
        model.addAttribute("specialty_id", specialtyId);
        model.addAttribute("specialty_name", specialty.getName());
        List<Teacher> teachers =
                teacherService.findAllByStudioIdAndSpecialtyNameAndCityId(studioId, specialty.getName(), cityId);
        model.addAttribute("teacher_list", teachers);
        return "teacher";
    }

    @RequestMapping(value = "/city={city_id}/studio={studio_id}/specialty={specialty_id}/teacher_search", method = RequestMethod.POST)
    public String getTeacherSearchPage(@PathVariable(value = "city_id") Long cityId,
                                       @PathVariable(value = "studio_id") Long studioId,
                                       @PathVariable(value = "specialty_id") Long specialtyId,
                                       @RequestParam("search") String lastName){
        Studio studio = studioService.findOneById(studioId);
        Teacher teacher = teacherService.findOneByStudioIdAndSpecialtyNameAndCityIdAndLastName(cityId,
                studio.getName(), specialtyId, lastName);
        if(teacher == null)
            return "redirect:/city={city_id}/studio={studio_id}/specialty={specialty_id}";
        return "/city={city_id}/studio={studio_id}/specialty={specialty_id}/teacher=" + teacher.getId();
    }

    @RequestMapping("/city={city_id}/studio={studio_id}/specialty={specialty_id}/teacher={teacher_id}")
    public String getSchedulePage(@PathVariable(value = "city_id") Long cityId,
                                  @PathVariable(value = "studio_id") Long studioId,
                                  @PathVariable(value = "specialty_id") Long specialtyId,
                                  @PathVariable(value = "teacher_id") Long teacherId,
                                  Model model) {
        User user = getCurrentUser(model);
        City city = cityService.findOneById(cityId);
        Studio studio = studioService.findOneById(studioId);
        Specialty specialty = specialtyService.findOneById(specialtyId);
        Teacher teacher = teacherService.findOneById(teacherId);
        model.addAttribute("city_id", cityId);
        model.addAttribute("city_name", city.getName());
        model.addAttribute("studio_id", studioId);
        model.addAttribute("studio_name", studio.getName());
        model.addAttribute("specialty_id", specialtyId);
        model.addAttribute("specialty_name", specialty.getName());
        model.addAttribute("teacher_id", teacherId);
        model.addAttribute("teacher_name", teacher.getFirstName() + " " + teacher.getLastName());
        setWeekDays(model, teacherId);
        return "schedule";
    }


    private User getCurrentUser(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<GrantedAuthority> authorities = (List<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        model.addAttribute("admin", false);
        for (GrantedAuthority authority : authorities) {
            if (authority.getAuthority().equals("ROLE_ADMIN"))
                model.addAttribute("admin", true);
        }
        model.addAttribute("user", user);
        return user;
    }

    private void setWeekDays(Model model, Long teacherId) {
        Schedule schedule = scheduleService.findOneByTeacherId(teacherId);
        if (schedule == null) {
            model.addAttribute("monday", "-");
            model.addAttribute("tuesday", "-");
            model.addAttribute("wednesday", "-");
            model.addAttribute("thursday", "-");
            model.addAttribute("friday", "-");
            model.addAttribute("saturday", "-");
            model.addAttribute("sunday", "-");
        } else {

            if (!schedule.getMonday().equals(""))
                model.addAttribute("monday", schedule.getMonday());
            else
                model.addAttribute("monday", "-");

            if (!schedule.getTuesday().equals(""))
                model.addAttribute("tuesday", schedule.getTuesday());
            else
                model.addAttribute("tuesday", "-");

            if (!schedule.getWednesday().equals(""))
                model.addAttribute("wednesday", schedule.getWednesday());
            else
                model.addAttribute("wednesday", "-");

            if (!schedule.getThursday().equals(""))
                model.addAttribute("thursday", schedule.getThursday());
            else
                model.addAttribute("thursday", "-");

            if (!schedule.getFriday().equals(""))
                model.addAttribute("friday", schedule.getFriday());
            else
                model.addAttribute("friday", "-");

            if (!schedule.getSaturday().equals(""))
                model.addAttribute("saturday", schedule.getSaturday());
            else
                model.addAttribute("saturday", "-");

            if (!schedule.getSunday().equals(""))
                model.addAttribute("sunday", schedule.getSunday());
            else
                model.addAttribute("sunday", "-");
        }
    }
}
