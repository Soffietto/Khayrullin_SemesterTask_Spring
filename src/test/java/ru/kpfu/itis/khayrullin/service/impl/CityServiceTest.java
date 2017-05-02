package ru.kpfu.itis.khayrullin.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import ru.kpfu.itis.khayrullin.config.*;
import ru.kpfu.itis.khayrullin.service.CityService;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CoreConfig.class, PersistenceConfig.class}, loader = AnnotationConfigContextLoader.class)
public class CityServiceTest {

    @Autowired
    private CityService cityService;

    @Test
    public void cityServiceShouldReturnProperClassName() {
        assertEquals("class com.sun.proxy.$Proxy48", this.cityService.getClass().toString());
    }
}
