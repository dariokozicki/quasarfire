package com.quasar.fire.rebellion.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomepageController {
    @GetMapping(value="")
    public String greetUser(){
        return "Hola! Podés probar la app realizando: <br/>" +
                "&nbspPOST /topsecret/ <br/>" +
                "&nbspGET /topsecret_split/ <br/>" +
                "&nbspPOST /topsecret_split/{satellite_name} <br/>";
    }
}