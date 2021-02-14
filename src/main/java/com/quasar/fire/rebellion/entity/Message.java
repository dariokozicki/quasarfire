package com.quasar.fire.rebellion.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
public class Message {
    private List<String> content;
    private double distance;
    private Satellite satellite;

    public Message(Satellite satellite,double distance){
        this.satellite = satellite;
        this.distance = distance;
    }

    public Message(Satellite satellite, List<String> content){
        this.satellite = satellite;
        this.content = content;
    }
}
