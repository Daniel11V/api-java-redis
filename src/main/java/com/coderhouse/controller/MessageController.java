package com.coderhouse.controller;

import com.coderhouse.model.Message;
import com.coderhouse.service.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/coder-house")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService service;

    @GetMapping("/mensajes/{id}")
    public Message getMensajeById(@PathVariable Long id) {
        log.info("GET obtener mensaje por el id");
        return service.getMessageById(id);
    }

    @PostMapping("/mensajes")
    public Message createMessage(@RequestBody Message message) {
        log.info("POST crear mensaje");
        return service.create(message);
    }

}
