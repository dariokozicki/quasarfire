package com.quasar.fire.rebellion.dto;

import com.quasar.fire.rebellion.entity.Location;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PositionDTO {
    Location position;
    String message;
}