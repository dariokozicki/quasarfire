package com.quasar.fire.rebellion.dao.Satellite;

import com.quasar.fire.rebellion.entity.Location;
import com.quasar.fire.rebellion.entity.Satellite;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SatelliteDAOMock implements SatelliteDAO {
    List<Satellite> satellites;

    public SatelliteDAOMock(){
        satellites = Arrays.asList(
            new Satellite("kenobi", new Location(-500, -200)),
            new Satellite("skywalker", new Location(100, -100)),
            new Satellite("sato", new Location(500, 100))
        );
    }

    public Satellite findByName(String name) throws Exception {
        return satellites.parallelStream().filter(sat -> sat.getName().equals(name)).findAny().orElseThrow(() -> new Exception("Satellite not found"));
    }

    @Override
    public List<Satellite> findByNames(List<String> names) {
        return satellites.parallelStream().filter(sat -> names.contains(sat.getName())).collect(Collectors.toList());
    }

    @Override
    public List<Satellite> findAll() {
        return satellites;
    }
}