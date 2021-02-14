package com.quasar.fire.rebellion.utils;

import com.quasar.fire.rebellion.exceptions.MessageException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MessageHelper {

    public String getMessage(List<List<String>> messages) throws MessageException {
        List<String> messageList = getMessageAsList(messages);
        if (messageList.contains("")) throw new MessageException(messageList);
        return String.join(" ", messageList);
    }

    private List<String> getMessageAsList(List<List<String>> messages){
        int resultSize = getMinListSize(messages);
        return messages.stream()
                .map(message -> getTail(message, resultSize))
                .reduce(this::mergeStringList)
                .orElse(new ArrayList<>());
    }

    private <T> int getMinListSize(List<List<T>> lists){
        return lists.stream()
                .mapToInt(List::size)
                .min().orElse(lists.get(0).size());
    }

    private <T> List<T> getTail(List<T> list, int size){
        return list.subList(list.size() - size, list.size());
    }

    private List<String> mergeStringList(List<String> listA, List<String> listB){
        return IntStream.range(0, listA.size())
                .mapToObj(index -> {
                    String segmentA = listA.get(index);
                    String segmentB = listB.get(index);
                    return segmentB.isBlank() ? segmentA : segmentB;
                }).collect(Collectors.toList());
    }

}