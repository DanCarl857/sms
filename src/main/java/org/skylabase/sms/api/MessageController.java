package org.skylabase.sms.api;

import org.skylabase.sms.domain.Message;
import org.skylabase.sms.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by daniel on 1/27/17.
 */
@RestController
@RequestMapping(value = "/api/v2/")
public class MessageController {

    @Autowired
    MessageService messageService;

    @RequestMapping(
            value = "/messages",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Message>> getGroups(){
        Collection<Message> messages = messageService.findAll();
        return new ResponseEntity<>(messages, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/messages/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Message> getUser(@PathVariable Long id){
        Message singleGroup = messageService.findOne(id);
        return new ResponseEntity<>(singleGroup, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/messages",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Message> createUser(@RequestBody Message group) {
        Message createGroup = messageService.create(group);
        return new ResponseEntity<>(createGroup, HttpStatus.CREATED);
    }

    @RequestMapping(
            value = "/messages/{id}",
            method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable Long id){
        messageService.delete(id);
    }
}
