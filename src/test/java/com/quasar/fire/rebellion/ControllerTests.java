package com.quasar.fire.rebellion;

import com.quasar.fire.rebellion.controllers.CruiserController;
import com.quasar.fire.rebellion.controllers.CruiserSplitController;
import com.quasar.fire.rebellion.controllers.ExceptionController;
import com.quasar.fire.rebellion.controllers.HomepageController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ControllerTests {
    @Autowired
    private CruiserController cruiserController;
    @Autowired
    private HomepageController homepageController;
    @Autowired
    private ExceptionController exceptionController;
    @Autowired
    private CruiserSplitController cruiserSplitController;

    @Test
    public void contextLoads(){
        assertNotNull(cruiserController);
        assertNotNull(homepageController);
        assertNotNull(exceptionController);
        assertNotNull(cruiserSplitController);
    }
}
