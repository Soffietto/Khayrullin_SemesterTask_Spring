package ru.kpfu.itis.khayrullin.util.transformers;

import ru.kpfu.itis.khayrullin.model.Studio;
import ru.kpfu.itis.khayrullin.util.forms.StudioForm;

import java.util.function.Function;

public class StudioFormToStudioTransformer implements Function<StudioForm, Studio> {

    @Override
    public Studio apply(StudioForm studioForm) {
        Studio studio = new Studio();
        studio.setName(studioForm.getName());
        return studio;
    }
}
