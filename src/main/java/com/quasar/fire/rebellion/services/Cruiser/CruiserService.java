package com.quasar.fire.rebellion.services.Cruiser;

import com.quasar.fire.rebellion.dao.Satellite.SatelliteDAO;
import com.quasar.fire.rebellion.dto.TopSecret.SatelliteDTO;
import com.quasar.fire.rebellion.dto.TopSecret.TopSecretRequest;
import com.quasar.fire.rebellion.dto.TopSecret.TopSecretResponse;
import com.quasar.fire.rebellion.dto.TopSecretSplit.TopSecretSplitRequest;
import com.quasar.fire.rebellion.entity.Location;
import com.quasar.fire.rebellion.entity.Message;
import com.quasar.fire.rebellion.entity.Satellite;
import com.quasar.fire.rebellion.exceptions.MessageException;
import com.quasar.fire.rebellion.exceptions.TrilaterationException;
import com.quasar.fire.rebellion.utils.MessageHelper;
import com.quasar.fire.rebellion.utils.TrilaterationHelper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Service("CruiserService")
public class CruiserService {
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

    public TopSecretResponse processCruiserMessages(TopSecretRequest request) throws MessageException, TrilaterationException {
        List<Satellite> satellites = satelliteDAO.findByNames(request.getSatelliteNames());
        setSatelliteMessages(satellites, request.getSatellites());
        return new TopSecretResponse(
            getLocation(satellites),
            getMessage(request.getMessages())
        );
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

    public TopSecretResponse processCruiserStored() throws MessageException, TrilaterationException {
        List<Satellite> satellites = satelliteDAO.findAll();
        return new TopSecretResponse(
                getLocation(satellites),
                getMessage(getMessages(satellites))
        );
    }

    private List<List<String>> getMessages(List<Satellite> satellites){
        return satellites.stream().map(sat -> sat.getMessage().getContent()).collect(Collectors.toList());
    }

    public void receiveMessage(TopSecretSplitRequest request, String satelliteName){
        Satellite satellite = satelliteDAO.findByName(satelliteName);
        satellite.setMessage(new Message(request.getMessage(),request.getDistance()));
    }
}
