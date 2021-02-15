package com.quasar.fire.rebellion.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SatelliteDTO {
    @JsonProperty(value="name", required = true)
    @NotNull(message="Name must not be Null")
    private String name;
    @JsonProperty(value="distance", required = true)
    @NotNull(message="Distance must not be Null")
    private Double distance;
    @JsonProperty(value="message", required = true)
    @NotNull(message="Message must not be Null")
    private List<String> message;
}