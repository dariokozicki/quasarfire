package com.quasar.fire.rebellion.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity @Table
public class Satellite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column()
    private String name;
    @ManyToOne(cascade=CascadeType.ALL)
    private Location location;
    @ManyToOne(cascade=CascadeType.ALL)
    private Message message;

    public Satellite(String name, Location location){
        this.name = name;
        this.location = location;
    }

    public Satellite(String name, Location location, Message message){
        this.name = name;
        this.location = location;
        this.message = message;
    }

    public double getPosX() {
        return location.getPosX();
    }

    public double getPosY() {
        return location.getPosY();
    }
}
