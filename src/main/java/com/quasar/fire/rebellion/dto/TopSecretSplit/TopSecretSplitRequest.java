package com.quasar.fire.rebellion.dto.TopSecretSplit;

import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
public class TopSecretSplitRequest {
    private double distance;
    @NonNull
    private List<String> message;
}