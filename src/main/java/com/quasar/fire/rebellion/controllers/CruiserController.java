package com.quasar.fire.rebellion.controllers;

import com.quasar.fire.rebellion.exceptions.MessageException;
import com.quasar.fire.rebellion.exceptions.TrilaterationException;
import com.quasar.fire.rebellion.dto.requests.TopSecretRequest;
import com.quasar.fire.rebellion.dto.responses.TopSecretResponse;
import com.quasar.fire.rebellion.services.Cruiser.ICruiserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/topsecret")
public class CruiserController {
    private final ICruiserService service;

    @Autowired
    public CruiserController(ICruiserService service){
        this.service = service;
    }

    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<TopSecretResponse> processCruiserMessage(@Valid @RequestBody TopSecretRequest request) throws TrilaterationException, MessageException {
        return new ResponseEntity<>(service.processCruiserMessages(request), HttpStatus.OK);
    }
}
