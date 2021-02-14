package com.quasar.fire.rebellion.dto.TopSecret;

import com.quasar.fire.rebellion.entity.Location;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TopSecretResponse {
    @NonNull
    Location location;
    @NonNull
    String message;
}