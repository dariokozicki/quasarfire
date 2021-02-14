package com.quasar.fire.rebellion.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Satellite {
    private String name;
    private Location location;
    private Message message;

    public Satellite(String name, Location location){
        this.name = name;
        this.location = location;
    }

    public double getPosX() {
        return location.getPosX();
    }

    public double getPosY() {
        return location.getPosY();
    }
}
