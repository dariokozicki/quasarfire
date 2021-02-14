package com.quasar.fire.rebellion.dto.TopSecret;

import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
public class SatelliteDTO {
    private String name;
    private double distance;
    @NonNull
    private List<String> message;
}