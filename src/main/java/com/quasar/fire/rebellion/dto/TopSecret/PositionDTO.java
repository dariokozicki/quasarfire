package com.quasar.fire.rebellion.dto.TopSecret;

import com.quasar.fire.rebellion.entity.Location;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class PositionDTO {
    @NonNull
    Location position;
    @NonNull
    String message;
}