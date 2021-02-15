package com.quasar.fire.rebellion.dto.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.quasar.fire.rebellion.dto.SatelliteDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TopSecretRequest {
    @JsonProperty(value="satellites", required = true)
    @NotNull(message="Satellites must not be Null")
    List<SatelliteDTO> satellites;

    public List<String> getSatelliteNames(){
        return satellites.stream().map(SatelliteDTO::getName).collect(Collectors.toList());
    }

    public List<List<String>> getMessages(){
        return satellites.stream().map(SatelliteDTO::getMessage).collect(Collectors.toList());
    }

}