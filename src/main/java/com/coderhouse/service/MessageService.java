package com.coderhouse.service;

import com.coderhouse.model.Message;

import java.util.List;

public interface MessageService {

    Message create(Message message);
    List<Message> findAll();
    Message getMessageById(Long id);

}
