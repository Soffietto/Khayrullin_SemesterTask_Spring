package ru.kpfu.itis.khayrullin.controller;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.khayrullin.model.*;
import ru.kpfu.itis.khayrullin.service.*;
import ru.kpfu.itis.khayrullin.util.forms.*;
import ru.kpfu.itis.khayrullin.util.transformers.*;

import java.util.List;
import java.util.function.Function;

@Controller
public class AdminController {

    private final CityService cityService;
    private final SpecialtyService specialtyService;
    private final TeacherService teacherService;
    private final StudioService studioService;
    private final ScheduleService scheduleService;
    private final Function<CityForm, City> cityTransfromer;
    private final Function<SpecialtyForm, Specialty> specialtyTransformer;
    private final Function<TeacherForm, Teacher> teacherTransformer;
    private final Function<StudioForm, Studio> studioTransformer;
    private final Function<ScheduleForm, Schedule> scheduleTransformer;

    public AdminController(CityService cityService, SpecialtyService specialtyService,
                          TeacherService teacherService, StudioService studioService,
                          ScheduleService scheduleService) {
        this.cityService = cityService;
        this.specialtyService = specialtyService;
        this.teacherService = teacherService;
        this.studioService = studioService;
        this.scheduleService = scheduleService;
        this.scheduleTransformer = new ScheduleFormToScheduleTransformer();
        this.specialtyTransformer = new SpecialtyFormToSpecialtyTransformer();
        this.teacherTransformer = new TeacherFormToTeahcerTransformer();
        this.studioTransformer = new StudioFormToStudioTransformer();
        this.cityTransfromer = new CityFormToCityTransformer();
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
        return "redirect:/home";
    }

    @RequestMapping(value = "/admin/delete_city", method = RequestMethod.POST)
    public String getDeleteCityPage(@RequestParam("delete_button") Long deleteButton){
        cityService.delete(deleteButton);
        return "redirect:/home";
    }

    @RequestMapping("/admin/city={city_id}/new_studio")
    public String getNewStudioPage(@PathVariable("city_id") Long cityId, Model model){
        User user = getCurrentUser(model);
        City city = cityService.findOneById(cityId);
        model.addAttribute("city_name", city.getName());
        model.addAttribute("city_id", cityId);
        model.addAttribute("studio", new StudioForm());
        return "studio_form";
    }

    @RequestMapping(value = "/admin/city={city_id}/new_studio", method = RequestMethod.POST)
    public String getNewStudioPage(@PathVariable("city_id") Long cityId,
                                   @ModelAttribute("studio") StudioForm studioForm){
        Studio studio = studioTransformer.apply(studioForm);
        City city = cityService.findOneById(cityId);
        studio.setCity(city);
        if(!studioService.getAll().contains(studio))
            studioService.add(studio);
        return "redirect:/city={city_id}";
    }

    @RequestMapping(value = "/admin/city={city_id}/delete_studio", method = RequestMethod.POST)
    public String getDeleteStudioPage(@RequestParam("delete_button") Long deleteButton){
        studioService.delete(deleteButton);
        return "redirect:/city={city_id}";
    }

    @RequestMapping("/admin/city={city_id}/studio={studio_id}/new_specialty")
    public String getNewSpecialtyPage(@PathVariable(value = "city_id") Long cityId,
                                      @PathVariable(value = "studio_id") Long studioId,
                                      Model model){
        User user = getCurrentUser(model);
        City city = cityService.findOneById(cityId);
        Studio studio = studioService.findOneById(studioId);
        model.addAttribute("city_name", city.getName());
        model.addAttribute("city_id", cityId);
        model.addAttribute("studio_name", studio.getName());
        model.addAttribute("studio_id", studioId);
        model.addAttribute("specialty", new SpecialtyForm());
        return "specialty_form";
    }

    @RequestMapping(value = "/admin/city={city_id}/studio={studio_id}/new_specialty", method = RequestMethod.POST)
    public String getNewSpecialtyPage(@PathVariable("city_id") Long cityId,
                                      @PathVariable("studio_id") Long studioId,
                                      @ModelAttribute("specialty") SpecialtyForm specialtyForm){
        Specialty specialty = specialtyTransformer.apply(specialtyForm);
        City city = cityService.findOneById(cityId);
        specialty.setCity(city);
        if(!specialtyService.getAll().contains(specialty))
            specialtyService.add(specialty);
        return "redirect:/city={city_id}/studio={studio_id}";
    }

