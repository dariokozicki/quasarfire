package com.quasar.fire.rebellion;

import static org.junit.jupiter.api.Assertions.*;

import com.quasar.fire.rebellion.entity.Message;
import com.quasar.fire.rebellion.exceptions.MessageException;
import com.quasar.fire.rebellion.utils.MessageHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MessageTests {
    private static List<List<String>> messages;

    @BeforeEach
    public void initialize(){
        messages = new ArrayList<>();
    }

    @Test
    public void mergeEsteEsUnMensaje() throws MessageException {
        messages.add(Arrays.asList("", "este", "es", "un", "mensaje"));
        messages.add(Arrays.asList("este", "", "un", "mensaje"));
        messages.add(Arrays.asList("" , "", "es", "", "mensaje"));
        assertEquals("este es un mensaje", new MessageHelper().getMessage(messages));
    }

    @Test
    public void mergeEsteEsUnMensajeSecreto() throws MessageException {
        messages.add(Arrays.asList("este", "", "", "mensaje", ""));
        messages.add(Arrays.asList("", "es", "", "", "secreto"));
        messages.add(Arrays.asList("este", "", "un", "", ""));
        assertEquals("este es un mensaje secreto", new MessageHelper().getMessage(messages));
    }

    @Test
    public void mergeBoquitaElMasgrande() throws MessageException {
        // probando que se puede con N mensajes
        messages.add(Arrays.asList("", "", "", "", "", "", "boquita", "", "el", "", "grande"));
        messages.add(Arrays.asList("", "es", "", "", ""));
        messages.add(Arrays.asList("", "", "", "", "", ""));
        messages.add(Arrays.asList("", "", "", "más", ""));
        assertEquals("boquita es el más grande", new MessageHelper().getMessage(messages));
    }

    @Test
    public void helperThrowsMessageExceptionWhenCorrupted() {
        messages.add(Arrays.asList("qué", "podría", "", "mal"));
        assertThrows(MessageException.class, () -> new MessageHelper().getMessage(messages));
    }
}