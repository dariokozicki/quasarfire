package com.quasar.fire.rebellion.services.Cruiser;

import com.quasar.fire.rebellion.dao.Satellite.SatelliteDAO;
import com.quasar.fire.rebellion.dto.SatelliteDTO;
import com.quasar.fire.rebellion.entity.Location;
import com.quasar.fire.rebellion.entity.Message;
import com.quasar.fire.rebellion.entity.Satellite;
import com.quasar.fire.rebellion.exceptions.MessageException;
import com.quasar.fire.rebellion.exceptions.TrilaterationException;
import com.quasar.fire.rebellion.dto.requests.TopSecretRequest;
import com.quasar.fire.rebellion.dto.requests.TopSecretSplitRequest;
import com.quasar.fire.rebellion.dto.responses.TopSecretResponse;
import com.quasar.fire.rebellion.utils.MessageHelper;
import com.quasar.fire.rebellion.utils.TrilaterationHelper;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Service("CruiserService")
public class CruiserService implements ICruiserService {
    private static final Logger logger = LoggerFactory.getLogger(CruiserService.class);

    private SatelliteDAO satelliteDAO;

    @Autowired
    public CruiserService(SatelliteDAO satelliteDAO){
        this.satelliteDAO = satelliteDAO;
    }

    public Location getLocation(List<Satellite> satellites) throws TrilaterationException {
        return new TrilaterationHelper(satellites).getLocation();
    }

    public String getMessage(List<List<String>> messages) throws MessageException {
        return new MessageHelper().getMessage(messages);
    }

    @Override
    public TopSecretResponse processCruiserMessages(TopSecretRequest request) throws MessageException, TrilaterationException {
        logger.info("Received request to process a cruiser's message and location");
        List<Satellite> satellites = satelliteDAO.findByNames(request.getSatelliteNames());
        setSatelliteMessages(satellites, request.getSatellites());
        TopSecretResponse res = new TopSecretResponse(
            getLocation(satellites),
            getMessage(request.getMessages())
        );
        logger.info("Request to process a cruiser's message and location completed successfully");
        return res;
    }

    private void setSatelliteMessages(List<Satellite> satellites, List<SatelliteDTO> dtos){
        satellites.forEach(sat -> {
            dtos.stream()
                .filter(dto -> dto.getName().equals(sat.getName())).findAny()
                .ifPresent(dto -> {
                    sat.setMessage(new Message(dto.getMessage(),dto.getDistance()));
                });
        });
    }

    @Override
    public TopSecretResponse processCruiserStored() throws MessageException, TrilaterationException {
        logger.info("Received request to process the satellites' current messages and locations");
        List<Satellite> satellites = satelliteDAO.findAll();
        TopSecretResponse res = new TopSecretResponse(
                getLocation(satellites),
                getMessage(getMessages(satellites))
        );
        logger.info("Request to process current messages and locations completed successfully");
        return res;
    }

    private List<List<String>> getMessages(List<Satellite> satellites){
        return satellites.stream().map(sat -> sat.getMessage().getContent()).collect(Collectors.toList());
    }

    @Override
    public void receiveMessage(TopSecretSplitRequest request, String satelliteName) throws Exception {
        logger.info("Received request to set " + satelliteName + "'s message to " + request.getMessage());
        Satellite satellite = satelliteDAO.findByName(satelliteName);
        satellite.setMessage(new Message(request.getMessage(),request.getDistance()));
        logger.info(satelliteName + "'s message was successfully set to " + request.getMessage());
    }
}
