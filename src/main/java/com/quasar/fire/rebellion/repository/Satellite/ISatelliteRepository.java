package com.quasar.fire.rebellion.repository.Satellite;

import com.quasar.fire.rebellion.entity.Satellite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ISatelliteRepository extends JpaRepository<Satellite, Long> {
	Satellite getByName(String name);
	List<Satellite> getByNameIn(List<String> names);
}