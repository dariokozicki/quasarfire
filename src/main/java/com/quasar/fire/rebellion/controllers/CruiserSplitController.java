package com.quasar.fire.rebellion.controllers;

import com.quasar.fire.rebellion.dto.TopSecret.TopSecretResponse;
import com.quasar.fire.rebellion.dto.TopSecretSplit.TopSecretSplitRequest;
import com.quasar.fire.rebellion.exceptions.MessageException;
import com.quasar.fire.rebellion.exceptions.TrilaterationException;
import com.quasar.fire.rebellion.services.Cruiser.CruiserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topsecret_split")
public class CruiserSplitController {
    private final CruiserService service;

    @Autowired
    public CruiserSplitController(CruiserService service){
        this.service = service;
    }

    @GetMapping("/")
    public ResponseEntity<TopSecretResponse> processCruiserMessage() throws TrilaterationException, MessageException {
        return new ResponseEntity<>(service.processCruiserStored(), HttpStatus.OK);
    }

    @PostMapping("/{satellite_name}")
    public ResponseEntity<HttpStatus> processCruiserMessage(@RequestBody TopSecretSplitRequest request, @PathVariable("satellite_name") String name) throws Exception {
        service.receiveMessage(request, name);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}