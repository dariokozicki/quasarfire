package com.quasar.fire.rebellion.dto.TopSecretSplit;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@Data
@NoArgsConstructor
public class TopSecretSplitRequest {
    private double distance;
    @NonNull
    private List<String> message;
}