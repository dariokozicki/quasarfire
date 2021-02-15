package com.quasar.fire.rebellion.controllers;

import com.quasar.fire.rebellion.exceptions.MessageException;
import com.quasar.fire.rebellion.exceptions.TrilaterationException;
import com.quasar.fire.rebellion.dto.requests.TopSecretSplitRequest;
import com.quasar.fire.rebellion.dto.responses.TopSecretResponse;
import com.quasar.fire.rebellion.services.Cruiser.ICruiserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/topsecret_split")
public class CruiserSplitController {
    private final ICruiserService service;

    @Autowired
    public CruiserSplitController(ICruiserService service){
        this.service = service;
    }

    @GetMapping("/")
    public ResponseEntity<TopSecretResponse> getCruiserMessage() throws TrilaterationException, MessageException {
        return new ResponseEntity<>(service.processCruiserStored(), HttpStatus.OK);
    }

    @PostMapping("/{satellite_name}")
    public ResponseEntity<HttpStatus> postCruiserMessage(@Valid @RequestBody TopSecretSplitRequest request,@Valid @PathVariable("satellite_name") String name) throws Exception {
        service.receiveMessage(request, name);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}