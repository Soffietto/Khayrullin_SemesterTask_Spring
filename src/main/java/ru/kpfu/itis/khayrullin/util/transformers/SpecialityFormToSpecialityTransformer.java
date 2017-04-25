package ru.kpfu.itis.khayrullin.util.transformers;

import ru.kpfu.itis.khayrullin.model.Specialty;
import ru.kpfu.itis.khayrullin.service.CityService;
import ru.kpfu.itis.khayrullin.util.forms.SpecialityForm;

import java.util.function.Function;

public class SpecialityFormToSpecialityTransformer implements Function<SpecialityForm, Specialty> {

    @Override
    public Specialty apply(SpecialityForm specialityForm) {
        Specialty specialty = new Specialty();
        specialty.setName(specialityForm.getName());
        return specialty;
    }
}
