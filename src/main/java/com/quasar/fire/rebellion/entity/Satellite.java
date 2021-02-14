package com.quasar.fire.rebellion.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Satellite {
    private String name;
    private Location location;

    public double getPosX() {
        return location.getPosX();
    }

    public double getPosY() {
        return location.getPosY();
    }
}
