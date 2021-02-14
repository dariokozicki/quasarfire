package com.quasar.fire.rebellion.dao.Satellite;

import com.quasar.fire.rebellion.entity.Satellite;

import java.util.List;

public interface SatelliteDAO {

    Satellite findByName(String name) throws Exception;
    List<Satellite> findByNames(List<String> names);
    List<Satellite> findAll();
}