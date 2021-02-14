package com.quasar.fire.rebellion.services.Intelligence;

import com.quasar.fire.rebellion.entity.Location;
import com.quasar.fire.rebellion.exceptions.MessageException;

import java.util.List;

public interface IntelligenceService {
        Location getLocation(float distanceA, float distanceB, float distanceC);
        String getMessage(List<List<String>> messages) throws MessageException;
}
