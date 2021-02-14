package com.quasar.fire.rebellion.controllers;

import com.quasar.fire.rebellion.dto.TopSecretRequest;
import com.quasar.fire.rebellion.services.Intelligence.IntelligenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/topsecret")
public class IntelligenceController {
    private IntelligenceService service;

    @Autowired
    public IntelligenceController(IntelligenceService service){
        this.service = service;
    }

    @PostMapping(path = "/")
    public void getCruiserMessage(@RequestBody TopSecretRequest request) {
        //todo
    }
}
