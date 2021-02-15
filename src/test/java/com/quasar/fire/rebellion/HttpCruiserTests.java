package com.quasar.fire.rebellion;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.quasar.fire.rebellion.dto.SatelliteDTO;
import com.quasar.fire.rebellion.dto.requests.TopSecretRequest;
import com.quasar.fire.rebellion.dto.requests.TopSecretSplitRequest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class HttpCruiserTests {
    public static ObjectMapper mapper;

    @BeforeAll
    static void initialize(){
        mapper = new ObjectMapper();
        mapper.setVisibility(mapper.getSerializationConfig().getDefaultVisibilityChecker()
            .withFieldVisibility(JsonAutoDetect.Visibility.ANY)
            .withGetterVisibility(JsonAutoDetect.Visibility.NONE));
    }

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnNotFound() throws Exception{
        this.mockMvc.perform(get("/topsecret_split/")).andExpect(status().isNotFound());
    }

    @Test
    public void postCruisershouldReturnLocation() throws Exception{
        TopSecretRequest request = new TopSecretRequest(
            Arrays.asList(
                new SatelliteDTO("kenobi",707.1067812, Arrays.asList("este", "", "", "mensaje", "")),
                new SatelliteDTO("skywalker",781.0249676, Arrays.asList("", "es", "", "", "secreto")),
                new SatelliteDTO("sato",984.8857802, Arrays.asList("este", "", "un", "", ""))
            )
        );

        this.mockMvc.perform(
            post("/topsecret/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(request))
        ).andExpect(status().isOk()).andExpect(jsonPath("$.message").value("este es un mensaje secreto"));
    }

    @Test
    public void postCruiserSplitShouldReturnOK() throws Exception {
        TopSecretSplitRequest request = new TopSecretSplitRequest(
            100.0, Arrays.asList("este", "es", "un","","")
        );

        this.mockMvc.perform(
            post("/topsecret_split/kenobi")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(request))
        ).andExpect(status().isOk());
    }

    @Test
    public void getCruiserSplitShouldReturnCruiser() throws Exception {
        TopSecretSplitRequest kenobiRequest = new TopSecretSplitRequest(
            707.1067812, Arrays.asList("boquita", "es", "","","")
        );

        this.mockMvc.perform(
            post("/topsecret_split/kenobi")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(kenobiRequest))
        ).andExpect(status().isOk());

        TopSecretSplitRequest skywalkerRequest = new TopSecretSplitRequest(
            781.0249676, Arrays.asList("", "", "", "el","","grande")
        );

        this.mockMvc.perform(
            post("/topsecret_split/skywalker")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(skywalkerRequest))
        ).andExpect(status().isOk());

        TopSecretSplitRequest satoRequest = new TopSecretSplitRequest(
            984.8857802, Arrays.asList("", "", "", "","más","")
        );

        this.mockMvc.perform(
            post("/topsecret_split/sato")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(satoRequest))
        ).andExpect(status().isOk());

        this.mockMvc.perform(get("/topsecret_split/"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.message").value("boquita es el más grande"))
            .andExpect(jsonPath("$.position.posX").isNumber())
            .andExpect(jsonPath("$.position.posY").isNumber());
    }

    @Test
    public void getSplitWithoutMessagesShouldReturnNotFound() throws Exception {
        this.mockMvc.perform(get("/topsecret_split/"))
            .andExpect(status().isNotFound());
    }

}