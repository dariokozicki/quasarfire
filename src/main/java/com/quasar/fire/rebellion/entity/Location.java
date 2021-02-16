package com.quasar.fire.rebellion.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity @Table
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    @Column
    private double posX;
    @Column
    private double posY;

    public Location(double posX, double posY){
        this.posX = posX;
        this.posY = posY;
    }
}
