package ru.kpfu.itis.khayrullin.util.transformers;

import ru.kpfu.itis.khayrullin.model.City;
import ru.kpfu.itis.khayrullin.util.forms.CityForm;

import java.util.function.Function;

public class CityFormToCityTransformer implements Function<CityForm, City> {
    @Override
    public City apply(CityForm cityForm) {
        City city = new City();
        city.setName(cityForm.getName());
        return city;
    }
}
