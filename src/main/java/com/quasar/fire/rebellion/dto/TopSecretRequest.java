package com.quasar.fire.rebellion.dto;

import lombok.Data;
import java.util.List;

@Data
public class TopSecretRequest {
    List<SatelliteDTO> satellites;
}