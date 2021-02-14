package com.quasar.fire.rebellion.requests;

import com.quasar.fire.rebellion.dto.SatelliteDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class TopSecretRequest {
    @NonNull
    List<SatelliteDTO> satellites;

    public List<String> getSatelliteNames(){
        return satellites.stream().map(SatelliteDTO::getName).collect(Collectors.toList());
    }

    public List<List<String>> getMessages(){
        return satellites.stream().map(SatelliteDTO::getMessage).collect(Collectors.toList());
    }

}