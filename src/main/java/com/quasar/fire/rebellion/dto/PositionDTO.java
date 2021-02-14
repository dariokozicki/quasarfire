package com.quasar.fire.rebellion.dto;

import com.quasar.fire.rebellion.entity.Location;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PositionDTO {
    @NonNull
    Location position;
    @NonNull
    String message;
}