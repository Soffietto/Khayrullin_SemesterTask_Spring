package ru.kpfu.itis.khayrullin.util.transformers;

import ru.kpfu.itis.khayrullin.model.Specialty;
import ru.kpfu.itis.khayrullin.util.forms.SpecialtyForm;

import java.util.function.Function;

public class SpecialtyFormToSpecialtyTransformer implements Function<SpecialtyForm, Specialty> {

    @Override
    public Specialty apply(SpecialtyForm specialtyForm) {
        Specialty specialty = new Specialty();
        specialty.setName(specialtyForm.getName());
        return specialty;
    }
}
