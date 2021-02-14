package com.quasar.fire.rebellion.exceptions;

import java.util.List;

public class MessageException extends Exception {
    public MessageException(List<String> messageList){
        super("The message is corrupted and cannot be restored: " + messageList.toString());
    }
}