package com.quasar.fire.rebellion.dto;

import lombok.Data;
import java.util.List;

@Data
public class SatelliteDTO {
    private String name;
    private double distance;
    private List<String> message;
}