package org.skylabase.sms.api;

import org.skylabase.sms.domain.Receiver;
import org.skylabase.sms.service.ReceiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by daniel on 1/26/17.
 */
@RestController
@RequestMapping(value = "/ap1/v2/", produces = MediaType.APPLICATION_JSON_VALUE)
public class ReceiverController {

    @Autowired
    ReceiverService receiverService;

    @RequestMapping(
            value = "/users/{userId}/receivers",
            method = RequestMethod.GET)
    public ResponseEntity<Collection<Receiver>> getReceivers(@PathVariable(value = "userId")Long id){
        Collection<Receiver> receivers = receiverService.findAll();

        return new ResponseEntity<Collection<Receiver>>(receivers, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{userId}/receivers/{recId}",
            method = RequestMethod.GET)
    public ResponseEntity<Receiver> getReceiver(@PathVariable(value = "userId")Long uid, @PathVariable(value = "recId")Long id){
        Receiver rec = receiverService.findOne(id);

        return new ResponseEntity<Receiver>(rec, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{userId}/receivers",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Receiver> createReceiver(@RequestBody Receiver rec){

        if(rec == null){
            return new ResponseEntity<Receiver>(rec, HttpStatus.BAD_REQUEST);
        }
        Receiver createRec = receiverService.create(rec);
        return new ResponseEntity<Receiver>(createRec, HttpStatus.CREATED);
    }

    @RequestMapping(
            value = "/{userId}/receivers",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Receiver> updateReceiver(@RequestBody Receiver rec){

        if(rec == null){
            return new ResponseEntity<Receiver>(rec, HttpStatus.BAD_REQUEST);
        }
        Receiver updateReceiver = receiverService.update(rec);
        if(updateReceiver == null) {
            return new ResponseEntity<Receiver>(updateReceiver, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Receiver>(updateReceiver, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{userId}/receivers/{recId}",
            method = RequestMethod.DELETE)
    public ResponseEntity deleteReceiver(@PathVariable(value = "recId") Long id){
        receiverService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
