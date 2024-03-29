package com.quasar.fire.rebellion.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.quasar.fire.rebellion.entity.Location;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PositionDTO {
    @JsonProperty(value="position", required = true)
    @NotNull(message="Position must not be Null")
    Location position;
    @JsonProperty(value="message", required = true)
    @NotNull(message="Message must not be Null")
    String message;
}