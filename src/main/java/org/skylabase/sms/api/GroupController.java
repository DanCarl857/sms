package org.skylabase.sms.api;

import org.skylabase.sms.domain.Group;
import org.skylabase.sms.service.GroupService;
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
@RequestMapping(value = "/api/v2/")
public class GroupController {

    @Autowired
    GroupService groupService;

    @RequestMapping(
            value = "/groups",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Group>> getGroups(){
        Collection<Group> groups = groupService.findAll();
        return new ResponseEntity<>(groups, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/groups/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Group> getUser(@PathVariable Long id){
        Group singleGroup = groupService.findOne(id);
        if(singleGroup == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(singleGroup, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/groups",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Group> createUser(@RequestBody Group group) {
        Group createGroup = groupService.create(group);
        return new ResponseEntity<>(createGroup, HttpStatus.CREATED);
    }

    @RequestMapping(
            value = "/groups/",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Group> updateUser(@RequestBody Group group){
        Group updatedGroup = groupService.update(group);
        return new ResponseEntity<>(updatedGroup, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/groups/{id}",
            method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable Long id){
        groupService.delete(id);
    }
}
