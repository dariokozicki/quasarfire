package com.quasar.fire.rebellion.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@Data
@NoArgsConstructor
public class SatelliteDTO {
    private String name;
    private double distance;
    @NonNull
    private List<String> message;
}