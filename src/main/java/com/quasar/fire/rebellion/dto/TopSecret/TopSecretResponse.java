package com.quasar.fire.rebellion.dto.TopSecret;

import com.quasar.fire.rebellion.entity.Location;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class TopSecretResponse {
    @NonNull
    Location location;
    @NonNull
    String message;
}