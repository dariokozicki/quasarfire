package com.quasar.fire.rebellion.controllers;

import com.quasar.fire.rebellion.dto.TopSecret.TopSecretRequest;
import com.quasar.fire.rebellion.dto.TopSecret.TopSecretResponse;
import com.quasar.fire.rebellion.exceptions.MessageException;
import com.quasar.fire.rebellion.exceptions.TrilaterationException;
import com.quasar.fire.rebellion.services.Cruiser.CruiserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topsecret")
public class CruiserController {
    private final CruiserService service;

    @Autowired
    public CruiserController(CruiserService service){
        this.service = service;
    }

    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<TopSecretResponse> processCruiserMessage(@RequestBody TopSecretRequest request) throws TrilaterationException, MessageException {
        return new ResponseEntity<>(service.processCruiserMessages(request), HttpStatus.OK);
    }
}
