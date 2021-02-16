package com.quasar.fire.rebellion.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity @Table
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ElementCollection
    private List<String> content;
    @Column
    private double distance;

    public Message(List<String> content, double distance){
        this.content = content;
        this.distance = distance;
    }
}