    @RequestMapping(value = "/admin/city={city_id}/studio={studio_id}/delete_specialty", method = RequestMethod.POST)
    public String getDeleteSpecialtyPage(@RequestParam("delete_button") Long deleteButton){
        specialtyService.delete(deleteButton);
        return "redirect:/city={city_id}/studio={studio_id}";
    }
    @RequestMapping("/admin/city={city_id}/studio={studio_id}/specialty={specialty_id}/new_teacher")
    public String getNewTeacherPage(@PathVariable("city_id") Long cityId,
                                    @PathVariable("studio_id") Long studioId,
                                    @PathVariable("specialty_id")Long specialtyId,
                                    Model model){
        User user = getCurrentUser(model);
        City city = cityService.findOneById(cityId);
        Studio studio = studioService.findOneById(studioId);
        Specialty specialty = specialtyService.findOneById(specialtyId);
        model.addAttribute("city_name", city.getName());
        model.addAttribute("city_id",cityId);
        model.addAttribute("studio_name", studio.getName());
        model.addAttribute("studio_id", studioId);
        model.addAttribute("specialty_name", specialty.getName());
        model.addAttribute("specialty_id", specialtyId);
        model.addAttribute("teacher", new TeacherForm());
        return "teacher_form";
    }

    @RequestMapping(value = "/admin/city={city_id}/studio={studio_id}/specialty={specialty_id}/new_teacher", method = RequestMethod.POST)
    public String getNewTeacherPage(@PathVariable("city_id") Long cityId,
                                    @PathVariable("studio_id") Long studioId,
                                    @PathVariable("specialty_id") Long specialtyId,
                                    @ModelAttribute("teacher") TeacherForm teacherForm){
        Teacher teacher = teacherTransformer.apply(teacherForm);
        City city = cityService.findOneById(cityId);
        Studio studio = studioService.findOneById(studioId);
        Specialty specialty = specialtyService.findOneById(specialtyId);
        teacher.setCity(city);
        teacher.setStudio(studio);
        teacher.setSpecialty(specialty);
        if(!teacherService.getAll().contains(teacher))
            teacherService.add(teacher);
        return "redirect:/city={city_id}/studio={studio_id}/specialty={specialty_id}";
    }


    @RequestMapping(value = "/admin/city={city_id}/studio={studio_id}/specialty={specialty_id}/delete_teacher", method = RequestMethod.POST)
    public String getDeleteTeacherPage(@RequestParam("delete_button") Long deleteButton){
        teacherService.delete(deleteButton);
        return "redirect:/city={city_id}/studio={studio_id}/specialty={specialty_id}";
    }

    @RequestMapping("/admin/city={city_id}/studio={studio_id}/specialty={specialty_id}/teacher={teacher_id}/new_schedule")
    public String getNewSChedulePage(@PathVariable("city_id") Long cityId,
                                     @PathVariable("studio_id") Long studioId,
                                     @PathVariable("specialty_id")Long specialtyId,
                                     @PathVariable("teacher_id") Long teacherId,
                                     Model model){
        User user = getCurrentUser(model);
        City city = cityService.findOneById(cityId);
        Studio studio = studioService.findOneById(studioId);
        Specialty specialty = specialtyService.findOneById(specialtyId);
        Teacher teacher = teacherService.findOneById(teacherId);
        model.addAttribute("city_name", city.getName());
        model.addAttribute("city_id",cityId);
        model.addAttribute("studio_name", studio.getName());
        model.addAttribute("studio_id", studioId);
        model.addAttribute("specialty_name", specialty.getName());
        model.addAttribute("specialty_id", specialtyId);
        model.addAttribute("teacher_name", teacher.getFirstName() + " " + teacher.getLastName());
        model.addAttribute("teacher_id", teacherId);
        model.addAttribute("schedule", new ScheduleForm());
        return "schedule_form";
    }

    @RequestMapping(value = "/admin/city={city_id}/studio={studio_id}/specialty={specialty_id}/teacher={teacher_id}/new_schedule", method = RequestMethod.POST)
    public String getNewSchedulePage(@PathVariable("city_id") Long cityId,
                                     @PathVariable("studio_id") Long studioId,
                                     @PathVariable("specialty_id") Long specialtyId,
                                     @PathVariable("teacher_id") Long teacherId,
                                     @ModelAttribute("schedule") ScheduleForm scheduleForm){
        Schedule schedule = scheduleTransformer.apply(scheduleForm);
        Teacher teacher = teacherService.findOneById(teacherId);
        schedule.setTeacher(teacher);
        List<Schedule> schedules = scheduleService.getAll();
        for (Schedule i: schedules) {
            if(i.getTeacher().getId().equals(teacherId))
                scheduleService.deleteByTeacherId(teacherId);
        }
        scheduleService.add(schedule);
        return "redirect:/city={city_id}/studio={studio_id}/specialty={specialty_id}/teacher={teacher_id}";
    }

    private User getCurrentUser(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<GrantedAuthority> authorities = (List<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        model.addAttribute("admin", false);
        for (GrantedAuthority authority: authorities) {
            if(authority.getAuthority().equals("ROLE_ADMIN"))
                model.addAttribute("admin", true);
        }
        model.addAttribute("user", user);
        return user;
    }
}
