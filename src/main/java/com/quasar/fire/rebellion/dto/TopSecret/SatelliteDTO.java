package com.quasar.fire.rebellion.dto.TopSecret;

import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
public class SatelliteDTO {
    @NonNull
    private String name;
    @NonNull
    private double distance;
    @NonNull
    private List<String> message;
}