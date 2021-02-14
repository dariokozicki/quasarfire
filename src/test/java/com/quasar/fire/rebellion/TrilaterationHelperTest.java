package com.quasar.fire.rebellion;
import com.quasar.fire.rebellion.entity.Location;
import com.quasar.fire.rebellion.entity.Message;
import com.quasar.fire.rebellion.entity.Satellite;
import static org.junit.jupiter.api.Assertions.*;

import com.quasar.fire.rebellion.utils.TrilaterationHelper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class TrilaterationHelperTest {
    private static Satellite kenobi;
    private static Satellite skywalker;
    private static Satellite sato;

    @BeforeAll
    static void initialize(){
        kenobi = new Satellite("kenobi", new Location(-500, -200));
        skywalker = new Satellite("skywalker", new Location(100, -100));
        sato = new Satellite("sato", new Location(500, 100));
    }

    @Test
    public void getLocationBasedOnDistances(){
        double distanceKenobi = 707.1067812, distanceSkywalker = 781.0249676, distanceSato = 984.8857802;
        Location calculatedLocation =  new TrilaterationHelper(
                new Message(kenobi, distanceKenobi),
                new Message(skywalker, distanceSkywalker),
                new Message(sato, distanceSato)
        ).getLocation();
        assertEquals(-400, calculatedLocation.getPosX(), 0.001d);
        assertEquals(500, calculatedLocation.getPosY(), 0.001d);
    }
}