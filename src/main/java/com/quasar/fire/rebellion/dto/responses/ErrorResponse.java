package com.quasar.fire.rebellion.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class ErrorResponse {
    @NotNull
    String description;
}