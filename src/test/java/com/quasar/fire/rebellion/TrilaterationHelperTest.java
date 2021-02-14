package com.quasar.fire.rebellion;
import com.quasar.fire.rebellion.entity.Location;
import com.quasar.fire.rebellion.entity.Message;
import com.quasar.fire.rebellion.entity.Satellite;
import static org.junit.jupiter.api.Assertions.*;

import com.quasar.fire.rebellion.exceptions.TrilaterationException;
import com.quasar.fire.rebellion.utils.TrilaterationHelper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


public class TrilaterationHelperTest {
    private static Satellite kenobi;
    private static Satellite skywalker;
    private static Satellite sato;

    @BeforeAll
    static void initialize(){
        kenobi = new Satellite("kenobi", new Location(-500, -200), new Message());
        skywalker = new Satellite("skywalker", new Location(100, -100), new Message());
        sato = new Satellite("sato", new Location(500, 100), new Message());
    }

    @Test
    public void getLocationBasedOnDistances() throws TrilaterationException {
        kenobi.getMessage().setDistance(707.1067812);
        skywalker.getMessage().setDistance(781.0249676);
        sato.getMessage().setDistance(984.8857802);

        Location calculatedLocation =  new TrilaterationHelper(
                Arrays.asList(kenobi, skywalker, sato)
        ).getLocation();

        assertEquals(-400, calculatedLocation.getPosX(), 0.001d);
        assertEquals(500, calculatedLocation.getPosY(), 0.001d);
    }
}