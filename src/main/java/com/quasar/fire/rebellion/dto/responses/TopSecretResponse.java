package com.quasar.fire.rebellion.dto.responses;

import com.quasar.fire.rebellion.entity.Location;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TopSecretResponse {
    @NotNull
    Location position;
    @NotNull
    String message;
}