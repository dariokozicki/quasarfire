package com.quasar.fire.rebellion.services.Intelligence;

import com.quasar.fire.rebellion.entity.Location;
import com.quasar.fire.rebellion.entity.Message;
import com.quasar.fire.rebellion.entity.Satellite;
import com.quasar.fire.rebellion.exceptions.MessageException;
import com.quasar.fire.rebellion.utils.MessageHelper;
import com.quasar.fire.rebellion.utils.TrilaterationHelper;
import lombok.Data;
import org.springframework.stereotype.Service;
import java.util.List;

@Data
@Service("IntelligenceServiceImpl")
public class IntelligenceServiceImpl implements IntelligenceService {
    Satellite kenobi, skywalker, sato;

    public Location getLocation(float distanceA, float distanceB, float distanceC) {
        return new TrilaterationHelper(
                new Message(kenobi, distanceA),
                new Message(skywalker, distanceB),
                new Message(sato, distanceC)
        ).getLocation();
    }

    public String getMessage(List<List<String>> messages) throws MessageException {
        return new MessageHelper().getMessage(messages);
    }
}
