package com.quasar.fire.rebellion.services.Cruiser;

import com.quasar.fire.rebellion.dto.requests.TopSecretRequest;
import com.quasar.fire.rebellion.dto.requests.TopSecretSplitRequest;
import com.quasar.fire.rebellion.dto.responses.TopSecretResponse;
import com.quasar.fire.rebellion.exceptions.MessageException;
import com.quasar.fire.rebellion.exceptions.TrilaterationException;

public interface ICruiserService {
    TopSecretResponse processCruiserMessages(TopSecretRequest request) throws MessageException, TrilaterationException;

    TopSecretResponse processCruiserStored() throws MessageException, TrilaterationException;

    void receiveMessage(TopSecretSplitRequest request, String satelliteName) throws Exception;
}
